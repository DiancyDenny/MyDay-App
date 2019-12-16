package com.example.mydayapplication.model;

public class DiaryRequest {

    Integer userId;
    String date, title, desc;
    // Integer expense;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /*public Integer getExpense() {
        return expense;
    }

    public void setExpense(Integer expense) {
        this.expense = expense;
    }*/
}