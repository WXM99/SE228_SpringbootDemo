package ebook.repository;

import ebook.model.Orders;
import ebook.model.UserEntity;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByBuyer(UserEntity buyer);
    Orders save(Orders new_order);
    Orders findByBuyerAndState(UserEntity buyer, Integer state);
    Orders findByOrderID(Long orderid);
    // o.finish_at <= :date2 AND o.finish_at >= :date1 AND
    // @Param("date1") Date date1, @Param("date2") Date date2, @Param("username")
    @Query("SELECT o FROM Orders o WHERE o.buyer.username = :username  AND o.finish_at BETWEEN :from AND :to ORDER BY finish_at")
    List<Orders> findOrderInDate(@Param("from") Date date1, @Param("to") Date date2, String username);
}
