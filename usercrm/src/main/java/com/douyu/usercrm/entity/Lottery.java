package com.douyu.usercrm.entity;

public class Lottery {
	
	private Integer id;
	private String name;
	private Integer rewardType;//1.幸运奖 2.三等奖 3.二等奖 4.一等奖 5.特等奖

	public Lottery(Integer id, String name, Integer rewardType) {
		this.id = id;
		this.name = name;
		this.rewardType = rewardType;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRewardType() {
		return rewardType;
	}
	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}
	
	
}
