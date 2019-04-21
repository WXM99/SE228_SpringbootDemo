package ebook.service;


import ebook.model.BookInfoBrief;
import ebook.repository.BookRepository;
import jdk.internal.dynalink.linker.LinkerServices;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookInfoBrief> allBook() {
        return this.bookRepository.findAll();
    }

    public BookInfoBrief addBook(JSONObject new_book) {
        String name = (String) new_book.get("name");
        String author = (String) new_book.get("author");
        String cover_path = (String) new_book.get("cover_path");
        String intro = (String) new_book.get("intro");
        Long isbn = new Long((Integer)new_book.get("isbn"));
        Double price = (Double) new_book.get("price");
        Integer inventory = (Integer) new_book.get("inventory");

        BookInfoBrief find_add = this.bookRepository.findByIsbn(isbn);
        if (find_add == null || find_add.state == -1) {
            BookInfoBrief saving_book = new BookInfoBrief(
                    isbn, name, price,
                    inventory, author,
                    cover_path, intro, 1);
            return this.bookRepository.save(saving_book);
        }
        else {
            BookInfoBrief found = new BookInfoBrief();
            found.isbn = isbn;
            found.state = 303;
            found.intro = "duplicated book";
            return found;
        }

    }

    public BookInfoBrief findBook(JSONObject input) {
        Long isbn = new Long((Integer)input.get("isbn"));
        BookInfoBrief found = this.bookRepository.findByIsbn(isbn);
        if (found == null || found.state == -1) {
            BookInfoBrief not_found = new BookInfoBrief();
            not_found.isbn = isbn;
            not_found.state = 404;
            not_found.intro = "not found";
            return not_found;
        } else {
            return found;
        }
    }

    public BookInfoBrief deleteBook(JSONObject input){
        Long isbn = new Long((Integer)input.get("isbn"));
        BookInfoBrief found = this.bookRepository.findByIsbn(isbn);
        if (found == null || found.state == -1) {
            BookInfoBrief not_found = new BookInfoBrief();
            not_found.isbn = isbn;
            not_found.state = 404;
            not_found.intro = "not found";
            return not_found;
        } else {
            found.deleteBook();
            return this.bookRepository.save(found);
        }
    }
}
