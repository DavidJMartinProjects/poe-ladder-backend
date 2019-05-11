package com.poe.ladder.backend.topfive.domain;

public class TopFiveRace extends TopFiveBase {
	
	String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "TopFiveRace [level=" + level + "," + super.toString() + "]";
	}

}
