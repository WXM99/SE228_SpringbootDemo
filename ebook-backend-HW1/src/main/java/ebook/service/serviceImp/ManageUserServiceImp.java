package ebook.service.serviceImp;

import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import ebook.service.ManageUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserServiceImp implements ManageUserService {
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

    public List<UserEntity> findUserWithPage(JSONObject input) {
        int offset = (int) input.get("offset");
        int limit = (int) input.get("limit");
        return this.userRepository.find_with_page(new PageRequest(offset, limit));
    }

    public List<UserEntity> searchUser(JSONObject input) {
        String username = (String) input.get("username");
        return this.userRepository.searchUser(username);
    }
}
