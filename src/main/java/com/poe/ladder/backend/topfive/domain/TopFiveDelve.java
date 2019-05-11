package com.poe.ladder.backend.topfive.domain;

public class TopFiveDelve extends TopFiveBase {
	
	private String depth;
		
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return "TopFiveDelve [depth=" + depth + "," + super.toString() + "]";
	}
	
}
