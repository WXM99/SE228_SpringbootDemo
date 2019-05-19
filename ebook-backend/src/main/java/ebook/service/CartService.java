package ebook.service;

import ebook.model.BookInOrder;
import ebook.model.Orders;
import net.sf.json.JSONObject;
import java.security.Principal;
import java.util.*;

public interface CartService {

    Orders addToCart(JSONObject input, Principal principal);

    Orders removeFromCart(JSONObject input, Principal principal);

    Orders clearCart(Principal principal);

    BookInOrder ensurePayment(Orders cart);

    Orders giveCart(Principal principal);

    List<BookInOrder> findBooksByOrder(Orders cart);

    List<BookInOrder> findItemsByOrder(Orders cart);

}
