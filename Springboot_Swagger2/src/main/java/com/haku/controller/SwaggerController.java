package com.haku.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "该控制器的名字", tags = "这里是该控制器的描述")
@RestController
@RequestMapping("/test")
public class SwaggerController {

    //增
    /*@ApiOperation(value = "增加",notes = "描述该方法")
    @PostMapping
    public String add(@ApiParam(name = "name",value="用户名")@RequestParam(required = true) String name,@ApiParam(name = "age",value = "年龄")@RequestParam(required = true) Integer age){
        System.out.println(name+age);
        return "success";
    }*/

    //增
    @ApiOperation(value = "增加", notes = "描述该方法")
    @PostMapping
    public String add(User user) {
        System.out.println(user);
        return "success";
    }

}
