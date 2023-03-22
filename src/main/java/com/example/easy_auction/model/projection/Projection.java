package com.example.easy_auction.model.projection;

import java.time.LocalDateTime;

public interface Projection {
     String getBidderName();
     LocalDateTime getBidDate();
}
