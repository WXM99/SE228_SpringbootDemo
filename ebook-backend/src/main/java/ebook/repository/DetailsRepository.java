package ebook.repository;

import ebook.model.BookDetails;
import ebook.model.Comments;

public interface DetailsRepository {
    BookDetails saveDetails(BookDetails bookDetails);
    BookDetails updateDetails(BookDetails bookDetails);
    BookDetails addComments(BookDetails bookDetails, Comments comments);
    BookDetails getDetails(Long isbn);
}
