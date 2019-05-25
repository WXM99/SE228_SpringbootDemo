package ebook.service;

import ebook.model.UserEntity;
import net.sf.json.JSONObject;

import java.util.List;

public interface ManageUserService {

    UserEntity banUser(JSONObject name);

    UserEntity freeUser(JSONObject name);

    List<UserEntity> findUserWithPage(JSONObject input);

    List<UserEntity> searchUser(JSONObject input);
}
