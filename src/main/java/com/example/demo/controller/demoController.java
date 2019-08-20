package com.example.demo.controller;

import com.example.demo.model.ControlModel;
import com.example.demo.model.ResultVO;
import com.example.demo.service.ControlService;
import com.example.demo.service.DbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @CrossOrigin
    public ResultVO execSql(@RequestParam("sqlStr") @ApiParam("sql语句") String sqlStr,
                            @RequestParam("url") @ApiParam("sql 地址 jdbc:mysql://127.0.0.1:3306/xvue_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT") String url,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("driver") @ApiParam("mysql 或者 sqlserver") String driver) {
        if (StringUtils.isEmpty(sqlStr)) {
            return ResultVO.error("empty Str!");
        }
        return dbService.execSql(sqlStr, url, username, password, driver);
    }

    @ApiOperation("queryControls")
    @PostMapping("/queryControls")
    @CrossOrigin
    public ResultVO queryControls() {
        return controlService.queryControls();
    }

    @ApiOperation("addControl")
    @PostMapping("/addControl")
    @CrossOrigin
    public ResultVO addControl(@RequestBody ControlModel controlModel) {
        controlService.insertControl(controlModel);
        return ResultVO.success(null);
    }

    @ApiOperation("deleteControl")
    @DeleteMapping("/deleteControl")
    @CrossOrigin
    public ResultVO deleteControl(@RequestParam("uuid") String uuid) {
        controlService.deleteControl(uuid);
        return ResultVO.success(null);
    }

    @ApiOperation("updateControl")
    @PostMapping("/updateControl")
    @CrossOrigin
    public ResultVO updateControl(@RequestBody ControlModel controlModel) {
        controlService.updateControl(controlModel);
        return ResultVO.success(null);
    }
}
