package com.zby.mapper;

import com.zby.entity.Emp;

import java.util.List;

public interface EmpMapper  {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int addEmp(Emp emp);

    int deleteEmpById(Integer id);

    //根据主键获取，单条，不是集合
    Emp getEmpById(Integer id);

    int updateEmpById(Emp emp);
}
