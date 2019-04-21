package ebook.repository;

import ebook.model.BookInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<BookInOrder, Long> {
}
