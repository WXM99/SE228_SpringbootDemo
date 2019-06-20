package ebook.service.serviceImp;

import ebook.DAO.BookDao;
import ebook.model.BookDetails;
import ebook.model.BookInfoBrief;
import ebook.model.outOfDB.WholeBook;
import ebook.repository.BookDetailsRepository;
import ebook.repository.BookRepository;
import ebook.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    @Autowired
    private BookDao bookDao;

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

    public WholeBook find(JSONObject input) {
        Long isbn = new Long((Integer)input.get("isbn"));
        WholeBook found = this.bookDao.find(isbn);
        if (found == null || found.bookInfoBrief.state == DELETED_BOOK) {
            BookInfoBrief not_found = new BookInfoBrief();
            not_found.isbn = isbn;
            not_found.state = 404;
            not_found.intro = "not found";
            WholeBook nf = new WholeBook(not_found, null, null);
            return nf;
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

    public BookDetails addDetails(JSONObject input) {
        Long isbn = input.getLong("isbn");
        String press = input.getString("press");
        String author_info = input.getString("author_info");
        String introduction = input.getString("introduction");
        String publish_time = input.getString("publish_time");
        JSONArray tags = input.getJSONArray("tags");
        ArrayList<String> tags_list = new ArrayList<>(tags);
        BookDetails bookDetails = new BookDetails(press, publish_time, introduction, author_info, isbn, tags_list);
        this.bookDetailsRepository.save(bookDetails);
        return  bookDetails;
    }
}
