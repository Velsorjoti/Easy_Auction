package com.example.easy_auction.model;

import com.example.easy_auction.enumes.LotStatus;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Lot {
    @Id
    @GeneratedValue
    private Integer id;
    private LotStatus status;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;
    @OneToMany(mappedBy = "lot")
    private List<Bid> bidList;

    public Lot() {
    }

    public Lot(Integer id, LotStatus status, String title, String description, Integer startPrice, Integer bidPrice, List<Bid> bidList) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.bidList = bidList;
    }
}
