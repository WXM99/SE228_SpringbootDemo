package ebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @GeneratedValue
    public Long orderID;

//    @Column(nullable = true)
//    public String userID;

    @ManyToOne
    @JoinColumn(name = "userID",foreignKey = @ForeignKey(name = "userID",value = ConstraintMode.CONSTRAINT))
    public UserEntity buyer;

    @Column(nullable = false)
    public Integer state;

    @Column(nullable = false)
    public Double tot_price;

    @Column(nullable = false)
    public Date create_at;

    @Column(nullable = true)
    public Date finish_at;
    
    public Orders(){}

}
