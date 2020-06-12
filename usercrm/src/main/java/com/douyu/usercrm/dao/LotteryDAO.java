package com.douyu.usercrm.dao;

import com.douyu.usercrm.entity.Lottery;
import java.util.List;

public interface LotteryDAO {

    public void save(Lottery lottery);

    public void deleteById(Integer id);

    public List<Lottery> getWinningList();

    public Lottery findListByRewardType(Integer rewardType);

}
