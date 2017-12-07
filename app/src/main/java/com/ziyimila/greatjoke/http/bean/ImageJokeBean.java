package com.ziyimila.greatjoke.http.bean;

/**
 * Created by Administrator on 2017/12/6.
 * 图片搞笑图bean
 */

public class ImageJokeBean {

    /**
     * ct : 2015-07-30 01:10:29.995
     * img : http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0
     * title : 起来！就不~~~
     * type : 2
     */

    private String ct;
    private String img;
    private String title;
    private int type;

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
