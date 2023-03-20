package com.example.easy_auction.service;

import com.example.easy_auction.repositary.BidRepository;
import com.example.easy_auction.repositary.LotRepositary;
import org.springframework.stereotype.Service;

@Service
public class LotService {
    private LotRepositary lotRepositary;
    private BidRepository bidRepository;

    public LotService(LotRepositary lotRepositary, BidRepository bidRepository) {
        this.lotRepositary = lotRepositary;
        this.bidRepository = bidRepository;
    }
}
  // Девять методов.