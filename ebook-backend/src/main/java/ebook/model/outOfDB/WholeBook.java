package ebook.model.outOfDB;

import ebook.model.BookDetails;
import ebook.model.BookInfoBrief;
import ebook.model.Comments;

import java.util.List;

public class WholeBook {
    public BookInfoBrief bookInfoBrief;
    public BookDetails bookDetails;
    public List<Comments> comments;

    public WholeBook(BookInfoBrief bookInfoBrief,
                BookDetails bookDetails,
                List<Comments> comments){
        this.bookDetails = bookDetails;
        this.bookInfoBrief = bookInfoBrief;
        this.comments = comments;
    }
}
