package com.example.easy_auction.repositary;

import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.projection.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    @Query(value = "SELECT bidder_name AS bidderName, bid_date AS bidDate FROM bid WHERE lot_id=?1 ORDER BY bid_date LIMIT 1", nativeQuery = true)
    Projection getInfoAboutFistBid(Integer id);
    @Query(value = "SELECT bidder_name AS  bidderName, MAX(b.bids) AS max_bids, MAX(last_bid_date) AS dateBid" +
            "FROM (bidder_name, COUN(*) AS bids, MAX(bid_date) AS last_date)" +
            "FROM bid WHERE lot_id=?1 GROUP BY bidder_name) AS b" +
            "GROUP BY bidder_name ORDER BY max_bids DESC LIMIT 1", nativeQuery = true
    )
    Projection getAvidGambler(Integer id);
    @Query(value = "SELECT COUNT(*) FROM bid WHERE lot_id=?1", nativeQuery = true)
    Integer getBidCount(Integer id);
    @Query(value = "SELECT bidder_name AS bidderName, bid_date AS bidDate FROM bid WHERE lot_id=?1 ORDER BY bid_date DESC LIMIT 1", nativeQuery = true)
    Projection getLastBid(Integer id);
}
