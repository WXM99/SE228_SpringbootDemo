package ebook.DAO.DaoImp;

import ebook.DAO.CartDao;
import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDaoImp implements CartDao {
    @Autowired
    private CartRepository cartRepository;

    public BookInOrder save(BookInOrder book) {
        return this.cartRepository.save(book);
    }

    public List<BookInOrder> findByBelongto(Orders order) {
        return this.cartRepository.findByBelongto(order);
    }

    public List<BookInOrder> findByBook(BookInfoBrief book) {
        return this.findByBook(book);
    }

    public BookInOrder findByBelongtoAndBook(Orders order, BookInfoBrief book) {
        return this.findByBelongtoAndBook(order, book);
    }

    public void delete(BookInOrder book) {
        this.cartRepository.delete(book);
    }

}
