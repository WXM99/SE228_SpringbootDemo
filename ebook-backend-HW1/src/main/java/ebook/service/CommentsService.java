package ebook.service;

import ebook.model.Comments;
import net.sf.json.JSONObject;

import java.security.Principal;
import java.util.List;

public interface CommentsService {
    Comments addCommnets(JSONObject input, Principal principal);
    Comments addReply(JSONObject input, Principal principal);
    List<Comments> findAddComments(JSONObject input);
}
