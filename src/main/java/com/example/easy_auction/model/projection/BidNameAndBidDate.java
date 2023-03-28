package com.example.easy_auction.model.projection;

import java.time.LocalDateTime;

public interface BidNameAndBidDate {
     String getBidderName();
     LocalDateTime getBidDate();
}
