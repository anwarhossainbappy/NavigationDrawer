package com.example.bappy_cox.navigationdrawerfragment;

/**
 * Created by BAPPY-COX on 7/3/2018.
 */

public class News {
    //--initialising variable--//

    private String image;
    private String title;
    private String category;
    private String writer;
    private String date;
    private String details;

    public News(String image, String title, String category,String writer,String date,String details) {
        this.image = image;
        this.title = title;
        this.category = category;
        this.writer = writer;
        this.date = date;
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
