package com.example.easy_auction.repositary;

import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface LotRepositary  extends JpaRepository<Lot, Integer> {
    public Collection<Lot> findAllByStatus(LotStatus status);

}
