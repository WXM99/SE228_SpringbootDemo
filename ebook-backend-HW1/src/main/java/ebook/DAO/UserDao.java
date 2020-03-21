package ebook.DAO;

import ebook.model.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDao {

    UserEntity findByUsername(String username);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    List<UserEntity> find_with_page(Pageable pageable);

    List<UserEntity> searchUser(String key);
}
