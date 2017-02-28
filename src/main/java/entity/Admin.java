package entity;

import java.io.Serializable;

/**
 # 管理员表
 CREATE TABLE `admin` (
 `a_id` int(11) NOT NULL AUTO_INCREMENT,	# 管理员id
 `a_name` varchar(20) NOT NULL,			# 管理员姓名
 `a_password` varchar(20) NOT NULL,		# 管理员密码
 PRIMARY KEY (`a_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * Created by magenta9 on 2017/2/27.
 */
public class Admin implements Serializable {
    private int adminId;
    private String adminName;
    private String adminPassword;
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


}
