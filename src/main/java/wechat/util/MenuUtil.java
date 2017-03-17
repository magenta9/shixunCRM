package wechat.util;

import util.GsonUtil;
import wechat.menu.Menu;

import java.util.Map;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class MenuUtil {
    //菜单创建POST
    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    //菜单查询GET
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    //菜单删除GET
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     * @param menu
     * @param accessToken
     * @return true/false
     */
    public static boolean createMenu(Menu menu, String accessToken) {
        boolean result = false;

        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        String jsonMenu = GsonUtil.gson.toJson(menu).toString();
        System.out.println(jsonMenu);
        String gsonObject = ConnUtil.httpRequest(url, "POST", jsonMenu);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        System.out.println(gsonObject);
        if(jsonMenu != null) {
            Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
            double errorCode = Double.valueOf(((Object)(map.get("errcode"))).toString()).doubleValue();
            String errorMsg = map.get("errmsg");
            if(errorCode > -0.1 && errorCode < 0.1) {
                result = true;
            } else {
                result = false;
                System.out.printf("创建菜单失败 errorcode:%s errmsg:%s\n", errorCode, errorMsg);
            }
        }
        return result;
    }

    public static String getMenu(String accessToken) {
        String result = null;
        String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);

        String gsonObject = ConnUtil.httpRequest(requestUrl, "GET", null);
        if (gsonObject != null) {
            result = gsonObject;
            result = result.substring(1, result.length() - 1);
            result = result.replace("\\\"", "\"");
        }
        return result;
    }

    public static boolean deleteMenu(String accessToken) {
        boolean result = false;
        String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
        String gsonObject = ConnUtil.httpRequest(requestUrl, "GET", null);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        if(gsonObject != null) {
            Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
            double errorCode = Double.valueOf(((Object)(map.get("errcode"))).toString()).doubleValue();
            String errorMsg = map.get("errmsg");
            if (errorCode == 0) {
                result = true;
            } else {
                result = false;
                System.out.printf("删除菜单失败 errcode:%s errmsg:%s\n", errorCode, errorMsg);
            }
        }
        return result;
    }

}
