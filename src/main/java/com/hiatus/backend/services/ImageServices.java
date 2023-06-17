package com.hiatus.backend.services;

import com.hiatus.backend.model.ImageData;
import com.hiatus.backend.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices {
    private ImageRepository imageRepository;

    public ImageServices(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    public List<ImageData> getAllImages(){
        return imageRepository.findAll();
    }
}
