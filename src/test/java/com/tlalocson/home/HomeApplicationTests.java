package com.tlalocson.home;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlalocson.home.model.RolModel;
import com.tlalocson.home.service.RolService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class HomeApplicationTests {

	@Autowired
	private RolService rolService;
	
	@Test
	public void contextLoads() {
		List<RolModel> roles = rolService.getRoles();
		assertTrue(roles.size() > 0);
	}

}
