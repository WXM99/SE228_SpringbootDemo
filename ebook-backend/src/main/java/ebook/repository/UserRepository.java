package ebook.repository;

import ebook.model.BookInfoBrief;
import ebook.model.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
    @Query("SELECT u FROM UserEntity u ORDER BY userid")
    List<UserEntity> find_with_page(Pageable pageable);
}
