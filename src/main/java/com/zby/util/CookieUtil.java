package com.zby.util;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    public static Map<String,String> cookiesToMap (Cookie[] cookies){
        Map<String,String> map = new HashMap<>();
        //如果用数组遍历，cookie为空时，会报空指针，所以要加判断条件判断cookie是否为空
        if (cookies != null){
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(),cookie.getValue());// 存的键值
            }
        }
        return map;
    }
}
