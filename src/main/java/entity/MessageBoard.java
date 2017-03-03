package entity;

import java.io.Serializable;

/**
 * Created by magenta9 on 2017/2/27.
 create table message_board (
 m_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,	# 留言项id
 u_id INT NOT NULL,								# 留言用户id
 m_message text NOT NULL,						# 留言信息
 m_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,# 留言时间
 m_state int(1)									# 留言状态 (待处理 / 已解决)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class MessageBoard implements Serializable {
    private int messageId;
    private int userId;
    private String userName;
    private String message;
    private String date;
    private int state;  //0:未受理,1:处理中,2.已处理

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
