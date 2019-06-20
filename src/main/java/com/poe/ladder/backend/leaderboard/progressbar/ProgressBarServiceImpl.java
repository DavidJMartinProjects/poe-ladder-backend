package com.poe.ladder.backend.leaderboard.progressbar;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ProgressBarServiceImpl implements ProgressBarService {

	private Map<Integer, Double> levelXpValues = new HashMap<>();
	
	@PostConstruct
	public void initExperienceMap() {			
		levelXpValues.put(1,0d);
		levelXpValues.put(2,525d);
		levelXpValues.put(3,1760d);
		levelXpValues.put(4,3781d);
		levelXpValues.put(5,7184d);
		levelXpValues.put(6,12186d);
		levelXpValues.put(7,19324d);
		levelXpValues.put(8,29377d);
		levelXpValues.put(9,43181d);
		levelXpValues.put(10,61693d);
		levelXpValues.put(11,85990d);
		levelXpValues.put(12,117506d);
		levelXpValues.put(13,157384d);
		levelXpValues.put(14,207736d);
		levelXpValues.put(15,269997d);
		levelXpValues.put(16,346462d);
		levelXpValues.put(17,439268d);
		levelXpValues.put(18,551295d);
		levelXpValues.put(19,685171d);
		levelXpValues.put(20,843709d);
		levelXpValues.put(21,1030734d);
		levelXpValues.put(22,1249629d);
		levelXpValues.put(23,1504995d);
		levelXpValues.put(24,1800847d);
		levelXpValues.put(25,2142652d);
		levelXpValues.put(26,2535122d);
		levelXpValues.put(27,2984677d);
		levelXpValues.put(28,3496798d);
		levelXpValues.put(29,4080655d);
		levelXpValues.put(30,4742836d);
		levelXpValues.put(31,5490247d);
		levelXpValues.put(32,6334393d);
		levelXpValues.put(33,7283446d);
		levelXpValues.put(34,8384398d);
		levelXpValues.put(35,9541110d);
		levelXpValues.put(36,10874351d);
		levelXpValues.put(37,12361842d);
		levelXpValues.put(38,14018289d);
		levelXpValues.put(39,15859432d);
		levelXpValues.put(40,17905634d);
		levelXpValues.put(41,20171471d);
		levelXpValues.put(42,22679999d);
		levelXpValues.put(43,25456123d);
		levelXpValues.put(44,28517857d);
		levelXpValues.put(45,31897771d);
		levelXpValues.put(46,35621447d);
		levelXpValues.put(47,39721017d);
		levelXpValues.put(48,44225461d);
		levelXpValues.put(49,49176560d);
		levelXpValues.put(50,54607467d);
		levelXpValues.put(51,60565335d);
		levelXpValues.put(52,67094245d);
		levelXpValues.put(53,74247659d);
		levelXpValues.put(54,82075627d);
		levelXpValues.put(55,90631041d);
		levelXpValues.put(56,99984974d);
		levelXpValues.put(57,110197515d);
		levelXpValues.put(58,121340161d);
		levelXpValues.put(59,133497202d);
		levelXpValues.put(60,146749362d);
		levelXpValues.put(61,161191120d);
		levelXpValues.put(62,176922628d);
		levelXpValues.put(63,194049893d);
		levelXpValues.put(64,212684946d);
		levelXpValues.put(65,232956711d);
		levelXpValues.put(66,255001620d);
		levelXpValues.put(67,278952403d);
		levelXpValues.put(68,304972236d);
		levelXpValues.put(69,333233648d);
		levelXpValues.put(70,363906163d);
		levelXpValues.put(71,397194041d);
		levelXpValues.put(72,433312945d);
		levelXpValues.put(73,472476370d);
		levelXpValues.put(74,514937180d);
		levelXpValues.put(75,560961898d);
		levelXpValues.put(76,610815862d);
		levelXpValues.put(77,664824416d);
		levelXpValues.put(78,723298169d);
		levelXpValues.put(79,786612664d);
		levelXpValues.put(80,855129128d);
		levelXpValues.put(81,929261318d);
		levelXpValues.put(82,1009443795d);
		levelXpValues.put(83,1096169525d);
		levelXpValues.put(84,1189918242d);
		levelXpValues.put(85,1291270350d);
		levelXpValues.put(86,1400795257d);
		levelXpValues.put(87,1519130326d);
		levelXpValues.put(88,1646943474d);
		levelXpValues.put(89,1784977296d);
		levelXpValues.put(90,1934009687d);
		levelXpValues.put(91,2094900291d);
		levelXpValues.put(92,2268549086d);
		levelXpValues.put(93,2455921256d);
		levelXpValues.put(94,2658074992d);
		levelXpValues.put(95,2876116901d);
		levelXpValues.put(96,3111280300d);
		levelXpValues.put(97,3364828162d);
		levelXpValues.put(98,3638186694d);
		levelXpValues.put(99,3932818530d);
		levelXpValues.put(100,4250334444d);
	}

	public String getProgressPercentage(String level, String xpValue) {	
		Integer currentLevel = Integer.parseInt(level);
		Double currentXpValue = Double.parseDouble(xpValue);
		if (currentLevel != 100) {
			Double currentLevelXpValue = levelXpValues.get(currentLevel);
			Double nextLevelXpValue = levelXpValues.get(currentLevel + 1);
			Double totalXpForCurrentLevel = nextLevelXpValue - currentLevelXpValue;
			Double percentage = ((currentXpValue - currentLevelXpValue)*100)/totalXpForCurrentLevel;
			return String.format("%.1f", percentage) + "%";
		}
		return "100%";	
	}

}
