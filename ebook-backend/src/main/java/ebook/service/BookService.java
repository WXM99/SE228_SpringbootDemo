package ebook.service;

import ebook.model.BookInfoBrief;
import net.sf.json.JSONObject;
import java.util.List;

public interface BookService {

    List<BookInfoBrief> allBook();

    BookInfoBrief findBook(JSONObject input);

    List<BookInfoBrief> findBookWithPage(JSONObject input);

    List<BookInfoBrief> searchBook(JSONObject input);

}
