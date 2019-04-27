package ebook.controller;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.repository.BookRepository;
import ebook.service.BookService;
import ebook.service.ManageBookService;
import ebook.service.ManageUserService;
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
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class ManageBookController {

    @Autowired
    private ManageBookService manageBookService;

    @RequestMapping(value = "/get_all_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> get_all_book() throws IOException {
        return this.manageBookService.allBook();
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookInfoBrief add_book(@RequestBody JSONObject new_book) throws IOException {
        return this.manageBookService.addBook(new_book);
    }

    @RequestMapping(value = "/update_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookInfoBrief update_book(@RequestBody JSONObject new_book) throws IOException {
        return this.manageBookService.updateBook(new_book);
    }

    @RequestMapping(value = "/delete_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookInfoBrief delete_book(@RequestBody JSONObject input) throws IOException {
        return this.manageBookService.deleteBook(input);
    }
}
