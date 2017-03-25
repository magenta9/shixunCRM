package util;

/**
 * Created by zwd on 2017/3/21.
 */
public class StringUtils {
    //判断字符串是否存在且不为空
    public static boolean isEmpty(String str){
        boolean flag = false;
        if(str == null || str.length() <= 0){
            flag = true;
        }
        return flag;
    }
}
