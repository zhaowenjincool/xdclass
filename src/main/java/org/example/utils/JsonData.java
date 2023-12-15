package org.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@AllArgsConstructor
@ToString
public class JsonData implements Serializable {
    private int code;
    private Object data;
    private String msg;

    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }
    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data,null);
    }
    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }
    public static JsonData buildError(Integer code , String  msg){
        return new JsonData(code ,null,msg);
    }
}
