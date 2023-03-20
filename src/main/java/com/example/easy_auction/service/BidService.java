package com.example.easy_auction.service;

import com.example.easy_auction.DTO.BidDTO;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.repositary.BidRepository;
import com.example.easy_auction.repositary.LotRepositary;
import org.springframework.stereotype.Service;

@Service
public class BidService {
    private LotRepositary lotRepositary;
    private BidRepository bidRepository;

    public BidService(LotRepositary lotRepositary, BidRepository bidRepository) {
        this.lotRepositary = lotRepositary;
        this.bidRepository = bidRepository;
    }

    public BidDTO createBid(BidDTO bidDTO){
        Lot lot = bidDTO.
    }
}
