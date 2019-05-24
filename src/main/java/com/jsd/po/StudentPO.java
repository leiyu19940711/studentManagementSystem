package com.jsd.po;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class StudentPO implements Serializable {
    private Integer student_id;
    private String student_name;
    private Integer student_age;
    private Integer student_classesId;
}
