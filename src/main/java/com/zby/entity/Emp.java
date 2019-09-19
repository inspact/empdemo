package com.zby.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Emp {
    private Integer empId;
    private String name;
    private Integer age;
    private String sex;
    private BigDecimal salary;
    private Integer deptId;
//关联的部门，把部门表传过来，dept可以调用部门id和名字
    private Dept dept;
}
