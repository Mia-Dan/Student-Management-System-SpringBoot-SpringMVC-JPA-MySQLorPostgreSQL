package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping({"/upload"})
    public Result uploadToOSS(MultipartFile image) throws IOException {

// A. save to local, tested with postman
        image.transferTo(new File("D:\\a.zip"));
        String url = "upload to local, test D:\\a.zip";

// B. upload to OSS
//        String url = aliOSSUtils.upload(image);

        log.info("upload to OSS, url: {}", url);
        return Result.success(url);
    }
}

