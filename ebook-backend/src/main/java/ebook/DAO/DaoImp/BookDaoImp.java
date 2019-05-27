package ebook.DAO.DaoImp;

import ebook.DAO.BookDao;
import ebook.model.BookInfoBrief;
import ebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import java.util.List;

public class BookDaoImp implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    public List<BookInfoBrief> findAll() {
        return this.bookRepository.findAll();
    }

    public BookInfoBrief save(BookInfoBrief book) {
        return this.bookRepository.save(book);
    }

    public BookInfoBrief findByIsbn(Long isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    public List<BookInfoBrief> find_with_page(Pageable pageable) {
        return this.bookRepository.find_with_page(pageable);
    }

    public List<BookInfoBrief> search_book(String key) {
        return this.bookRepository.search_book(key);
    }

}
