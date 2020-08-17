package com.service.impl;

import com.service.IWorkFlowService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

@Service
public class WorkFlowServiceImpl implements IWorkFlowService {


    @Override
    public void saveNewProcess(InputStream inputStream, String processName) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        //将普通的io流转化成zip 流
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);


        //部署流程
        Deployment deployment = defaultProcessEngine.getRepositoryService()
                .createDeployment()
                .name(processName)
                .addZipInputStream(zipInputStream)
                .deploy();

        System.out.println("流程id："+deployment.getId()+"流程名:"+deployment.getName());
    }
}
