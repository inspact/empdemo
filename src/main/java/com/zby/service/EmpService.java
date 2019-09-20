package com.zby.service;

import com.zby.entity.Emp;

import java.util.List;


public interface EmpService {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int addEmp(Emp emp);

    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);

    int updateEmpById(Emp emp);
}
