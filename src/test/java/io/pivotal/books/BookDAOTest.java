package io.pivotal.books;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BookDAOTest {

    private BookDAO bookDAO = new BookDAO();

    @Test
    public void queryBooK_returnsBook() throws Exception {

        String query = "query";

        Book book = bookDAO.queryBook(query);

        assertThat(book.getBookId(), is(1));
        assertThat(book.getBookName(), is("El Quijote"));

    }
}
