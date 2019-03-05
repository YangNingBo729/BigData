package com.haku.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "该控制器的名字", tags = "这里是该控制器的描述")
@RestController
@RequestMapping("/test")
public class SwaggerController {

    //增
    @ApiOperation(value = "查询", notes = "描述该方法")
    @GetMapping(value = "/{id}/{age}")
    public String add(@PathVariable(value = "id") String id, @PathVariable(value = "age") String age) {
        System.out.println(id + age);
        return "success";
    }

    //增
    @ApiOperation(value = "增加", notes = "描述该方法")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/{ss}")
    public String add(@RequestBody User user, @PathVariable String ss) {
        System.out.println(user + ss);
        return "success";
    }

}
