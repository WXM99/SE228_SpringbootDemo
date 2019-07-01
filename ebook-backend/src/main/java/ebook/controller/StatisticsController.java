package ebook.controller;


import ebook.model.BookInOrder;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.service.ManageOrderService;
import ebook.service.ManageUserService;
import java.text.ParseException;
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
    @Autowired
    private ManageUserService manageUserService;

    @RequestMapping(value = "/get_user_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Orders> get_user_order(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByUser(input);
    }

    @RequestMapping(value = "/get_user_order_by_date", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Orders> get_user_order_by_date(@RequestBody JSONObject input) throws ParseException {
        return this.manageOrderService.findUserOrderInDate (input);
    }

    @RequestMapping(value = "/get_book_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Orders> get_book_order(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.findOrdersByIsbn(input);
    }

    @RequestMapping(value = "/get_book_order_by_date", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Set<Orders> get_book_order_by_date(@RequestBody JSONObject input) throws ParseException {
        return this.manageOrderService.findOrdersByIsbnInDate (input);
    }

    @RequestMapping(value = "/get_order_book", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInOrder> get_user_book(@RequestBody JSONObject input) throws IOException {
        return this.manageOrderService.orderBooks(input);
    }

    @RequestMapping(value = "/search_user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<UserEntity> search_user(@RequestBody JSONObject input) throws IOException {
        return this.manageUserService.searchUser(input);
    }
}
