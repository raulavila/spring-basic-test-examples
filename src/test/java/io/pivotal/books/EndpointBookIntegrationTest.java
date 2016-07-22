package io.pivotal.books;


import io.pivotal.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
@WebIntegrationTest(randomPort = true)
public class EndpointBookIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void bookEndpoint_ReturnsBookInfo() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:" + port + "/book?bookId=1";

        String response = restTemplate.getForObject(url, String.class);

        assertThat(response, is("bookId: 1,bookName: El Quijote"));
    }
}
