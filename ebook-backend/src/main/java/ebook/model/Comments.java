package ebook.model;

import ebook.model.outOfDB.Reply;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comments {
    @Id
    public String id;
    public long isbn;
    public String username;
    public String content;
    public List<Reply> floors;
    public Date time;

    public Comments() {
        this.floors = new ArrayList<>();
        this.time = new Date();
    }

    public Comments(long isbn, String username, String content) {
        this.floors = new ArrayList<>();
        this.time = new Date();
        this.isbn = isbn;
        this.username = username;
        this.content = content;
    }
}
