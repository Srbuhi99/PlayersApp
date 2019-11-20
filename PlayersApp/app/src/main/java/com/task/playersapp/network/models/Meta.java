package com.task.playersapp.network.models;

public class Meta {
    private int total_pages;

    private int current_page;

    private int next_page;

    private int per_page;

    private int total_count;

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getCurrent_page() {
        return this.current_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }

    public int getNext_page() {
        return this.next_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPer_page() {
        return this.per_page;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_count() {
        return this.total_count;
    }
}
