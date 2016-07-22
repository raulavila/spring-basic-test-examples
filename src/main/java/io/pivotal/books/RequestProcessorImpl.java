package io.pivotal.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestProcessorImpl implements RequestProcessor {

    private RequestBuilder requestBuilder;
    private BookDAO bookDAO;
    private ResponseBuilder responseBuilder;

    @Autowired
    public RequestProcessorImpl(RequestBuilder requestBuilder, BookDAO bookDAO, ResponseBuilder responseBuilder) {
        this.requestBuilder = requestBuilder;
        this.bookDAO = bookDAO;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public String processRequest(String bookId) {
        String query = requestBuilder.createRequest(bookId);

        Book book  = bookDAO.queryBook(query);

        return responseBuilder.createResponse(book);
    }
}
