import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.web.demo.models.Users;
import com.accolite.web.demo.dao.UserDao;


@Service
public class EmployeeManager
{
    @Autowired
    UserDao dao;

    public List<Users> isData() {
        return dao.isData();
    }

    public int addData(Users u) {
        dao.addData(u);
    }
}