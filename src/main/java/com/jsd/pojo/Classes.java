package com.jsd.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Classes implements Serializable {
    private Integer classes_id;
    private String classes_name;
    private String classes_teacher;
    private Date createTime;
    private Date updateTime;
    private boolean del;
}
