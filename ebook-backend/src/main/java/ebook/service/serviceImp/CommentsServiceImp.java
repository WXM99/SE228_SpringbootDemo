package ebook.service.serviceImp;

import ebook.model.Comments;
import ebook.model.outOfDB.Reply;
import ebook.repository.CommentsRepository;
import ebook.service.CommentsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImp implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    public Comments addCommnets(JSONObject input, Principal principal) {
        String username = principal.getName();
        long isbn = input.getLong("isbn");
        String content = input.getString("content");
        Comments ncomm = new Comments(isbn, username, content);
        this.commentsRepository.save(ncomm);
        return ncomm;
    }

    @Transactional
    public Comments addReply(JSONObject input, Principal principal) {
        String to_id = input.getString("id");
        Optional<Comments> res = this.commentsRepository.findById(to_id);
        Comments to_whitch = res.get();
        String from_user = principal.getName();
        String to_user = input.getString("to_whom");
        String content = input.getString("content");
        Reply nrly = new Reply(from_user, to_user, content);
        to_whitch.floors.add(nrly);
        return this.commentsRepository.save(to_whitch);
    }

    public List<Comments> findAddComments(JSONObject input) {
        Long isbn = input.getLong("isbn");
        return this.commentsRepository.findByIsbn(isbn);
    }
}
