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
import java.util.Set;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class ManageOrdersController {
    @Autowired
    private ManageOrderService manageOrderService;


    @RequestMapping(value = "/get_users_orders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Orders> get_users_orders(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByUser(input);
    }

    @RequestMapping(value = "/get_books_orders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Orders> get_books_orders(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByIsbn(input);
    }

    @RequestMapping(value = "/get_orders_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInOrder> get_users_book(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.orderBooks(input);
    }

}
