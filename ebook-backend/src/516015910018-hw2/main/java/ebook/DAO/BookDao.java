package ebook.DAO;

import ebook.model.BookInfoBrief;

import ebook.model.outOfDB.WholeBook;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface BookDao extends Remote, Serializable {

    List<BookInfoBrief> findAll() throws RemoteException;

    BookInfoBrief save(BookInfoBrief book) throws RemoteException;

    BookInfoBrief findByIsbn(Long isbn) throws RemoteException;

    WholeBook find(Long isbn) throws RemoteException;

    List<BookInfoBrief> find_with_page(Pageable pageable) throws RemoteException;

    List<BookInfoBrief> search_book(String key) throws RemoteException;

}
