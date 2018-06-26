package com.zxc.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:粉丝表
 * User: ganglun
 * Date: 2018-05-16
 * Time: 上午11:01
 */
@Data
public class CfFans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 粉丝手机号
     */
    private String phone;

    /**
     * 粉丝微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String name;

    /**
     * 粉丝分组id
     */
    private Long groupId;

    /**
     * 系统用户id
     */
    private String sysUserId;

    /**
     * 系统用户机构id
     */
    private String officeId;

    /**
     * 系统用户公司id
     */
    private String companyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Byte isDelete;

}
