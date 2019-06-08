package ebook.service.serviceImp;

import ebook.service.ImageService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImp implements ImageService {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImageServiceImp(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public JSONObject saveImg(MultipartFile file) throws Exception {
        JSONObject res = new JSONObject();
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = "";
            File dest = new File(filePath + UUID.randomUUID() + suffixName);
            try {
                file.transferTo(dest);
                String imgPath = dest.getPath();
                res.accumulate("path", imgPath);
                return res;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        res.accumulate("path", "error: empty file uploaded.");
        return res;
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/Users/Miao/Projects/Github/SE228/ebook-backend/src/main/resources/static/");
        return factory.createMultipartConfig();
    }

    public ResponseEntity showImg(String fileName){

        System.out.println(fileName);
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + "/Users/Miao/Projects/Github/SE228/ebook-backend/src/main/resources/static/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
