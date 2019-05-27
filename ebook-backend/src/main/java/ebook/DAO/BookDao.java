package ebook.DAO;

import ebook.model.BookInfoBrief;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookDao {

    List<BookInfoBrief> findAll();

    BookInfoBrief save(BookInfoBrief book);

    BookInfoBrief findByIsbn(Long isbn);

    List<BookInfoBrief> find_with_page(Pageable pageable);

    List<BookInfoBrief> search_book(String key);

}
