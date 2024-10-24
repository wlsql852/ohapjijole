package com.sparta.final_project.domain.bid.repository;

import com.sparta.final_project.domain.auction.entity.Auction;
import com.sparta.final_project.domain.bid.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findAllByAuctionOrderByCreatedAtDesc(Auction auction);
}
