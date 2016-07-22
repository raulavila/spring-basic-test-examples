package io.pivotal;

import io.pivotal.books.RequestProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {

    @Mock
    private RequestProcessor requestProcessor;

    private BookController bookController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        bookController = new BookController(requestProcessor);
    }

    @Test
    public void bookController_ReturnBookData() throws Exception {
        when(requestProcessor.processRequest("1")).thenReturn("book data");

        String data = bookController.getBookInfo("1");

        assertThat(data, is("book data"));
    }

    @Test
    public void bookEndpoint_returnsBookData() throws Exception {
        when(requestProcessor.processRequest("1")).thenReturn("book data");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(get("/book").param("bookId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("book data"));
    }
}
