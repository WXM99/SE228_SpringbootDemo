package ebook.repository;

import ebook.model.BookDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDetailsRepository extends MongoRepository<BookDetails, String> {
    BookDetails findByIsbn(Long isbn);
}
