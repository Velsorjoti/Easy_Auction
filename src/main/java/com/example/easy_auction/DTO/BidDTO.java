package com.example.easy_auction.DTO;

import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.Lot;

import java.time.LocalDateTime;

public class BidDTO {
    private Integer id;
    private String bidderName;
    private LocalDateTime bidDate;
    private Integer lot;

    public BidDTO() {
    }

    public BidDTO(Integer id, String bidderName, LocalDateTime bidDate, Integer lot) {
        this.id = id;
        this.bidderName = bidderName;
        this.bidDate = bidDate;
        this.lot = lot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lotId) {
        this.lot = lotId;
    }

    public static BidDTO toBidtoBidDTO(Bid bid){
        BidDTO bidDTO = new BidDTO();
        bidDTO.setId(bidDTO.getId());
        bidDTO.setBidderName(bid.getBidderName());
        bidDTO.setBidDate(bidDTO.getBidDate());
        return bidDTO;
    }

    public static Bid toBidDTOtoBid(BidDTO bidDTO) {
        Bid bid = new Bid();
        bid.setId(bid.getId());
        bid.setBidderName(bid.getBidderName());
        return bid;
    }

}
// Те же поля, что и в Bid модель,