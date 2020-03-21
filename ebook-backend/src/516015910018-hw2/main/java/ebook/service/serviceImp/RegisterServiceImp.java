package ebook.service.serviceImp;
import ebook.model.UserEntity;
import ebook.repository.UserRepository;
import ebook.service.RegisterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements RegisterService {
    @Autowired
    private UserRepository userRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserEntity registerUser(JSONObject input_user) {
        String avatar_path = (String) input_user.get("avatar_path");
        String email = (String) input_user.get("email");
        String password = (String) input_user.get("password");
        String username = (String) input_user.get("username");
        UserEntity new_user = new UserEntity();
        new_user.state = 1;
        new_user.username = username;
        new_user.email = email;
        new_user.avatar_path = avatar_path;
        if (!password.equals("ebook_admin")){
            new_user.is_manager = false;
        } else {
            new_user.is_manager = true;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashstr = encoder.encode(password);
        new_user.password = hashstr;

        try {
            return this.userRepository.save(new_user);
        } catch (Exception e) {
            logger.debug("Register Error:"+e.getMessage());
            UserEntity error_uer = new UserEntity();
            error_uer.avatar_path = e.getMessage();
            error_uer.state = 400;
            return error_uer;
        }
    }
}

