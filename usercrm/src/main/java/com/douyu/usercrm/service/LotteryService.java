package com.douyu.usercrm.service;

import com.douyu.usercrm.entity.Emp;
import com.douyu.usercrm.entity.Lottery;

import java.util.List;

public interface LotteryService {

    /**
     * 保存获奖人员
     */
    void save(Lottery lottery);

    /**
     * 获取所有获得将的人
     */
    List<Lottery> getWinningList();

    /**
     * 删除所有人员
     */
    void deleteAll();

    /**
     * 根据获奖类型获取名单
     */
    List<Lottery> findListByRewardType(Integer rewardType);

}
