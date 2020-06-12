package com.douyu.usercrm;

import com.douyu.usercrm.dao.EmpDAO;
import com.douyu.usercrm.dao.LotteryDAO;
import com.douyu.usercrm.dao.UserDAO;
import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.entity.Lottery;
import com.douyu.usercrm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestUserCRM {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EmpDAO empDAO;

    @Autowired
    private LotteryDAO lotteryDAO;

    @Test
    public void testUserSave(){
        User user = new User(UUID.randomUUID().toString(), "斗鱼", "douyu", "xiaoshayu", "666", "男");
        userDAO.save(user);
        System.out.println("保存用户信息成功");
    }

    @Test
    public void testUserUpdate(){
        User user = new User(UUID.randomUUID().toString(), "湖大", "huda", "hunandaxue", "985", "男");
        userDAO.save(user);
        System.out.println("更新用户信息成功");
    }

    @Test
    public void testEmpSave(){
        Emp emp = new Emp(111, "Java", 1234.0, 12);
        empDAO.save(emp);
        System.out.println("保存员工信息成功");
    }

    @Test
    public void testEmpUpdate(){
        Emp emp = new Emp(222, "C++", 2345.0, 15);
        empDAO.update(emp);
        System.out.println("更新员工信息成功");
    }

    @Test
    public void testEmpSearch(){
        String content = "Java";
        empDAO.search(content);
        System.out.println("查询成功");
    }

    @Test
    public void testEmpDelete(){
        empDAO.delete(222);
        System.out.println("删除员工信息成功");
    }

    @Test
    public void testLotterySave(){
        Lottery lottery = new Lottery(333, "golang", 3);
        lotteryDAO.save(lottery);
        System.out.println("保存中奖信息成功");
    }

    @Test
    public void testLotteryDelete(){
        List<Lottery> winningList = lotteryDAO.getWinningList();
        for (Lottery lottery : winningList) {
            lotteryDAO.deleteById(lottery.getId());
        }
        System.out.println("全部清除成功");
    }
}
