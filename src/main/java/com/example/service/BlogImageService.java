package com.example.service;

import com.example.entity.BlogImageData;
import com.example.repository.BlogImageRepository;
import com.example.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class BlogImageService {
    @Autowired
    private BlogImageRepository repository;

    public String uploadImage(MultipartFile file,int id) throws IOException {

        BlogImageData imageData = repository.save(BlogImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .blogPostId(id)
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<BlogImageData> dbImageData = repository.findByName(fileName);
        byte[] images= ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
