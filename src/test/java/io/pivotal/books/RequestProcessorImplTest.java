package io.pivotal.books;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class RequestProcessorImplTest {

    @Mock
    private RequestBuilder requestBuilder;

    @Mock
    private BookDAO bookDAO;

    @Mock
    private ResponseBuilder responseBuilder;

    private RequestProcessor requestProcessor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        requestProcessor = new RequestProcessorImpl(requestBuilder, bookDAO, responseBuilder);
    }

    @Test
    public void processBookIdRequest_returnsBookDataAsString() throws Exception {
        String bookId = "1";
        String query = "query";
        Book book = new Book(1, "El Quijote");

        when(requestBuilder.createRequest(bookId)).thenReturn(query);
        when(bookDAO.queryBook(query)).thenReturn(book);
        when(responseBuilder.createResponse(book)).thenReturn("book data");

        String response = requestProcessor.processRequest(bookId);

        assertThat(response, Matchers.is("book data"));
    }
}