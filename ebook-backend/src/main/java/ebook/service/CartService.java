package ebook.service;


import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.repository.BookRepository;
import ebook.repository.CartRepository;
import ebook.repository.OrderRepository;
import ebook.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    private static final int CART_ORDER = 0;
    private static final int FINISHED_ORDER = 1;

    private void updateTotalPrice(Orders cart){
        List<BookInOrder> books_in_cart = this.cartRepository.findByBelongto(cart);
        Double tot = 0.0;
        for (BookInOrder book: books_in_cart) {
            tot += (book.curr_price * book.amount);
        }
        cart.tot_price = tot;
        this.orderRepository.save(cart);
    }

    public Orders addToCart(JSONObject input){
        String userame = (String) input.get("username");
        UserEntity user = this.userRepository.findByUsername(userame);
        Long isbn =  new Long((Integer)input.get("isbn"));
        BookInfoBrief book = this.bookRepository.findByIsbn(isbn);

        /* find the user's present cart */
        Orders in_cart = this.orderRepository.findByBuyerAndState(user,CART_ORDER);
        /* if null, then create a new one */
        if (in_cart == null) {
            in_cart = new Orders();
            in_cart.buyer = user;
            in_cart.state = CART_ORDER;
            in_cart.tot_price = 0.0;
            in_cart.create_at = new Date();
            this.orderRepository.save(in_cart);
            in_cart = this.orderRepository.findByBuyerAndState(user,CART_ORDER);
        }

        /* find the same book in the cart */
        BookInOrder item = this.cartRepository.findByBelongtoAndBook(in_cart, this.bookRepository.findByIsbn(isbn));
        /* if null, then add as a new book */
        if (item == null) {
            item = new BookInOrder();
            item.curr_price = book.price;
            item.book = book;
            item.belongto = in_cart;
            item.amount = 1;
            this.cartRepository.save(item);
        }
        /* if found, then add the amount and update price */
        else {
            item.amount = item.amount + 1;
            item.curr_price = book.price;
            this.cartRepository.save(item);
        }
        this.updateTotalPrice(in_cart);
        return in_cart;
    }

    public Orders removeFromCart(JSONObject input){
        String userame = (String) input.get("username");
        UserEntity user = this.userRepository.findByUsername(userame);
        Long isbn =  new Long((Integer)input.get("isbn"));
        BookInfoBrief book = this.bookRepository.findByIsbn(isbn);

        /* find the user's present cart */
        Orders in_cart = this.orderRepository.findByBuyerAndState(user,CART_ORDER);
        if (in_cart == null) return null;

        /* find the same book in the cart */
        BookInOrder item = this.cartRepository.findByBelongtoAndBook(in_cart, this.bookRepository.findByIsbn(isbn));
        if (item == null) return null;

        int amount = item.amount;
        if (amount <= 1){
            this.cartRepository.delete(item);
        } else {
            item.amount = amount - 1;
            this.cartRepository.save(item);
        }

        this.updateTotalPrice(in_cart);
        return in_cart;
    }

    public Orders clearCart(JSONObject input) {
        String username = (String) input.get("username");
        UserEntity user = this.userRepository.findByUsername(username);

        /* find the user's present cart */
        Orders in_cart = this.orderRepository.findByBuyerAndState(user,CART_ORDER);
        if (in_cart == null) return null;

        /* get inner books */
        List<BookInOrder> books_in_cart = this.cartRepository.findByBelongto(in_cart);
        for (BookInOrder bk: books_in_cart) {
            this.cartRepository.delete(bk);
        }
        this.updateTotalPrice(in_cart);
        return in_cart;
    }

    private BookInOrder UpdateBookInventory(Orders cart) {
        List<BookInOrder> bks_in_cart = this.cartRepository.findByBelongto(cart);
        for (BookInOrder bk: bks_in_cart) {
            int amount = bk.amount;
            BookInfoBrief book = bk.book;
            if (book.inventory < amount) return bk;
            // book.inventory -= amount;
        }

        for (BookInOrder bk: bks_in_cart) {
            int amount = bk.amount;
            BookInfoBrief book = bk.book;
            // if (book.inventory < amount) return bk;
            book.inventory -= amount;
            this.bookRepository.save(book);
        }

        return null;
    }

    public BookInOrder ensurePayment(Orders cart) {
        if ( this.UpdateBookInventory(cart) == null) {
            cart.state = FINISHED_ORDER;
            cart.finish_at = new Date();
            this.orderRepository.save(cart);
            return null;
        }
        else {
            return this.UpdateBookInventory(cart);
        }

    }

    public Orders giveCart(JSONObject input){
        String username = (String) input.get("username");
        UserEntity user = this.userRepository.findByUsername(username);

        /* find the user's present cart */
        return this.orderRepository.findByBuyerAndState(user,CART_ORDER);
    }

    public List<BookInOrder> findBooksByOrder(Orders cart){
        return this.cartRepository.findByBelongto(cart);
    }

    public List<BookInOrder> findItemsByOrder(Orders cart){
        return  this.cartRepository.findByBelongto(cart);
    }
}
