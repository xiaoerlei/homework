package com.douyu.usercrm.controller;

import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.entity.Lottery;
import com.douyu.usercrm.service.EmpService;
import com.douyu.usercrm.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@Controller
@RequestMapping("lottery")
public class LotteryController {

    // 同步锁，保证线程安全
    private final ReentrantLock lock = new ReentrantLock();

    @Autowired
    private EmpService empService;

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/loadLotteryData")
    public String loadLotteryData(Model model) {
        List<Lottery> lotteryList = lotteryService.getWinningList();
        model.addAttribute("lotteryList", lotteryList);
        return "/resource/lottery";
    }

    // 获取可抽奖人员名单
    @RequestMapping("/loadAvailableUser")
    @ResponseBody
    public Set<String> loadAvailableUser() {
        try {
            List<Emp> userList = empService.findAll();
            List<Lottery> lotteryList = lotteryService.getWinningList();
            String lotteryStr = "";
            for (Lottery lottery : lotteryList) {
                lotteryStr += "," + lottery.getName() + ",";
            }
            Set<String> nameList = new HashSet<String>();
            for (Emp lotteryUser : userList) {
                String name = lotteryUser.getName();
                if (lotteryStr.indexOf("," + name + ",") < 0) {
                    nameList.add(name);
                }
            }

            return nameList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 保存获奖人员
    @RequestMapping("/setWinningList")
    @ResponseBody
    public String setWinningList(HttpServletRequest request) {
        try {
            boolean isAcquired = lock.tryLock();
            // 如果锁被占用，则做异常处理
            if (!isAcquired) {
                throw new Exception("数据处理中，请稍后。。。");
            }
            // 如果锁没有被获取，就可以保存中奖信息
            String name = request.getParameter("name");
            Integer rewardType = Integer.parseInt(request.getParameter("rewardType"));
            Lottery lottery = new Lottery();
            lottery.setName(name);
            lottery.setRewardType(rewardType);
            lotteryService.save(lottery);
        } catch (Exception e) {
            // 发生异常，需要释放锁
            lock.unlock();
            e.printStackTrace();
            return e.toString();
        }
        return "success";
    }

    // 清空所有获奖名单
    @RequestMapping("/emptyWinningList")
    @ResponseBody
    public String emptyWinningList() {
        try {
            boolean isAcquired = lock.tryLock();
            if (!isAcquired) {
                throw new Exception("数据处理中，请稍后。。。");
            }
            lotteryService.deleteAll();
        } catch (Exception e) {
            lock.unlock();
            e.printStackTrace();
            return e.toString();
        }
        return "success";
    }

}
