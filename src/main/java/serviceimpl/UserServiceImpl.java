package serviceimpl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * Created by magenta9 on 2017/3/1.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {

    }

    /**
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public int judgeUserNameAndPassword(String name, String pwd) {
        return 0;
    }

}
