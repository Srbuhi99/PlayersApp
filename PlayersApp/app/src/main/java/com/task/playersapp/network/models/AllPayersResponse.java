package com.task.playersapp.network.models;

import java.util.List;

public class AllPayersResponse {
    private List<Data> data;

    private Meta meta;

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta getMeta() {
        return this.meta;
    }
}
