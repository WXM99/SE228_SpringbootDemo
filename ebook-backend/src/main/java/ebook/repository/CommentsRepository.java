package ebook.repository;

import ebook.model.Comments;

public interface CommentsRepository {
    Comments replyTo(Comments to, Comments content);
}
