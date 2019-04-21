package ebook.controller;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.service.ManageOrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private ManageOrderService manageOrderService;


    @RequestMapping(value = "/get_my_orders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Orders> get_users_orders(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByUser(input);
    }

    @RequestMapping(value = "/get_my_books_in_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> get_users_book(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.orderBooks(input);
    }

}
