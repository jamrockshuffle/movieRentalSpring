package edu.pro.movierentalspring.service;

import edu.pro.movierentalspring.model.RentalPricingPolicy;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculationService {

    public Double calculateTotalRentalPrice(Integer daysRented, RentalPricingPolicy pricingPolicy) {
        if (daysRented <= pricingPolicy.getPenaltyThreshold()) {
            return pricingPolicy.getStandardRate() * daysRented;
        } else {
            int daysWithPenalty = daysRented - pricingPolicy.getPenaltyThreshold();
            int daysWithoutPenalty = daysRented - daysWithPenalty;
            return pricingPolicy.getStandardRate() * daysWithoutPenalty + (pricingPolicy.getPenaltyRate() * daysWithPenalty);
        }
    }
}
