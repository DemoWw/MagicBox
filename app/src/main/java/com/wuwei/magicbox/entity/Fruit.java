package com.wuwei.magicbox.entity;

/**
 * Created by pjy on 2017/8/23.
 */

public class Fruit {
    private String name;//水果的名称
    private int imageId;//图片资源Id


    public Fruit() {
    }

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
