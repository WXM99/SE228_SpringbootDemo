package ebook.controller;

import com.mysql.cj.PingTarget;
import ebook.model.BookInOrder;
import ebook.model.BookInfoBrief;
import ebook.model.Orders;
import ebook.model.UserEntity;
import ebook.service.CartService;
import ebook.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find_a_user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserEntity find_a_user(@RequestBody JSONObject input) throws IOException {
        return this.userService.findByUsername(input);
    }

    @RequestMapping(value = "/get_my_info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserEntity get_mt_info(Principal principal) throws IOException {
        return this.userService.getMyInfo(principal);
    }
}
