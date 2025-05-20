package com.example.observability;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    private final RestTemplate client = new RestTemplate();

    @Observed(name = "demo.server.process")
    @GetMapping("/server")
    public String server() {
        return "Hello from Server";
    }

    @Observed(name = "demo.client.call")
    @GetMapping("/client")
    public String client() {
        return client.getForObject("http://app-a:8080/server", String.class);
    }
}
