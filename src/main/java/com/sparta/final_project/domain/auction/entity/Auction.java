package com.sparta.final_project.domain.auction.entity;

import com.sparta.final_project.domain.auction.dto.request.AuctionRequest;
import com.sparta.final_project.domain.common.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auctions")
public class Auction extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int startPrice;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

//    아이템 연관관계
//    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "item_id")
//    private Item item;


    public Auction(AuctionRequest auctionRequest) {
        this.startPrice = auctionRequest.getStartPrice();
        this.startTime = auctionRequest.getStartTime();
        this.endTime = auctionRequest.getEndTime();
        this.grade = auctionRequest.getGrade();
        this.status = Status.WAITING;
    }

    public void update(AuctionRequest auctionRequest) {
        this.startPrice = auctionRequest.getStartPrice();
        this.startTime = auctionRequest.getStartTime();
        this.endTime = auctionRequest.getEndTime();
        this.grade = auctionRequest.getGrade();
        this.status = Status.WAITING;
    }

    public void BidSuccess(Status status ,LocalDateTime endTime) {
        this.status = status;
        this.endTime = endTime;
    }
}
