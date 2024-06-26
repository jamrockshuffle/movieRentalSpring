package edu.pro.movierentalspring.service;

import edu.pro.movierentalspring.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalCalculationService {

    @Autowired
    DefaultPricingStrategy defaultPricingStrategy;

    @Autowired
    PriceCalculationService priceCalculationService;

    private Integer calculateRentalDays(LocalDateTime start, LocalDateTime finish) {
        return (int) ChronoUnit.DAYS.between(start, finish);
    }

    public Double calculateTotalPriceForRentals(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(rental -> {
                    int daysRented = calculateRentalDays(rental.getStart(), rental.getFinish());
                    return priceCalculationService.calculateTotalRentalPrice(
                            daysRented,
                            defaultPricingStrategy.getPriceForGenre(rental.getMovie().getGenre())
                    );
                })
                .sum();
    }
}

