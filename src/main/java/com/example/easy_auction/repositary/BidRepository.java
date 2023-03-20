package com.example.easy_auction.repositary;

import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    @Query
    Projection getInfoAboutFistBid();
    @Query
    Projection getLoodaMan();
    @Query
    Integer getBidCount();
    @Query
    Projection getLastBid();
}
