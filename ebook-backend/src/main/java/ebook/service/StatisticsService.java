package ebook.service;

import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import net.sf.json.JSONObject;
import java.util.List;
import java.util.Set;

public interface StatisticsService {

    List<Orders> findOrdersByUser(JSONObject input);

    Set<Orders> findOrdersByIsbn(JSONObject input);

    List<BookInfoBrief> orderBooks(JSONObject input);

}
