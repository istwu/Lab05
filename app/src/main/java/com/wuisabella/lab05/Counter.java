package com.wuisabella.lab05;

import java.util.HashMap;
import java.util.Map;

public class Counter {

    Map<String, Integer> map;

    public Counter() {
        map = new HashMap<>();
    }

    public void add(String method){
        if(map.get(method) != null){
            int num = map.get(method) + 1;
            map.put(method, num);
        }
        else{
            map.put(method, 1);
        }
    }

    public Integer get(String method){
        if(map.get(method) == null){
            return 0;
        }
        else {
            return map.get(method);
        }
    }

    public void reset(){
        for(String key : map.keySet()){
            map.put(key, 0);
        }
    }
}