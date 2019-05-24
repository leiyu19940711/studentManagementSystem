package com.jsd.pojo;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Student implements Serializable {

    private Integer student_id;
    private String student_name;
    private Integer student_age;
    private Integer student_classesId;
    private Date createTime;
    private Date updateTime;
    @ApiParam(required = false)
    private boolean del;
}
