package ebook.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "book_details")
public class BookDetails {
    @Id
    public long isbn;
    @Field("tags")
    public List<String> tags;
    @Field("press")
    public String press;
    @Field("publish_time")
    public String publish_time;
    @Field("introduction")
    public String introduction;
    @Field("author_intro")
    public String author_intro;
}
