package ebook.repository;

import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<BookInOrder, Long> {
    BookInOrder save(BookInOrder book);
    List<BookInOrder> findByBelongto(Orders order);
    List<BookInOrder> findByBook(BookInfoBrief book);
    BookInOrder findByBelongtoAndBook(Orders order, BookInfoBrief book);
    void delete(BookInOrder book);
}
