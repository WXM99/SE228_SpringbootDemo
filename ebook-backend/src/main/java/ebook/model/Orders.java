package ebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @GeneratedValue
    private Long orderID;

//    @Column(nullable = true)
//    private String userID;

    @ManyToOne
    @JoinColumn(name = "userID",foreignKey = @ForeignKey(name = "userID",value = ConstraintMode.CONSTRAINT))
    private UserEntity buyer;

    @Column(nullable = false)
    private Integer state;

    @Column(nullable = false)
    private Double tot_price;

    @Column(nullable = false)
    private Date create_at;

    @Column(nullable = true)
    private Date finish_at;

}
