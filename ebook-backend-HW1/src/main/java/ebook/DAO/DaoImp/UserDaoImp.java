package ebook.DAO.DaoImp;

import ebook.DAO.UserDao;
import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserDaoImp implements UserDao {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public UserEntity save(UserEntity user) {
        return this.userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return this.userRepository.findAll();
    }

    public List<UserEntity> find_with_page(Pageable pageable) {
        return this.userRepository.find_with_page(pageable);
    }

    public List<UserEntity> searchUser(String key) {
        return this.userRepository.searchUser(key);
    }

}
