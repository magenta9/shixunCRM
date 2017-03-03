package serviceimpl;

import dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AdminService;

/**
 * Created by magenta9 on 2017/2/28.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean isValid(String name, String password) {
        return adminDao.findbyNameAndPwd(name, password)!=0;
    }
}
