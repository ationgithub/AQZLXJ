package com.shtoone.aqxj.bean;

public class MessageData {
//    {"type":"0", "text":"这是一条审核消息" }
    String type ;
    String text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
