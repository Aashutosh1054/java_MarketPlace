package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="myMarket")
public class MarketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String equity;

    @Column
    public long price;

    public MarketEntity(Long id, String equity, long price) {
        this.id = id;
        this.equity = equity;
        this.price = price;
    }

    public MarketEntity() {
    }

    public long getId() {
        return id;
    }

    public String getEquity() {
        return equity;
    }

    public long getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}