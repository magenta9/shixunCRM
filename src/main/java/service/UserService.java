package service;

import entity.User;

/**
 * Created by magenta9 on 2017/3/1.
 */
public interface UserService {
    void add(User user);

    int judgeUserNameAndPassword(String name, String pwd);
}
