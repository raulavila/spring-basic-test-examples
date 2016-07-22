package io.pivotal.books;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RequestBuilderTest {

    private RequestBuilder requestBuilder = new RequestBuilder();

    @Test
    public void createRequestReturnsQueryForBookId() throws Exception {
        String query = requestBuilder.createRequest("1");
        assertThat(query, is("select * from book where bookId = 1"));

    }
}
