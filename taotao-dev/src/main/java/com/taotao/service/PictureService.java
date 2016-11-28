package com.taotao.service;

import com.taotao.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by luo on 16/11/23.
 */
public interface PictureService {

    PictureResult uploadPicture(MultipartFile uploadFile);
}
