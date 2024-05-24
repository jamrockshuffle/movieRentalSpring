package edu.pro.movierentalspring.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalPricingPolicy {

    private String id;
    private double standardRate;
    private double penaltyRate;
    private int penaltyThreshold;

    public RentalPricingPolicy(double standardRate, double penaltyRate, int penaltyThreshold) {
        this.standardRate = standardRate;
        this.penaltyRate = penaltyRate;
        this.penaltyThreshold = penaltyThreshold;
    }
}

