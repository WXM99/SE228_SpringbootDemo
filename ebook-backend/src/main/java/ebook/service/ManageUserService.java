package ebook.service;

import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity banUser(JSONObject name) {
        String username = (String) name.get("username");
        UserEntity found = userRepository.findByUsername(username);
        if (found == null) {
            UserEntity not_found = new UserEntity();
            not_found.state = 404;
            not_found.avatar_path = "not found user: "+ username;
            return not_found;
        } else {
            if (found.is_manager) {
                UserEntity admin =  new UserEntity();
                admin.state = 500;
                admin.avatar_path = "admin can't be banned";
                return admin;
            }
            else {
                found.banUser();
                return this.userRepository.save(found);
            }
        }
    }

    public UserEntity freeUser(JSONObject name) {
        String username = (String) name.get("username");
        UserEntity found = userRepository.findByUsername(username);
        if (found == null) {
            UserEntity not_found = new UserEntity();
            not_found.state = 404;
            not_found.avatar_path = "not found user: "+ username;
            return not_found;
        } else {
            found.freeUser();
            return this.userRepository.save(found);
        }
    }
}
