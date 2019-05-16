package com.poe.ladder.backend.leaderboard.progressbar;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)	
public class ProgressBarServiceImplTest {
	
	@Autowired
	ProgressBarServiceImpl progressBarServiceImpl;

	@Test
	public void testGetProgressPercentage() {
		String progess = progressBarServiceImpl.getProgressPercentage("1", "262");		
		assertEquals("49.9%", progess);
	}

}
