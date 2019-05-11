package com.poe.ladder.backend.topfive.domain;

public class TopFiveUberLab extends TopFiveBase {
	
	String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TopFiveUberLab [time=" + time + "," + super.toString() + "]";
	}
	
}
