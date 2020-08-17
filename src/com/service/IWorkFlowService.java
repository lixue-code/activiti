package com.service;

import java.io.InputStream;

public interface IWorkFlowService {

    //部署流程
    void saveNewProcess(InputStream inputStream,String processName);
}
