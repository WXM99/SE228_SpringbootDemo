package ebook.DAO;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;

import java.util.List;

public interface CartDao {

    BookInOrder save(BookInOrder book);

    List<BookInOrder> findByBelongto(Orders order);

    List<BookInOrder> findByBook(BookInfoBrief book);

    BookInOrder findByBelongtoAndBook(Orders order, BookInfoBrief book);

    void delete(BookInOrder book);
}
