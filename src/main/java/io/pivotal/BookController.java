package io.pivotal;

import io.pivotal.books.RequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BookController {

    @Value("${test.property}")
    private String testProperty;

    private RequestProcessor requestProcessor;

    @Autowired
    public BookController(RequestProcessor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    @RequestMapping(value = "/book", method = GET)
    public String getBookInfo(@RequestParam String bookId) {
        return requestProcessor.processRequest(bookId);
    }

    @RequestMapping(value = "/seeproperty", method = GET)
    public String seeProperty() {
        return testProperty;
    }
}
