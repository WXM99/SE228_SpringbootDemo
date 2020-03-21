package ebook.controller;

import ebook.model.BookDetails;
import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.outOfDB.WholeBook;
import ebook.repository.BookRepository;
import ebook.service.BookService;
import net.sf.json.JSONObject;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
@CrossOrigin("*")
public class BookInfoController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/get_all_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> get_all_book() throws IOException {
        return this.bookService.allBook();
    }


    @RequestMapping(value = "/find_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookInfoBrief find_book(@RequestBody JSONObject input) throws IOException {
        return this.bookService.findBook(input);
    }

    @RequestMapping(value = "/find_whole_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public WholeBook find_whole_book(@RequestBody JSONObject input) throws IOException {
        return this.bookService.find(input);
    }

    @RequestMapping(value = "/find_book_with_page", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> find_book_with_page(@RequestBody JSONObject input) throws IOException {
        return this.bookService.findBookWithPage(input);
    }

    @RequestMapping(value = "/search_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> search_book(@RequestBody JSONObject input) throws IOException {
        return this.bookService.searchBook(input);
    }

    @RequestMapping(value = "/add_details", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookDetails add_details(@RequestBody JSONObject input) throws IOException {
        return this.bookService.addDetails(input);
    }

}
