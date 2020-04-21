package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传下载服务接口
 * @author oxygen
 * @since 2020/03/13
 */
public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    public Response upload(MultipartFile file) throws Exception;

    /**
     * 下载文件
     * @param request
     * @return
     */
    public  Response download(HttpServletRequest request) throws Exception;
}
