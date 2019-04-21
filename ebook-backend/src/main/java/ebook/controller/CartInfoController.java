package ebook.controller;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.service.CartService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class CartInfoController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add_to_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders add_to_cart(@RequestBody JSONObject input) throws IOException {
        return this.cartService.addToCart(input);
    }

    @RequestMapping(value = "/remove_from_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders remove_from_cart(@RequestBody JSONObject input) throws IOException {
        return this.cartService.removeFromCart(input);
    }

    @RequestMapping(value = "/clear_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders clear_cart(@RequestBody JSONObject input) throws IOException {
        return this.cartService.clearCart(input);
    }

    @RequestMapping(value = "/ensure_payment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BookInOrder ensure_payment(@RequestBody JSONObject input) throws IOException {
        Orders cart = this.cartService.giveCart(input);
        BookInOrder lack = this.cartService.ensurePayment(cart);
        if (lack == null) {
            BookInOrder succ = new BookInOrder();
            succ.amount = 200;
            return succ;
        } else {
            return lack;
        }
    }


    @RequestMapping(value = "/get_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInfoBrief> get_cart(@RequestBody JSONObject input) throws IOException {
        Orders cart = this.cartService.giveCart(input);
        return this.cartService.findBooksByOrder(cart);
    }


}
