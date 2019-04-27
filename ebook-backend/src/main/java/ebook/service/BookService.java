package ebook.service;


import ebook.model.BookInfoBrief;
import ebook.repository.BookRepository;
import jdk.internal.dynalink.linker.LinkerServices;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private static final int DELETED_BOOK = -1;
    private static final int NORMAL_BOOK = 1;

    public List<BookInfoBrief> allBook() {
        return this.bookRepository.findAll();
    }

    public BookInfoBrief findBook(JSONObject input) {
        Long isbn = new Long((Integer)input.get("isbn"));
        BookInfoBrief found = this.bookRepository.findByIsbn(isbn);
        if (found == null || found.state == DELETED_BOOK) {
            BookInfoBrief not_found = new BookInfoBrief();
            not_found.isbn = isbn;
            not_found.state = 404;
            not_found.intro = "not found";
            return not_found;
        } else {
            return found;
        }
    }

    public List<BookInfoBrief> findBookWithPage(JSONObject input) {
        int offset = (int) input.get("offset");
        int limit = (int) input.get("limit");
        return this.bookRepository.find_with_page(new PageRequest(offset, limit));
    }

    public  List<BookInfoBrief> searchBook(JSONObject input) {
        String key = (String) input.get("keyword");
        return this.bookRepository.search_book(key);
    }

}
