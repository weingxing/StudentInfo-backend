package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Status;

public interface StatusService {
    public Response update(Status record);

    public Response getStatus();

    public int getStatusCode();

}
