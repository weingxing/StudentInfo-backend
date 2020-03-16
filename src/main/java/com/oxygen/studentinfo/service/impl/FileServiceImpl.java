package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response upload(MultipartFile file) {
        // 文件上传路径
        String path = "D:/";
        if(file.isEmpty()){
            logger.info("空文件");
            return new Response(new Date().toString(), 0, "上传失败", null);
        }

        try {
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            // 取得文件后缀
            String type = fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传文件名：" + fileName + "大小：" + (int) file.getSize());
            // 时间戳作为文件名
            long timestamp = System.currentTimeMillis();
            File dest = new File(path + "/" + timestamp + type);

            // 判断文件父目录是否存在
            if(!dest.getParentFile().exists()){
                boolean res = dest.getParentFile().mkdir();
                if (res) logger.info("创建目录成功");
                else logger.info("创建目录失败");
            }

            //保存文件
            file.transferTo(dest);
            logger.info("文件保存成功，路径：" + dest.getPath());
            return new Response(new Date().toString(), 1, "上传成功", dest.getPath());
        } catch (IllegalStateException | IOException | ArrayIndexOutOfBoundsException e) {
            logger.debug("发生异常");
            e.printStackTrace();
            return new Response(new Date().toString(), 0, "上传失败", null);
        }
    }

    @Override
    public Response download(HttpServletRequest request) {
        return null;
    }
}
