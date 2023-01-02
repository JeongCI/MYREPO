package com.pcwk.ehr.user.domain;

import com.pcwk.ehr.cmn.DTO;

public class LevelPieVO extends DTO {
	private String levelName; // 레벨명(BASIC, SILVER, GOLD)
	private int levelCount; // 레벨별 인원수

	public LevelPieVO() {
	}

	public LevelPieVO(String levelName, int levelCount) {
		super();
		this.levelName = levelName;
		this.levelCount = levelCount;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}

	@Override
	public String toString() {
		return "LevelPieVO [levelName=" + levelName + ", levelCount=" + levelCount + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
