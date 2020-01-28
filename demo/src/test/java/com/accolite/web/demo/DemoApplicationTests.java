package com.accolite.web.demo;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.web.demo.models.Users;

@SpringBootTest
class DemoApplicationTests {
	static Logger log = Logger.getLogger(DemoApplicationTests.class.getName());
	

	@Test
	public void testAdd(){
		BasicConfigurator.configure();
	      Users user=new Users();
	      user.setId(1234);
	      user.setSalary(20000);
	      
	      assertEquals(1234,user.getId());
	      assertEquals(20000,user.getSalary());
	      log.info("Test1 passed");
	      
	   }
	
	@Test
	  public void playTest() {
		BasicConfigurator.configure();
	   Users user = new Users();
	   user.setId(10);
	   user.setSalary(120000);
	    Users user1 = Mockito.spy(user);

	    Mockito.doReturn(true).when(user1).runInGround("ground");

	    Assert.assertEquals(true, user1.isPlay());
	    log.info("Mock Test passed");
	  }
	
	

}
