package ebook.DAO;

import ebook.model.Orders;
import ebook.model.UserEntity;

import java.util.Date;
import java.util.List;

public interface OrderDao {
    List<Orders> findByBuyer(UserEntity buyer);

    Orders save(Orders new_order);

    Orders findByBuyerAndState(UserEntity buyer, Integer state);

    Orders findByOrderID(Long orderid);

    List<Orders> findOrderInDate(Date date1, Date date2, String username);
}
