package ebook.service;

import ebook.model.UserEntity;
import net.sf.json.JSONObject;

public interface RegisterService {
    UserEntity registerUser(JSONObject input_user);
}
