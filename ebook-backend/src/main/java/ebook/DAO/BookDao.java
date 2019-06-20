package ebook.DAO;

import ebook.model.BookInfoBrief;

import ebook.model.outOfDB.WholeBook;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface BookDao {

    List<BookInfoBrief> findAll();

    BookInfoBrief save(BookInfoBrief book);

    BookInfoBrief findByIsbn(Long isbn);

    WholeBook find(Long isbn);

    List<BookInfoBrief> find_with_page(Pageable pageable);

    List<BookInfoBrief> search_book(String key);

}
