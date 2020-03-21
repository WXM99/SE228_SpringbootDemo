package ebook.DAO.DaoImp;

import ebook.DAO.OrderDao;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class OrderDaoImp implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findByBuyer(UserEntity buyer) {
        return this.orderRepository.findByBuyer(buyer);
    }

    public Orders save(Orders new_order) {
        return this.orderRepository.save(new_order);
    }

    public Orders findByBuyerAndState(UserEntity buyer, Integer state) {
        return this.orderRepository.findByBuyerAndState(buyer, state);
    }

    public Orders findByOrderID(Long orderid) {
        return this.findByOrderID(orderid);
    }

    public List<Orders> findOrderInDate(Date date1, Date date2, String username) {
        return this.orderRepository.findOrderInDate(date1, date2, username);
    }

}
