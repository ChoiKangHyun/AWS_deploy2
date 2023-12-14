package com.lec.spring.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${server.port}")
    private String port;

    @Test
    void hello() {
        System.out.println("port: " + port);
        ResponseEntity<String> response = testRestTemplate.getForEntity("/aws/v2", String.class);
        assertThat("<h1>AWS 배포 v2</h1>").isEqualTo(response.getBody());

    }
}