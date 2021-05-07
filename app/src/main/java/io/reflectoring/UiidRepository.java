package io.reflectoring;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UiidRepository {

    RestTemplate restTemplate = new RestTemplate();

    public Uuid get(){

        return restTemplate.getForObject("https://httpbin.org/uuid", Uuid.class);
    }
}
