package com.accolite.web.demo.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.accolite.web.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	Users u;

    private static final String SQL = "select * from users";
   
    public List<Users> isData() {

         ArrayList<Users> users = new ArrayList<Users>();
         List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

         for (Map<String, Object> row : rows) 
         {
              Users u = new Users();
              u.setId((int)row.get("id"));
              u.setSalary((int)row.get("salary"));
              users.add(u);
          }

        return users;
    }
    
    public int addData(Users u) {
    	
    	jdbcTemplate.update("insert into users value (?,?)",u.getId(),u.getSalary());
    	return 1;
    }
    
    

}
