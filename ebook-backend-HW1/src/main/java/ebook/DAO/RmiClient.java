package ebook.DAO;

import ebook.model.BookInfoBrief;
import java.rmi.Naming;
import java.util.List;

public class RmiClient {

  public static void main(String[] args) {
    try {
      BookDao bookDao = (BookDao) Naming.lookup("rmi://localhost:1099/book_dao");
      List<BookInfoBrief> allBooks = bookDao.findAll();
      if (allBooks == null) {
        System.out.println("empty book storage.");
      }
      else {
        for (BookInfoBrief book : allBooks) {
          System.out.println(book.isbn);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
