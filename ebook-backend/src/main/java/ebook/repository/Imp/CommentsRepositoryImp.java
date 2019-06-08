package ebook.repository.Imp;

import ebook.model.Comments;
import ebook.repository.CommentsRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CommentsRepositoryImp implements CommentsRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Comments replyTo(Comments to, Comments content) {
        Query query = new Query(Criteria.where("id").is(to.id));
        Update update = new Update();

        List<Comments> replies = to.floors;
        replies.add(content);
        update.set("floors", replies);

        this.mongoTemplate.updateFirst(query, update, Comments.class);
        return content;
    }
}
