package com.example.easy_auction.DTO;

import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Lot;
import com.fasterxml.jackson.annotation.JsonInclude;

public class FullDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;
    private LotStatus status;
    private Integer currentPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private FistAndLastLotBidDTO lastBid;

    public FullDTO() {
    }

    public FullDTO(Integer id, String title, String description, Integer startPrice, Integer bidPrice, LotStatus status, Integer currentPrice, FistAndLastLotBidDTO lastBid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
        this.currentPrice = currentPrice;
        this.lastBid = lastBid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LotStatus getStatus() {
        return status;
    }

    public void setStatus(LotStatus status) {
        this.status = status;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public FistAndLastLotBidDTO getLastBid() {
        return lastBid;
    }

    public void setLastBid(FistAndLastLotBidDTO lastBid) {
        this.lastBid = lastBid;
    }

    public static FullDTO fromLotDTOtoFullDTO(LotDTO lotDTO){
        FullDTO fullDTO = new FullDTO();
        fullDTO.setId(lotDTO.getId());
        fullDTO.setTitle(lotDTO.getTitle());
        fullDTO.setDescription(lotDTO.getDescription());
        fullDTO.setStartPrice(lotDTO.getStartPrice());
        fullDTO.setBidPrice(lotDTO.getBidPrice());
        fullDTO.setStatus(lotDTO.getStatus());
        return fullDTO;
    }

    public static FullDTO fromLottoFullDTO(Lot lot){
        FullDTO fullDTO = new FullDTO();
        lot.setId(lot.getId());
        fullDTO.setStatus(lot.getStatus());
        fullDTO.setTitle(lot.getTitle());
        fullDTO.setDescription(lot.getDescription());
        fullDTO.setStartPrice(lot.getStartPrice());
        fullDTO.setBidPrice(lot.getBidPrice());
        return fullDTO;
    }
}

// Третий перевод + current, + lastBid, lastBid(fist? last B
