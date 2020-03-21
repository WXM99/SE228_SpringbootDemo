package ebook.controller;

import com.mysql.cj.PingTarget;
import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.service.CartService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class CartInfoController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add_to_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders add_to_cart(@RequestBody JSONObject input, Principal principal) throws IOException {
        return this.cartService.addToCart(input, principal);
    }

    @RequestMapping(value = "/remove_from_cart", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders remove_from_cart(@RequestBody JSONObject input, Principal principal) throws IOException {
        return this.cartService.removeFromCart(input, principal);
    }

    @RequestMapping(value = "/clear_cart", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Orders clear_cart(Principal principal) throws IOException {
        return this.cartService.clearCart(principal);
    }

    @RequestMapping(value = "/ensure_payment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @Transactional
    public BookInOrder ensure_payment(Principal principal) throws IOException {
        Orders cart = this.cartService.giveCart(principal);
        BookInOrder lack = this.cartService.ensurePayment(cart);
        if (lack == null) {
            BookInOrder succ = new BookInOrder();
            succ.amount = 200;
            return succ;
        } else {
            return lack;
        }
    }


    @RequestMapping(value = "/get_cart", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BookInOrder> get_cart(Principal principal) throws IOException {
        Orders cart = this.cartService.giveCart(principal);
        List<BookInOrder> items = this.cartService.findItemsByOrder(cart);
        return this.cartService.findBooksByOrder(cart);
    }

}
