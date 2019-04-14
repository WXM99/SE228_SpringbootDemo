package ebook.controller;

import ebook.modal.BookInfo;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class BookInfoController {
    private BookInfo _book = new BookInfo("爱的魔力", "转圈圈", "19990622001X", "很好看", 100, 100.00);

    @RequestMapping(value = "/get_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject get_book(@RequestBody JSONObject input) throws IOException {
        System.out.println(input.get("ISBN").toString());
        JSONObject ret_book = this._book.get_book(input.get("ISBN").toString());
        return ret_book;
    }
}
