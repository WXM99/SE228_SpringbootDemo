package ebook.service.serviceImp;


import ebook.model.BookInOrder;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.repository.BookRepository;
import ebook.repository.CartRepository;
import ebook.repository.OrderRepository;
import ebook.repository.UserRepository;
import ebook.service.ManageOrderService;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageOrderServiceImp implements ManageOrderService {

@Autowired
private OrderRepository orderRepository;
@Autowired
private UserRepository userRepository;
@Autowired
private CartRepository cartRepository;
@Autowired
private BookRepository bookRepository;

public List <Orders> findOrdersByUser (JSONObject input) {
	String username = (String) input.get ("username");
	UserEntity user = this.userRepository.findByUsername (username);
	List <Orders> orders = this.orderRepository.findByBuyer (user);
	return orders;
}

public List <Orders> findMyOrders (Principal principal) {
	String username = principal.getName ();//(String) input.get("username");
	UserEntity user = this.userRepository.findByUsername (username);
	List <Orders> orders = this.orderRepository.findByBuyer (user);
	return orders;
}

public Set <Orders> findOrdersByIsbn (JSONObject input) {
	Long isbn = new Long ((Integer) input.get ("isbn"));
	List <BookInOrder> orders = this.cartRepository
			                            .findByBook (this.bookRepository.findByIsbn (isbn));
	Set <Orders> res = new HashSet <> ();
	for (BookInOrder bk : orders) {
		res.add (bk.belongto);
	}
	return res;
}

public Set <Orders> findOrdersByIsbnInDate (JSONObject input) throws ParseException {
	String utcFrom = (String) input.get ("from");
	String utcTo = (String) input.get ("to");
	DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd", Locale.ENGLISH);
	Date d1 = dateFormat.parse (utcFrom);
	Date d2 = dateFormat.parse (utcTo);
	d1 = new Date (d1.getTime () + 32 * 3600000);
	d2 = new Date (d2.getTime () + 32 * 3600000);
	Long isbn = new Long ((Integer) input.get ("isbn"));
	List <BookInOrder> orders = this.cartRepository
			                            .findByBook (this.bookRepository.findByIsbn (isbn));
	Set <Orders> res = new HashSet <> ();
	for (BookInOrder bk : orders) {
		if (bk != null && bk.belongto.finish_at != null) {
			System.out.println (bk.belongto.finish_at.getTime ());
			Date dp;
			dp = bk.belongto.finish_at;
			if (( dp.getTime () < d2.getTime () ) && ( dp.getTime () > d1.getTime () ))
			{
				res.add (bk.belongto);
			}
		}
	}
	return res;
}

public List <BookInOrder> orderBooks (JSONObject input) {
	Long orderid = new Long ((Integer) input.get ("orderid"));
	Orders belongto = this.orderRepository.findByOrderID (orderid);
	List <BookInOrder> bks_in_cart = this.cartRepository.findByBelongto (belongto);
	return bks_in_cart;
}

public List <Orders> findOrderInDate (JSONObject input, Principal principal) throws ParseException {
	String utcFrom = (String) input.get ("from");
	String utcTo = (String) input.get ("to");
	DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd", Locale.ENGLISH);
	Date d1 = dateFormat.parse (utcFrom);
	Date d2 = dateFormat.parse (utcTo);
	d1 = new Date (d1.getTime () + 32 * 3600000);
	d2 = new Date (d2.getTime () + 32 * 3600000);
	String username = principal.getName ();
	return this.orderRepository.findOrderInDate (d1, d2, username);
}

public List <Orders> findUserOrderInDate (JSONObject input)
		throws ParseException {
	String utcFrom = (String) input.get ("from");
	String utcTo = (String) input.get ("to");
	DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd", Locale.ENGLISH);
	Date d1 = dateFormat.parse (utcFrom);
	Date d2 = dateFormat.parse (utcTo);
	d1 = new Date (d1.getTime () + 32 * 3600000);
	d2 = new Date (d2.getTime () + 32 * 3600000);
	String username = input.getString ("username");
	return this.orderRepository.findOrderInDate (d1, d2, username);
}
}
