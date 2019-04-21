package ebook.controller;


import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.service.ManageOrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class StatisticsController {
    @Autowired
    private ManageOrderService manageOrderService;

    @RequestMapping(value = "/get_user_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Orders> get_user_order(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByUser(input);
    }

    @RequestMapping(value = "/get_book_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Orders> get_book_order(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByIsbn(input);
    }

    @RequestMapping(value = "/get_order_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> get_user_book(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.orderBooks(input);
    }
}
