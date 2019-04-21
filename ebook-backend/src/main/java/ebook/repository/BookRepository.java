package ebook.repository;

import ebook.model.BookInfoBrief;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookInfoBrief, Integer> {
    List<BookInfoBrief> findAll();
    BookInfoBrief save(BookInfoBrief book);
    BookInfoBrief findByIsbn(Long isbn);
}
