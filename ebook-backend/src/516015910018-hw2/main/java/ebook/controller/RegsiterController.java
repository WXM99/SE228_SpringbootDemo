package ebook.controller;

import ebook.model.UserEntity;
import ebook.service.RegisterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class RegsiterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserEntity register(@RequestBody JSONObject new_user) throws IOException {
        return this.registerService.registerUser(new_user);
    }
}
