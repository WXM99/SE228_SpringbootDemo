package ebook.DAO;

import ebook.DAO.DaoImp.BookDaoImp;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import javax.naming.NamingException;

public class RmiServer {
  public static void main(String[] args)  throws RemoteException, NamingException {
    try {
      Properties properties = new Properties();
      properties.load(new BufferedInputStream(new FileInputStream("src/main/java/ebook/DAO/jndi.properties")));
      String url = properties.getProperty("java.naming.provider.url");
      int port = Integer.parseInt(properties.getProperty("java.naming.provider.port"));
      System.out.println(url);
      BookDao bookDao = new BookDaoImp();
      LocateRegistry.createRegistry(port);
      Naming.bind("/book_dao", bookDao);
      System.out.println("book dao has been bond to rmi registry at" + url);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
