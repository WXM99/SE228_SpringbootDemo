package ebook.service.statefulService;

import java.security.Principal;
import java.util.List;
import net.sf.json.JSONObject;

public interface StatefulCartService {
  List<String> addToCart(String isbn);
  List<String> getCart();
}
