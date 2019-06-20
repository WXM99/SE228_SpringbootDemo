package ebook.controller;

import ebook.service.ImageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin("*")
public class ImagesController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/img_upload", produces = "application/json; charset=utf-8" ,method = RequestMethod.POST)
    @ResponseBody
    JSONObject savePhotos(@RequestParam("file") MultipartFile file) throws Exception {
        return this.imageService.saveImg(file);
    }

//    @RequestMapping(value="show", produces = MediaType.IMAGE_JPEG_VALUE)
//    @ResponseBody
//    public ResponseEntity showPhotos(String fileName){
//        return this.imageService.showImg(fileName);
//    }
}
