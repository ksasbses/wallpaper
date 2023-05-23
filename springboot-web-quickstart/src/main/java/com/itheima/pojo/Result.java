package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; // 响应码，1成功 0失败
    private String msg; //响应信息
    private Object data; //返回的数据
    // 增删改 响应成功
    public static Result success(){
        return new Result(1,"success",null);
    }
//    查询 响应成功
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //响应失败
    public static Result success(String msg){
        return new Result(0,"success",null);
    }

    public static Result error(String msg) {
        return new Result(0,msg,null);
    }
}
