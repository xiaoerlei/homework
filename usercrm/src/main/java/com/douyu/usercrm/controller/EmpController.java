package com.douyu.usercrm.controller;

import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    // 更新员工信息的方法
    @RequestMapping("update")
    public String update(Emp emp) {
        empService.update(emp);
        return "redirect:/emp/findAll";
    }

    // 根据id查询基本信息
    @RequestMapping("findOne")
    public String findOne(Integer id, HttpSession session) {
        Emp emp = empService.findById(id);
        session.setAttribute("emp", emp);
        return "redirect:/resource/updateEmp.jsp";
    }

    // 删除人员基本信息
    @GetMapping("delete")
    public String delete(Integer id) {
        empService.delete(id);
        return "redirect:/emp/findAll";
    }

    // 保存员工
    @PostMapping("save")
    public String save(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    // 查询所有人员的信息
    @RequestMapping("findAll")
    public String findAll(HttpSession session) {
        List<Emp> emps = empService.findAll();
        session.setAttribute("emps", emps);
        return "redirect:/resource/emplist.jsp";
    }

    // 搜索
    @RequestMapping("search")
    public String search(String content ,HttpSession session) {
        List<Emp> emps = empService.search(content);
        session.setAttribute("emps", emps);
        return "redirect:/resource/emplist.jsp";
    }
}
