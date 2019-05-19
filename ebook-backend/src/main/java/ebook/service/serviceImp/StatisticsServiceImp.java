package ebook.service.serviceImp;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.repository.BookRepository;
import ebook.repository.CartRepository;
import ebook.repository.OrderRepository;
import ebook.repository.UserRepository;
import ebook.service.StatisticsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatisticsServiceImp implements StatisticsService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Orders> findOrdersByUser(JSONObject input) {
        String username = (String) input.get("username");
        UserEntity user = this.userRepository.findByUsername(username);
        List<Orders> orders = this.orderRepository.findByBuyer(user);
        return orders;
    }

    public Set<Orders> findOrdersByIsbn(JSONObject input) {
        Long isbn = new Long((Integer)input.get("isbn"));
        List<BookInOrder> orders = this.cartRepository.findByBook(this.bookRepository.findByIsbn(isbn));
        Set<Orders> res = new HashSet<>();
        for (BookInOrder bk: orders) {
            res.add(bk.belongto);
        }
        return res;
    }

    public List<BookInfoBrief> orderBooks(JSONObject input) {
        Long orderid = new Long((Integer)input.get("orderid"));
        Orders belong = this.orderRepository.findByOrderID(orderid);
        List<BookInOrder> bks_in_cart = this.cartRepository.findByBelongto(belong);
        List<BookInfoBrief> books = new ArrayList<>();
        for (BookInOrder bk: bks_in_cart) {
            books.add(bk.book);
        }
        return books;
    }

}
