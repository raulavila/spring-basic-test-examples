package io.pivotal.books;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    public Book queryBook(String query) {
        return new Book(1, "El Quijote");
    }
}
