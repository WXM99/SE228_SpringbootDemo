package ebook.service;

import ebook.model.UserEntity;
import net.sf.json.JSONObject;
import java.security.Principal;
import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    UserEntity findByUsername(JSONObject name);

    UserEntity getMyInfo(Principal principal);
}
