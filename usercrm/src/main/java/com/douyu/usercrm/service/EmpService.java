package com.douyu.usercrm.service;

import com.douyu.usercrm.entity.Emp;

import java.util.List;

public interface EmpService {

    /**
     * 查询所有的抽奖用户
     */
    List<Emp> findAll();

    /**
     * 保存中将信息
     */
    void save(Emp emp);

    /**
     * 删除中奖者
     */
    void delete(Integer id);

    /**
     * 根据id查询
     */
    Emp findById(Integer id);

    /**
     * 更新信息
     */
    void update(Emp emp);

    /**
     * 搜索
     */
    List<Emp> search(String content);
}
