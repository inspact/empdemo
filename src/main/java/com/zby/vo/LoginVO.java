package com.zby.vo;

import lombok.Data;

@Data
public class LoginVO {

    private Integer status;
    private String message;

    /**
     * 利用静态方法创建对象
     */
    public static LoginVO success(){
        LoginVO loginVO = new LoginVO();
        loginVO.setStatus(0);
        loginVO.setMessage("成功登录");
        return loginVO;
    }

    public static LoginVO error(Integer status,String message){
        LoginVO loginVO = new LoginVO();
        loginVO.setStatus(status);
        loginVO.setMessage(message);
        return loginVO;
    }



}
