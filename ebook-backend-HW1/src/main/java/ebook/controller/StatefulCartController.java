package ebook.controller;


import ebook.service.statefulService.StatefulCartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
@Scope("singleton")
public class StatefulCartController {

  @Autowired
  WebApplicationContext webApplicationContext;

  @RequestMapping(value = "/get_cart_stateful", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public List<String> get_cart(@RequestHeader HttpHeaders headers) {
    StatefulCartService cartService = (StatefulCartService) this.webApplicationContext
        .getBean(StatefulCartService.class);
    // System.out.println(headers);
    System.out.println(this);
    System.out.println(cartService);
    return cartService.getCart();
  }

  @RequestMapping(value = "/add_cart_stateful", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public List<String> add_cart(@RequestParam(name = "isbn") String isbn, @RequestHeader HttpHeaders headers) {
    StatefulCartService cartService = (StatefulCartService) this.webApplicationContext
        .getBean(StatefulCartService.class);
    // System.out.println(headers);
    System.out.println(this);
    System.out.println(cartService);
    return cartService.addToCart(isbn);
  }
}
