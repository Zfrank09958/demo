package com.example.demo.service;

import com.example.demo.dao.ControlModelMapper;
import com.example.demo.model.ControlModel;
import com.example.demo.model.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlService {

    @Autowired
    private ControlModelMapper controlModelMapper;

    public ResultVO queryControls(){
        return ResultVO.success(controlModelMapper.selectAll());
    }

    public void insertControl(ControlModel model){
        controlModelMapper.insertSelective(model);
    }


    public void updateControl(ControlModel model){
        controlModelMapper.updateByPrimaryKeySelective(model);
    }


    public void deleteControl(String uuid){
        controlModelMapper.deleteByPrimaryKey(uuid);
    }
}
