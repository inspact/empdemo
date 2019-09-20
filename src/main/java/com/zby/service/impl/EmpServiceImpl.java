package com.zby.service.impl;

import com.zby.entity.Emp;
import com.zby.mapper.EmpMapper;
import com.zby.service.EmpService;
import com.zby.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 实现类，实现EmpService
 * 业务层，调用mapper层
 */
public class EmpServiceImpl implements EmpService {

    @Override
    public List<Emp> listEmp() {
        //调用mapper
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.listEmp();
        sqlSession.close();
        return empList;
    }

    @Override
    public List<Emp> listEmpDept() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.listEmpDept();
        sqlSession.close();
        return empList;
    }

    @Override
    public int addEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row = empMapper.addEmp(emp);
        sqlSession.close();

        return row;
    }

    @Override
    public int deleteEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row =  empMapper.deleteEmpById(id);
        sqlSession.close();
        return row;
    }

    @Override
    public Emp getEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp =  empMapper.getEmpById(id);
        sqlSession.close();
        return emp;
    }

    @Override
    public int updateEmpById(Emp emp) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row = empMapper.updateEmpById(emp);
        sqlSession.close();

        return row;
    }
}



















