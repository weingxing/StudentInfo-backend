package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    public Response upload(MultipartFile file);

    public  Response download(HttpServletRequest request);
}
