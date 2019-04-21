package ebook.service;

import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findByUsername(JSONObject name){
        String username = (String) name.get("username");
        UserEntity found = userRepository.findByUsername(username);
        if (found == null) {
            UserEntity not_found = new UserEntity();
            not_found.state = 404;
            not_found.avatar_path = "not found user: "+ username;
            return not_found;
        } else {
            return found;
        }
    }
}
