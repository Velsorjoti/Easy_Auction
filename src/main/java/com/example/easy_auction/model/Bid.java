package com.example.easy_auction.model;

import javax.persistence.*;

@Entity
public class Bid {
    @Id
    @GeneratedValue
    private Integer idB;
    private String bidderName;
    private String bidDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lot lot;

    public Bid() {
    }

    public Bid(String bidderName, String bidDate) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getBidDate() {
        return bidDate;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }
}
