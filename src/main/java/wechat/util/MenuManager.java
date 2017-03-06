package wechat.util;

import wechat.menu.*;
import wechat.util.MenuUtil;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class MenuManager {
    private static Menu getMenu() {
        ClickButton btn11 = new ClickButton();
        btn11.setName("用户绑定");
        btn11.setType("click");
        btn11.setKey("BIND");

        ClickButton btn12 = new ClickButton();
        btn12.setName("用户注册");
        btn12.setType("click");
        btn12.setKey("REGISTER");

        ClickButton btn13 = new ClickButton();
        btn13.setName("修改信息");
        btn13.setType("click");
        btn13.setKey("ALTER");

        ClickButton btn14 = new ClickButton();
        btn14.setName("订单查询");
        btn14.setType("click");
        btn14.setKey("QUERY");

        ComplexButton btn1 = new ComplexButton();
        btn1.setName("会员中心");
        btn1.setSub_button(new Button[]{btn11, btn12, btn13, btn14});

        ClickButton btn2 = new ClickButton();
        btn2.setName("推荐商品");
        btn2.setType("click");
        btn2.setKey("COMMEND");

        Menu menu = new Menu();
        menu.setButton(new Button[]{btn1, btn2});

        return menu;
    }

    public static void main(String[] args) {
        boolean result = MenuUtil.createMenu(getMenu(), ConnUtil.getToken());
        if(result) {
            System.out.println("菜单创建成功");
        } else {
            System.out.println("菜单创建失败");
        }
    }
}
