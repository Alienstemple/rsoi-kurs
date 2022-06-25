package com.services.autoparts.controller;

import org.apache.commons.logging.Log;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private final RestTemplate restTemplate;

    public MainController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private String partUri = "http://localhost:8080/";

    @RequestMapping("/")
    public String search() {
        return "parts-search";
    }

    @RequestMapping("/test-search")
    public String testSearch() {
        String test = "test";
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("username", "test");
        parameters.add("password", "test");
        restTemplate.postForObject("http://localhost:8081/register", parameters, String.class);
//        restTemplate.postForObject("http://localhost:8081/login?username={username}&password={password}", parameters, String.class);
        String jwt = restTemplate.postForObject("http://localhost:8081/login", parameters, String.class);
        System.out.println("JWT " + jwt);
        //        String plainCreds = "test:test";
//        byte[] plainCredsBytes = plainCreds.getBytes();
//        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//        String base64Creds = new String(base64CredsBytes);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + base64Creds);
//        HttpEntity<String> request = new HttpEntity<String>(headers);
//        return restTemplate.exchange(partUri+"search", HttpMethod.GET, request, String.class).getBody();
        return restTemplate.getForObject(partUri+"search", String.class);
//        return "parts-search";
    }
}
