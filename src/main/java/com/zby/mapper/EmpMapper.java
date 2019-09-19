package com.zby.mapper;

import com.zby.entity.Emp;

import java.util.List;

public interface EmpMapper  {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int addEmp(Emp emp);
}
