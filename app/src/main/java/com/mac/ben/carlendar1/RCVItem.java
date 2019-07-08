package com.mac.ben.carlendar1;

public class RCVItem {
    private Integer Image;
    private String Title;
    private String Subtitle;


    RCVItem(Integer image, String title, String subtitle){
        Title = title;
        Subtitle = subtitle;
        Image = image;
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
