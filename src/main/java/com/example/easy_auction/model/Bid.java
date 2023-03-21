package com.example.easy_auction.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bid {
    @Id
    @GeneratedValue
    private Integer id;
    private String bidderName;
    private LocalDateTime bidDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lot lotId;

    public Bid() {
    }

    public Bid(String bidderName, LocalDateTime bidDate) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lot getLot() {
        return lotId;
    }

    public void setLot(Lot lotId) {
        this.lotId = lotId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public LocalDateTime getBidDate() {
        return bidDate;
    }

    public void setBidDate(LocalDateTime bidDate) {
        this.bidDate = bidDate;
    }

}
