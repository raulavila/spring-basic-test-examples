package io.pivotal.books;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ResponseBuilderTest {
    private ResponseBuilder responseBuilder = new ResponseBuilder();

    @Test
    public void createResponse_ReturnsBookInformation() throws Exception {
        Book book = new Book(1,"El Quijote");
        String response = responseBuilder.createResponse(book);

        assertThat(response, is("bookId: 1,bookName: El Quijote"));
    }
}
