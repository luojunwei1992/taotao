package com.taotao.controller;

import com.taotao.pojo.PictureResult;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by luo on 16/11/23.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile){

        PictureResult pictureResult = pictureService.uploadPicture(uploadFile);

        return pictureResult;
    }
}
