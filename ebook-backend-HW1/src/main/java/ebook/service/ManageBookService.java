package ebook.service;

import ebook.model.BookInfoBrief;
import net.sf.json.JSONObject;
import java.util.List;

public interface ManageBookService {

    List<BookInfoBrief> allBook();

    BookInfoBrief addBook(JSONObject new_book);

    BookInfoBrief deleteBook(JSONObject input);

    BookInfoBrief updateBook(JSONObject new_book);
}
