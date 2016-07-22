package io.pivotal.books;

import io.pivotal.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class RequestProcessorIntegrationTest {

    @Autowired
    private RequestProcessor requestProcessor;

    @Test
    public void requestProcessor_ReturnsBookData() throws Exception {
        String response = requestProcessor.processRequest("1");

        assertThat(response, is("bookId: 1,bookName: El Quijote"));
    }
}
