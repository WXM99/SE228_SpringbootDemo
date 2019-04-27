package ebook.repository;

import ebook.model.BookInfoBrief;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookInfoBrief, Integer> {
    List<BookInfoBrief> findAll();
    BookInfoBrief save(BookInfoBrief book);
    BookInfoBrief findByIsbn(Long isbn);
    @Query("SELECT b FROM BookInfoBrief b ORDER BY isbn")
    List<BookInfoBrief> find_with_page(Pageable pageable);
    @Query("SELECT b FROM BookInfoBrief b WHERE b.name LIKE %:key% ORDER BY isbn")
    List<BookInfoBrief> search_book(@Param("key") String key);
}
