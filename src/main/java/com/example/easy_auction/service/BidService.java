package com.example.easy_auction.service;

import com.example.easy_auction.DTO.BidDTO;
import com.example.easy_auction.DTO.LotDTO;
import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.repositary.BidRepository;
import com.example.easy_auction.repositary.LotRepositary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BidService {
    private final LotRepositary lotRepositary;
    private final BidRepository bidRepository;
    private final LotService lotService;

    public BidService(LotRepositary lotRepositary, BidRepository bidRepository, LotService lotService) {
        this.lotRepositary = lotRepositary;
        this.bidRepository = bidRepository;
        this.lotService = lotService;
    }

    public BidDTO createBid(BidDTO bidDTO){
        Lot lot = LotDTO.fromLotDTOtoLot(lotService.getLotById(bidDTO.getId()));
        Bid bid = BidDTO.toBidDTOtoBid(bidDTO);
        bid.setLot(lot);
        bid.setBidDate(LocalDateTime.now());
        Bid sBid = bidRepository.save(bid);
        return BidDTO.toBidtoBidDTO(sBid);
    }
}
