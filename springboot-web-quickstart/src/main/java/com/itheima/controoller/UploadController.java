package com.itheima.controoller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin
public class UploadController {
    @Autowired
    private AliOSSUtils  aliOSSUtils;

    /**
     * 上传文件到阿里云oss
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传：{}",image.getOriginalFilename());

        //调用阿里云oss工具类进行文件上传
        Object url = aliOSSUtils.upload(image);
        log.info("文件上传成功，文件访问路径：{}",url);

        return Result.success(url);
    }
}
