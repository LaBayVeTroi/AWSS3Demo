package com.example.demo.controller;

import com.example.demo.service.AWSS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AWSS3Controller {
    @Autowired
    private AWSS3Service awss3Service;

    @PostMapping(value= "/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value= "file") final MultipartFile multipartFile) {
        awss3Service.uploadFile(multipartFile);
        final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
