package io.pivotal.books;

import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {
    public String createResponse(Book book) {
        StringBuilder sb = new StringBuilder();

        sb.append("bookId: " + book.getBookId());
        sb.append(",");
        sb.append("bookName: " + book.getBookName());

        return sb.toString();
    }
}
