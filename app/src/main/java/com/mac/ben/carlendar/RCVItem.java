package com.mac.ben.carlendar;

public class RCVItem {
    private Integer Image;
    private String Title;
    private String Subtitle;


    public RCVItem(Integer image, String title, String subtitle){
        Title = title;
        Subtitle = subtitle;
        Image = image;
    }

    public Integer getImage(){
        return Image;
    }

    public String getTitle(){
        return Title;
    }

    public String getSubtitle(){
        return Subtitle;
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


}
