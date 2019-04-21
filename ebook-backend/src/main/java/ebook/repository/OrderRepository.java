package ebook.repository;

import ebook.model.Orders;
import ebook.model.UserEntity;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByBuyer(UserEntity buyer);
    Orders save(Orders new_order);
    Orders findByBuyerAndState(UserEntity buyer, Integer state);
    Orders findByOrderID(Long orderid);
}
