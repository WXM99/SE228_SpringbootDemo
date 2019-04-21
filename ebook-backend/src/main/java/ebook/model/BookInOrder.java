package ebook.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "BOOK_IN_ORDER")
public class BookInOrder {

    @Id
    @GeneratedValue
    public Long itemID;

    @ManyToOne
    @JoinColumn(name = "orderID",foreignKey = @ForeignKey(name = "orderID",value = ConstraintMode.CONSTRAINT))
    public Orders belongto;

    @ManyToOne
    @JoinColumn(name = "isbn",foreignKey = @ForeignKey(name = "isbn",value = ConstraintMode.CONSTRAINT))
    public BookInfoBrief book;

    @Column(nullable = false)
    public Double curr_price;

    @Column(nullable = false)
    public Integer amount;

    public BookInOrder() {
    }

    public BookInOrder(
            Orders belongto,
            BookInfoBrief book,
            Double curr_price,
            Integer amount) {
        this.belongto = belongto;
        this.book = book;
        this.curr_price = curr_price;
        this.amount = amount;
    }

}
