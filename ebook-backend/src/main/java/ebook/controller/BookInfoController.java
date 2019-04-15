package ebook.controller;

import ebook.modal.BookInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class BookInfoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BookInfo _book = new BookInfo("爱的魔力", "转圈圈", "19990622001X", "很好看", 100, 100.00);

    @RequestMapping(value = "/get_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Map<String, Object>> get_book(@RequestBody JSONObject input) throws IOException {
        String isbn = (String) input.get("ISBN");
        String sql = "select * from  book_brief where ISBN='" + isbn + "';";
        List<Map<String, Object>> res = this.jdbcTemplate.queryForList(sql);
        return res;
    }
}
