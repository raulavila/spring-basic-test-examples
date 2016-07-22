package io.pivotal.books;

import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {
    public String createRequest(String bookId) {
        return "select * from book where bookId = " + bookId;
    }
}
