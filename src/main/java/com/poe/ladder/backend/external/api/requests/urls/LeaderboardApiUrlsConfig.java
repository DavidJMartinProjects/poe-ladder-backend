package com.poe.ladder.backend.external.api.requests.urls;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "urls.properties.leaderboards")
public class LeaderboardApiUrlsConfig {	
	
    String delve_prefix;
    String delve_postfix;         
    String raceto100_prefix;
    String raceto100_postfix;
    String uberlab_prefix;	
    String uberlab_postfix;
    
	public String getDelve_prefix() {
		return delve_prefix;
	}
	public void setDelve_prefix(String delve_prefix) {
		this.delve_prefix = delve_prefix;
	}
	public String getDelve_postfix() {
		return delve_postfix;
	}
	public void setDelve_postfix(String delve_postfix) {
		this.delve_postfix = delve_postfix;
	}
	public String getRaceto100_prefix() {
		return raceto100_prefix;
	}
	public void setRaceto100_prefix(String raceto100_prefix) {
		this.raceto100_prefix = raceto100_prefix;
	}
	public String getRaceto100_postfix() {
		return raceto100_postfix;
	}
	public void setRaceto100_postfix(String raceto100_postfix) {
		this.raceto100_postfix = raceto100_postfix;
	}
	public String getUberlab_prefix() {
		return uberlab_prefix;
	}
	public void setUberlab_prefix(String uberlab_prefix) {
		this.uberlab_prefix = uberlab_prefix;
	}
	public String getUberlab_postfix() {
		return uberlab_postfix;
	}
	public void setUberlab_postfix(String uberlab_postfix) {
		this.uberlab_postfix = uberlab_postfix;
	}
	
	@Override
	public String toString() {
		return "LeaderboardApiUrlsConfig [delve_prefix=" + delve_prefix + ", delve_postfix=" + delve_postfix
				+ ", raceto100_prefix=" + raceto100_prefix + ", raceto100_postfix=" + raceto100_postfix
				+ ", uberlab_prefix=" + uberlab_prefix + ", uberlab_postfix=" + uberlab_postfix + "]";
	}
    
}	
