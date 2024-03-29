package com.mac.ben.carlendar1;

public class RCVItem {
    private Integer Image;
    private String Title;
    private String Subtitle;
    private String Extra;


    RCVItem(Integer image, String title, String subtitle, String extra){
        Title = title;
        Subtitle = subtitle;
        Image = image;
        Extra = extra;
    }

    Integer getImage(){
        return Image;
    }

    String getTitle(){
        return Title;
    }

    String getSubtitle(){
        return Subtitle;
    }

    String getExtra(){
        return Extra;
    }

    public void setImage(Integer image){
        Image = image;
    }

    public void setTitle(String title){
        Title = title;
    }

    public void setSubtitle(String subtitle){
        Subtitle = subtitle;
    }

    public void setExtra(String extra){
        Extra = extra;
    }


}
