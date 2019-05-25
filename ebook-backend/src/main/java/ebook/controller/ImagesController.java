package ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class ImagesController {
    private final ResourceLoader resourceLoader;

    @Autowired
    public ImagesController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = "/img_upload", produces = "application/json; charset=utf-8" ,method = RequestMethod.POST)
    @ResponseBody
    String myService(@RequestParam("file") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = "";
            File dest = new File(filePath + UUID.randomUUID() + suffixName);
            try {
                file.transferTo(dest);
                return dest.getPath();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "failed";
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/Users/Miao/Projects/Github/SE228/ebook-backend/src/main/resources/static/");
        return factory.createMultipartConfig();
    }

    @RequestMapping(value="show", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public ResponseEntity showPhotos(String fileName){

        System.out.println(fileName);
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + "/Users/Miao/Projects/Github/SE228/ebook-backend/src/main/resources/static/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
