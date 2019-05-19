package ebook.service;

import ebook.model.BookInOrder;
import ebook.model.Orders;
import net.sf.json.JSONObject;
import java.security.Principal;
import java.text.ParseException;
import java.util.*;

public interface ManageOrderService {

    List<Orders> findOrdersByUser(JSONObject input);

    List<Orders> findMyOrders(Principal principal);

    Set<Orders> findOrdersByIsbn(JSONObject input);

    List<BookInOrder> orderBooks(JSONObject input);

    List<Orders> findOrderInDate(JSONObject input, Principal principal) throws ParseException;
}
