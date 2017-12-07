package com.ziyimila.greatjoke.http.bean;

/**
 * Created by Administrator on 2017/12/6.
 * 文本搞笑bean
 */

public class TextContentJokeBean {

    /**
     * ct : 　2015-07-10 05:54:00.000
     * text : 　　男生拉着女生沮丧着脸说，再给我一次机会，求求你！说好不提分手的！<br />
     　　女生甩开男孩的手说：你TM现在在我心里就是个菩萨，除了拜拜我什么都不想做。
     * title : 你TM现在在我心里就是个菩萨
     */

    private String ct;
    private String text;
    private String title;

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
