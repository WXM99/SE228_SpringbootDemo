package ebook.service;

import ebook.model.BookDetails;
import ebook.model.BookInfoBrief;
import ebook.model.outOfDB.WholeBook;
import java.rmi.RemoteException;
import net.sf.json.JSONObject;
import java.util.List;

public interface BookService {

    List<BookInfoBrief> allBook();

    BookInfoBrief findBook(JSONObject input);

    WholeBook find(JSONObject input) throws RemoteException;

    List<BookInfoBrief> findBookWithPage(JSONObject input);

    List<BookInfoBrief> searchBook(JSONObject input);

    BookDetails addDetails(JSONObject input);

}
