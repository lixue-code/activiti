package com.controller;

import com.service.IWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProcessController {

    @Autowired
    private IWorkFlowService iWorkFlowService;

    @RequestMapping(value = "/toAddProcess")
    public String toAddProcess(){
        return "add_process";
    }

    @RequestMapping(value = "/addProcess")
    public String addProcess(MultipartFile multipartFile,String processName){
        try {
            iWorkFlowService.saveNewProcess(multipartFile.getInputStream(),processName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "add_process";
    }

}
