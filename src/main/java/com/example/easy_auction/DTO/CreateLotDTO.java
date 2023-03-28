package com.example.easy_auction.DTO;

import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Lot;

public class CreateLotDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;

    public CreateLotDTO() {
    }

    public CreateLotDTO(Integer id, String title, String description, Integer startPrice, Integer bidPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
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

    public static CreateLotDTO fromCreateLotDTO(Lot lot) {
        CreateLotDTO createLotDTO = new CreateLotDTO();
        createLotDTO.setId(lot.getId());
        createLotDTO.setTitle(lot.getTitle());
        createLotDTO.setDescription(lot.getDescription());
        createLotDTO.setStartPrice(lot.getStartPrice());
        createLotDTO.setBidPrice(lot.getBidPrice());
        return createLotDTO;
    }

    public static Lot fromCreateLotDTOtoLot(CreateLotDTO createLotDTO) {
        Lot lot = new Lot();
        lot.setId(createLotDTO.getId());
        lot.setTitle(createLotDTO.getTitle());
        lot.setDescription(createLotDTO.getDescription());
        lot.setStartPrice(createLotDTO.getStartPrice());
        lot.setBidPrice(createLotDTO.getBidPrice());
        return lot;
    }
}
   /* public Lot toLot() {
        Lot lot = new Lot();
        lot.setId(this.getId());
        lot.setStatus(this.toLot().getStatus());
        lot.setTitle(this.getTitle());
        lot.setDescription(this.getDescription());
        lot.setStartPrice(this.getStartPrice());
        lot.setBidPrice(this.getBidPrice());
        return lot;*/

   /* private Long id;
    private LotStatus status;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;*/


