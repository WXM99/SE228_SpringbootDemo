package ebook.repository;

import ebook.model.BookDetails;
import ebook.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetailsRepository extends MongoRepository<BookDetails, String> {

}
