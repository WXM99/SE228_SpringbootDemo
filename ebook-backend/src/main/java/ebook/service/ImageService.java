package ebook.service;

import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    JSONObject saveImg(MultipartFile file) throws Exception;
    ResponseEntity showImg(String fileName);
}
