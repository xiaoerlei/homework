package com.douyu.usercrm.serviceImpl;

import com.douyu.usercrm.dao.LotteryDAO;
import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.entity.Lottery;
import com.douyu.usercrm.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryDAO lotteryDAO;

    @Override
    public void save(Lottery lottery) {
        lotteryDAO.save(lottery);
    }

    @Override
    public List<Lottery> getWinningList() {
        return lotteryDAO.getWinningList();
    }

    @Override
    public void deleteAll() {
        List<Lottery> list = getWinningList();
        for (Lottery lottery : list) {
            lotteryDAO.deleteById(lottery.getId());
        }
    }

    @Override
    public List<Lottery> findListByRewardType(Integer rewardType) {
        List<Lottery> typeList = new ArrayList<>();
        List<Lottery> list = getWinningList();
        for (Lottery lottery : list) {
            if (lottery.getRewardType().equals(rewardType)) {
                Lottery listByRewardType = lotteryDAO.findListByRewardType(rewardType);
                typeList.add(listByRewardType);
            }
        }
        return typeList;
    }

}
