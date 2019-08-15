package com.example.demo.controller;

import com.example.demo.model.ControlModel;
import com.example.demo.model.ResultVO;
import com.example.demo.service.ControlService;
import com.example.demo.service.DbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController("/demo")
@Api("demo")
public class demoController {

    @Autowired
    private DbService dbService;

    @Autowired
    private ControlService controlService;

    @ApiOperation("execSql")
    @PostMapping("/execSql")
    public ResultVO execSql(@RequestParam("sqlStr") String sqlStr) {
        if (StringUtils.isEmpty(sqlStr)) {
            return ResultVO.error("empty Str!");
        }
        return dbService.execSql(sqlStr);
    }

    @ApiOperation("queryControls")
    @PostMapping("/queryControls")
    public ResultVO queryControls(){
        return controlService.queryControls();
    }

    @ApiOperation("addControl")
    @PostMapping("/addControl")
    public ResultVO addControl(@RequestBody ControlModel controlModel){
        controlService.insertControl(controlModel);
        return ResultVO.success(null);
    }

    @ApiOperation("deleteControl")
    @DeleteMapping("/deleteControl")
    public ResultVO deleteControl(@RequestParam("uuid") String uuid){
        controlService.deleteControl(uuid);
        return ResultVO.success(null);
    }

    @ApiOperation("updateControl")
    @PostMapping("/updateControl")
    public ResultVO updateControl(@RequestBody ControlModel controlModel){
        controlService.updateControl(controlModel);
        return ResultVO.success(null);
    }
}
