package ebook.repository;

import ebook.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends MongoRepository<Comments, String> {
    List<Comments> findByIsbn(Long isbn);
}
