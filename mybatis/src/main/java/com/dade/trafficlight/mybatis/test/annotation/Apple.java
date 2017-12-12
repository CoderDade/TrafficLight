package com.dade.trafficlight.mybatis.test.annotation;

import lombok.Data;

@Data
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor= FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

}
