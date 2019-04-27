package ebook.controller;


import ebook.model.UserEntity;
import ebook.service.ManageUserService;
import ebook.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class ManageUserController {
    @Autowired
    private ManageUserService manageUserService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ban_user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserEntity ban_user(@RequestBody JSONObject input) throws IOException {
        return this.manageUserService.banUser(input);
    }

    @RequestMapping(value = "/free_user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserEntity free_user(@RequestBody JSONObject input) throws IOException {
        return this.manageUserService.freeUser(input);
    }

    @RequestMapping(value = "/get_user_page", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<UserEntity> get_user_page(@RequestBody JSONObject input) throws IOException {
        return this.manageUserService.findUserWithPage(input);
    }
}
