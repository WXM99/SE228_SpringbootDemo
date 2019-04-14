package ebook.modal;

import org.springframework.core.io.ClassPathResource;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONObject;

public class BookInfo {
    private JSONObject _book;

    // constructor
    public BookInfo(String name, String author, String ISBN, String desc, Integer inventory, Double price) {
        try{
            this._book = new JSONObject();
            ClassPathResource dict_path = new ClassPathResource("static/book5.jpg");
            String cover_path = dict_path.getFile().getAbsolutePath();
            this._book.put("cover", cover_path);
            this._book.put("name", name);
            this._book.put("author", author);
            this._book.put("ISBN", ISBN);
            this._book.put("desc", desc);
            this._book.put("inventory",new Integer(inventory));
            this._book.put("price", new Double(price));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public JSONObject get_book(String isbn) {
        String ISBN = (String) this._book.get("ISBN");
        System.out.println(ISBN);
        System.out.println(isbn);
        JSONObject err = new JSONObject();
        if (ISBN.equals(isbn))
            return this._book;
        else
            err.put("err_info", "incorrect ISBN");
            return err;
    }

}
