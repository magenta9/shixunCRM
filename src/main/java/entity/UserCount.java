package entity;

/**
 * 用户信息统计
 * Created by magenta9 on 2017/3/13.
 */
public class UserCount {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;
}
