package ebook.controller;


import ebook.model.Comments;
import ebook.service.CommentsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/add_comments", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Comments add_comments(@RequestBody JSONObject input, Principal principal) throws IOException {
        return this.commentsService.addCommnets(input, principal);
    }

    @RequestMapping(value = "/add_reply", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Comments add_reply(@RequestBody JSONObject input, Principal principal) throws IOException {
        return this.commentsService.addReply(input, principal);
    }

    @RequestMapping(value = "/get_comments", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Comments> get_comments(@RequestBody JSONObject input) throws IOException {
        return this.commentsService.findAddComments(input);
    }

}
