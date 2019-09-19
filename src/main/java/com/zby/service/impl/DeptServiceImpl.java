package com.zby.service.impl;

import com.zby.entity.Dept;
import com.zby.mapper.DeptMapper;
import com.zby.service.DeptService;
import com.zby.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    @Override
    public List<Dept> listDept() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.listDept();
        sqlSession.close();
        return deptList;
    }
}
