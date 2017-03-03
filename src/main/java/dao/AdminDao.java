package dao;

import entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 管理员查询模型
 * Created by magenta9 on 2017/2/27.
 */
public interface AdminDao {
    int add(Admin admin);

    int del(Admin admin);

    int update(Admin admin);

    Admin findById(int Id);

    int findbyNameAndPwd(String name, String password);

    List<Admin> findAll();
}
