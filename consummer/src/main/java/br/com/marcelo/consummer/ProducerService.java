package br.com.marcelo.consummer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ProducerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Lazy
    private EurekaClient discoveryClient;

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        return this.restTemplate.getForObject(URI.create(serviceUrl() + "recommended"), String.class);
    }

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("RECOMMENDED", false);
        return instance.getHomePageUrl();
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }

    @HystrixCommand(fallbackMethod = "reliableBuy")
    public String buy() {
        return this.restTemplate.getForObject(URI.create(serviceUrl() + "buy"), String.class);
    }

    public String reliableBuy() {
        return "Any Java 8 Book";
    }
}
