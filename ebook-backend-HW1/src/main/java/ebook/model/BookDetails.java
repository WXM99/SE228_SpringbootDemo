package ebook.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "book_details")
public class BookDetails {
    @Id
    public String id;

    public Long isbn;
    public List<String> tags;
    public String press;
    public String publish_time;
    public String introduction;
    public String author_intro;

    public BookDetails(){
        this.tags = new ArrayList<>();
    }

    public BookDetails(String press,
                       String publish_time,
                       String introduction,
                       String author_intro,
                       Long isbn,
                       ArrayList<String> tags){
        this.tags = tags;
        this.author_intro = author_intro;
        this.introduction = introduction;
        this.publish_time = publish_time;
        this.press = press;
        this.isbn = isbn;
    }
}
