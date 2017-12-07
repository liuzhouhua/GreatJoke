package com.ziyimila.greatjoke.http.bean;

/**
 * Created by Administrator on 2017/12/6.
 * 动态搞笑图bean
 */

public class GifJokeBean {

    /**
     * ct : 2016-05-30 16:30:27.242
     * id : 574bfa236e36c1d5f9289678
     * img : http://www.zbjuran.com/uploads/allimg/160530/2-160530145631924.gif
     * title : 要不要来个鸳鸯戏水呢
     * type : 3
     */

    private String ct;
    private String id;
    private String img;
    private String title;
    private int type;

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
