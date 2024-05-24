package edu.pro.movierentalspring.service;

import edu.pro.movierentalspring.model.RentalPricingPolicy;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculationService {

    public Double calculateTotalRentalPrice(Integer daysRented, RentalPricingPolicy pricingPolicy) {
        // Check if the rental period is within the penalty-free duration
        if (daysRented <= pricingPolicy.getPenaltyThreshold()) {
            // If within penalty-free duration, charge the standard price
            return pricingPolicy.getStandardRate();
        } else {
            // If beyond penalty-free duration, calculate penalty price
            int daysWithPenalty = daysRented - pricingPolicy.getPenaltyThreshold();
            return pricingPolicy.getStandardRate() + (pricingPolicy.getPenaltyRate() * daysWithPenalty);
        }
    }
}
