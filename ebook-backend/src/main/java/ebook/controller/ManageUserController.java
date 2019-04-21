package ebook.controller;


import ebook.model.UserEntity;
import ebook.service.ManageUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class ManageUserController {
    @Autowired
    private ManageUserService manageUserService;

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
}
