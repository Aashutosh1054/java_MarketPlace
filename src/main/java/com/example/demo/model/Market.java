package com.example.demo.model;

public class Market{
    public long id;
    public String equity;
    public long price;

    public Market(long id, String equity, long price) {
        this.id = id;
        this.equity = equity;
        this.price = price;
    }

    public Market() {
    }
}