package entity;

/**
 * 种类表
 * 用于报表显示相关销售统计信息
 * Created by magenta9 on 2017/3/14.
 */
public class CatagoryCount {
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
