package ebook.service.statefulService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class StatefulCartServiceImpl implements  StatefulCartService {

  private  List<String> tmpCart;

  public  List<String> addToCart(String isbn) {
    tmpCart.add(isbn);
    return this.tmpCart;
  }
  public  List<String> getCart() {
    return this.tmpCart;
  }

  public StatefulCartServiceImpl() {
    this.tmpCart = new ArrayList<>();
  }
}
