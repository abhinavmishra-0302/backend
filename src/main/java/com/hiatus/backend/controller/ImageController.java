package com.hiatus.backend.controller;

import com.hiatus.backend.model.ImageData;
import com.hiatus.backend.services.ImageServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {
    private final ImageServices imageServices;

    public ImageController(ImageServices imageServices){
        this.imageServices = imageServices;
    }

    @GetMapping(value = "/images")
    public List<ImageData> getAllImages(){
        return imageServices.getAllImages();
    }
}
