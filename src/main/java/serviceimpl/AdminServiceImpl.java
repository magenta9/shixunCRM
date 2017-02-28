package serviceimpl;

import dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean isValid(String name, String password) {
        return adminDao.findbyNameAndPwd(name, password)!=0;
    }
}
