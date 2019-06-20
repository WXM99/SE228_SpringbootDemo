package ebook.DAO.DaoImp;

import ebook.DAO.BookDao;
import ebook.model.BookDetails;
import ebook.model.BookInfoBrief;
import ebook.model.Comments;
import ebook.model.outOfDB.WholeBook;
import ebook.repository.BookDetailsRepository;
import ebook.repository.BookRepository;
import ebook.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BookDaoImp implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    public List<BookInfoBrief> findAll() {
        return this.bookRepository.findAll();
    }

    public BookInfoBrief save(BookInfoBrief book) {
        return this.bookRepository.save(book);
    }

    public BookInfoBrief findByIsbn(Long isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    public WholeBook find(Long isbn) {
        BookInfoBrief bookInfoBrief = this.bookRepository.findByIsbn(isbn);
        List<Comments> comments = this.commentsRepository.findByIsbn(isbn);
        BookDetails bookDetails = this.bookDetailsRepository.findByIsbn(isbn);
        return new WholeBook(bookInfoBrief, bookDetails, comments);
    }

    public List<BookInfoBrief> find_with_page(Pageable pageable) {
        return this.bookRepository.find_with_page(pageable);
    }

    public List<BookInfoBrief> search_book(String key) {
        return this.bookRepository.search_book(key);
    }

}
