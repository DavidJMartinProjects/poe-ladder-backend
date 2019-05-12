package com.poe.ladder.backend.external.api.requests.urls;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "urls.properties.leaderboards")
public class LeaderboardApiUrlsConfig {	
	
    String delvePrefix;
    String delvePostfix;         
    String raceto100Prefix;
    String raceto100Postfix;
    String uberlabPrefix;	
    String uberlabPostfix;
    
	public String getDelvePrefix() {
		return delvePrefix;
	}
	public void setDelvePrefix(String delvePrefix) {
		this.delvePrefix = delvePrefix;
	}
	public String getDelvePostfix() {
		return delvePostfix;
	}
	public void setDelvePostfix(String delvePostfix) {
		this.delvePostfix = delvePostfix;
	}
	public String getRaceto100Prefix() {
		return raceto100Prefix;
	}
	public void setRaceto100Prefix(String raceto100Prefix) {
		this.raceto100Prefix = raceto100Prefix;
	}
	public String getRaceto100Postfix() {
		return raceto100Postfix;
	}
	public void setRaceto100Postfix(String raceto100Postfix) {
		this.raceto100Postfix = raceto100Postfix;
	}
	public String getUberlabPrefix() {
		return uberlabPrefix;
	}
	public void setUberlabPrefix(String uberlabPrefix) {
		this.uberlabPrefix = uberlabPrefix;
	}
	public String getUberlabPostfix() {
		return uberlabPostfix;
	}
	public void setUberlabPostfix(String uberlabPostfix) {
		this.uberlabPostfix = uberlabPostfix;
	}
    
}	
