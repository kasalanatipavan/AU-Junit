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
import com.accolite.web.demo.services.EmployeeManager;
import com.accolite.web.demo.dao.UserDao;


@SpringBootTest
class DemoApplicationTests {
	static Logger log = Logger.getLogger(DemoApplicationTests.class.getName());

	@InjectMocks
	EmployeeManager manager;

	@Mock
	UserDao dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllEmployeesTest()
	{
		List<EmployeeVO> list = new ArrayList<Users>();
		Users one = new Users(1,20000);
		Users two = new Users(2, 22000);
		Users thee = new Users(3, 23000);

		list.add(one);
		list.add(two);
		list.add(three);

		when(dao.isData()).thenReturn(list);
		List<Users> empList = manager.isData();

		assertEquals(3, empList.size());
		verify(dao, times(1)).isData();
	}

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
