package ebook.repository.Imp;

import ebook.model.BookDetails;
import ebook.model.Comments;
import ebook.repository.DetailsRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DetailsRepositoryImp implements DetailsRepository {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public BookDetails saveDetails(BookDetails bookDetails) {
        this.mongoTemplate.save(bookDetails);
        return bookDetails;
    }

    @Override
    public BookDetails updateDetails(BookDetails bookDetails) {
        Query query = new Query(Criteria.where("isbn").is(bookDetails.isbn));
        Update update = new Update();

        update.set("tags", bookDetails.tags);
        update.set("press", bookDetails.press);
        update.set("publish_time", bookDetails.publish_time);
        update.set("introduction", bookDetails.introduction);
        update.set("author_intro", bookDetails.author_intro);
        update.set("comments", bookDetails.comments);

        mongoTemplate.updateFirst(query, update, BookDetails.class);
        return bookDetails;
    }

    @Override
    public BookDetails addComments(BookDetails bookDetails, Comments comments) {
        Query query = new Query(Criteria.where("isbn").is(bookDetails.isbn));
        Update update = new Update();

        List<Comments> replies = bookDetails.comments;
        replies.add(comments);
        update.set("comments", replies);

        mongoTemplate.updateFirst(query, update, BookDetails.class);
        return bookDetails;
    }

    @Override
    public BookDetails getDetails(Long isbn) {
        Query query = new Query(Criteria.where("isbn").is(isbn));
        return this.mongoTemplate.findOne(query, BookDetails.class);
    }
    
}
