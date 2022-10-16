package com.example.projecttemplate.controller;

import com.example.projecttemplate.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xushengjie
 * @date 2022/10/10 17:11
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/sayHello")
    public Result sayHello() {
        return Result.success("Hello");
    }

}
