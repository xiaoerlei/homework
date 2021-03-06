package com.douyu.usercrm.serviceImpl;

import com.douyu.usercrm.dao.EmpDAO;
import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDAO empDAO;

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }

    @Override
    public List<Emp> search(String content) {
        return empDAO.search(content);
    }

    @Override
    public Emp findById(Integer id) {
        return empDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        empDAO.delete(id);
    }

    @Override
    public void save(Emp emp) {
        empDAO.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empDAO.findAll();
    }
}
