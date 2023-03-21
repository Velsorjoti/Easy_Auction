package com.example.easy_auction.DTO;

import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Lot;

public class LotDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;
    private LotStatus status;

    public LotDTO() {
    }

    public LotDTO(Integer id, String title, String description, Integer startPrice, Integer bidPrice, LotStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.status = status;
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

    public static LotDTO fromLottoLotDTO(Lot lot){
        LotDTO lotDTO = new LotDTO();
        lotDTO.setId(lotDTO.getId());
        lotDTO.setTitle(lot.getTitle());
        lotDTO.setDescription(lot.getDescription());
        lotDTO.setStartPrice(lot.getStartPrice());
        lotDTO.setBidPrice(lot.getBidPrice());
        lotDTO.setStatus(lot.getStatus());
        return lotDTO;
    }

    public static Lot fromLotDTOtoLot(LotDTO lotDTO){
        Lot lot =new Lot();
        lot.setId(lot.getId());
        lot.setStatus(lot.getStatus());
        lot.setTitle(lot.getTitle());
        lot.setDescription(lot.getDescription());
        lot.setStartPrice(lot.getStartPrice());
        lot.setBidPrice(lot.getBidPrice());
        return lot;
    }

}


// Второй перевод + status