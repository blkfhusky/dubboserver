package com.zxc.service.impl;

import com.zxc.service.FansService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: blkfhusky
 * Date: 2018-06-25
 * Time: 上午10:36
 */
@Service("fansService")
public class FansServiceImpl implements FansService {

    @Override
    public String hello() {
        return "hello";
    }
}
