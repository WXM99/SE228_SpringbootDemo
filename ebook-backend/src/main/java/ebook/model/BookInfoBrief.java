package ebook.model;


import javax.persistence.*;

@Entity
@Table(name = "BOOK_BRIEF")
public class BookInfoBrief {
    @Id
    @Column(nullable = false, unique = true)
    // @GeneratedValue
    public Long isbn;

    @Column(nullable = false)
    public String name;

    @Column(nullable = true)
    public Double price;

    @Column(nullable = true)
    public String author;

    @Column(nullable = false)
    public Integer inventory;

    @Column(nullable = true)
    public String cover_path;

    @Column(nullable = true)
    public String intro;

    @Column(nullable = false)
    public Integer state;

    public BookInfoBrief(){
    }

    // Generate isbn
    public BookInfoBrief(
            String name,
            Double price,
            Integer inventory,
            String author,
            String cover_path,
            String intro){
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.author = author;
        this.cover_path =  cover_path;
        this.intro = intro;
        this.state = 1;
    }

    // Assign isbn
    public BookInfoBrief(
            Long isbn,
            String name,
            Double price,
            Integer inventory,
            String author,
            String cover_path,
            String intro,
            Integer state){
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.author = author;
        this.cover_path =  cover_path;
        this.intro = intro;
        this.state = state;
    }

    public void deleteBook() {
        this.state = -1;
    }
}
