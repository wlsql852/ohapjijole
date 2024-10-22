package com.sparta.final_project.domain.bid.entity;

import com.sparta.final_project.domain.auction.entity.Auction;
import com.sparta.final_project.domain.bid.dto.request.BidRequest;
import com.sparta.final_project.domain.common.entity.Timestamped;
import com.sparta.final_project.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "bids")
public class Bid extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bid_id")
    private Long id;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Bid(BidRequest request, User user, Auction auction) {
        this.price = request.getPrice();
        this.auction = auction;
        this.user = user;
    }
}
