package entity;

import java.io.Serializable;

/**
 create table catagory (
 c_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,	# 种类id
 c_name varchar(100) NOT NULL					# 种类名
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * Created by magenta9 on 2017/2/27.
 */
public class Catagory implements Serializable {
    private int catagoryId;
    private String catagoryName;

    public Catagory(String catagoryName) {
        this.catagoryId = 0;
        this.catagoryName = catagoryName;
    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
}
