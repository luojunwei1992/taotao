package com.taotao.service.impl;

import com.taotao.pojo.PictureResult;
import com.taotao.service.PictureService;
import com.taotao.utils.ExceptionUtil;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by luo on 16/11/23.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;



    public PictureResult uploadPicture(MultipartFile uploadFile) {

        if (null == uploadFile || uploadFile.isEmpty()){

            return PictureResult.error("上传图片为空");
        }

        //取扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));

        //生成新的文件名
        String imageName = IDUtils.genImageName();

        DateTime dateTime = new DateTime();
        String filePath = dateTime.toString("/yyyy/MM/dd");

        try {
            FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FTP_BASE_PATH,filePath,imageName+ext,uploadFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();

            return PictureResult.error(ExceptionUtil.getStackTrace(e));
        }


        return PictureResult.ok(IMAGE_BASE_URL+filePath+"/"+imageName+ext);
    }
}
