package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class keepAwake {

    private static final Logger log = LoggerFactory.getLogger(keepAwake.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 600000)
    public void reportCurrentTime() {
/*
        RestTemplate restTemplate = new RestTemplate();
        try {
            headers.set("Title", "value");
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange("http://sarcopenia.herokuapp.com", HttpMethod.GET, entity, String.class, "Title");
            restTemplate.getForObject("http://sarcopenia.herokuapp.com", Object.class);


        } catch (Exception e) {
            log.error(e.getMessage());
        }*/
    }

}
