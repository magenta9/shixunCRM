package entity;

import java.io.Serializable;

/**
 * 用户信息
 CREATE TABLE `user` (
 `u_id` int(11) NOT NULL AUTO_INCREMENT, 	# userid
 `u_name` varchar(20) NOT NULL, 			# 客户名字
 `u_password` varchar(20) NOT NULL,		# 客户密码
 `u_sex` varchar(10) NOT NULL,				# 客户性别
 `u_email` varchar(30) NOT NULL,			# 客户邮箱
 `u_phone` varchar(20) DEFAULT NULL,		# 客户电话
 `u_score` int(4) DEFAULT NULL,			# 客户积分
 `U_level` int(1) DEFAULT NULL,			# 客户等级
 `u_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,# 创建时间
 `is_deleted` tinyint(1) DEFAULT NULL,		# 是否删除
 `u_image_id` varchar(100) DEFAULT NULL,            # 图片编号
 PRIMARY KEY (`u_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * Created by magenta9 on 2017/2/27.
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userEmail;
    private String userPhone;
    private int userScore;
    private int userLevel = 1;
    private String userCreateData;
    private String userImageUrl;
    private int isDeleted = 0;
    private String openId;
    private String personId;

    public String getPersonId() {
        return personId;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserCreateData() {
        return userCreateData;
    }

    public void setUserCreateData(String userCreateData) {
        this.userCreateData = userCreateData;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userScore=" + userScore +
                ", userLevel=" + userLevel +
                ", userCreateData='" + userCreateData + '\'' +
                ", userImageUrl='" + userImageUrl + '\'' +
                ", isDeleted=" + isDeleted +
                ", openId='" + openId + '\'' +
                '}';
    }
}
