package ebook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "comments")
public class Comments {
    @Id
    public long id;
    @Field("to_book_isbn")
    public long isbn;
    @Field("from_user")
    public String username;
    @Field("content")
    public String content;
    @Field("replies")
    public List<Comments> floors;

    public Comments() {
        this.floors = new ArrayList<>();
    }

    public Comments(long isbn, String username, String content) {
        this.floors = new ArrayList<>();
        this.isbn = isbn;
        this.username = username;
        this.content = content;
    }
}
