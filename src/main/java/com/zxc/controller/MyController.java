package com.zxc.controller;

import com.zxc.dubboserver.api.FansApi;
import com.zxc.entity.CfFans;
import com.zxc.entity.CfFansExample;
import com.zxc.mapper.CfFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * User: blkfhusky
 * Date: 2018-06-22
 * Time: 下午4:13
 */
@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private FansApi fansApi;

    @RequestMapping("/hello")
    public String hello() {
        return fansApi.hello();
    }
}
