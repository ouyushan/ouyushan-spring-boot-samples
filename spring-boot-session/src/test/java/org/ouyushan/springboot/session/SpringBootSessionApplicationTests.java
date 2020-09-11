package org.ouyushan.springboot.session;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootSessionApplicationTests {

    @Test
    public void sessionExpiry() throws Exception {
        ConfigurableApplicationContext context = createContext();
        String port = context.getEnvironment().getProperty("local.server.port");
        URI uri = URI.create("http://localhost:" + port + "/");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> firstResponse = firstRequest(restTemplate, uri);
        String sessionId1 = firstResponse.getBody();
        String cookie = firstResponse.getHeaders().getFirst("Set-Cookie");
        String sessionId2 = nextRequest(restTemplate, uri, cookie).getBody();
        assertThat(sessionId1).isEqualTo(sessionId2);
        Thread.sleep(1000);
        String loginPage = nextRequest(restTemplate, uri, cookie).getBody();
        assertThat(loginPage).containsIgnoringCase("login");
    }

    private ConfigurableApplicationContext createContext() {
        ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(SpringBootSessionApplication.class)
                .properties("server.port:0", "server.servlet.session.timeout:1")
                .initializers(new ServerPortInfoApplicationContextInitializer()).run();
        return context;
    }

    private ResponseEntity<String> firstRequest(RestTemplate restTemplate, URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString("user:password".getBytes()));
        RequestEntity<Object> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        return restTemplate.exchange(request, String.class);
    }

    private ResponseEntity<String> nextRequest(RestTemplate restTemplate, URI uri, String cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);
        RequestEntity<Object> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        return restTemplate.exchange(request, String.class);
    }
}
