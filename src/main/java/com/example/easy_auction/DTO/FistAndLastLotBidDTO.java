package com.example.easy_auction.DTO;

import java.time.LocalDateTime;

public class FistAndLastLotBidDTO {
    private String name;
    private LocalDateTime bidDate;

    public FistAndLastLotBidDTO() {
    }

    public FistAndLastLotBidDTO(String name, LocalDateTime bidDate) {
        this.name = name;
        this.bidDate = bidDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBidDate() {
        return bidDate;
    }

    public void setBidDate(LocalDateTime bidDate) {
        this.bidDate = bidDate;
    }

}
