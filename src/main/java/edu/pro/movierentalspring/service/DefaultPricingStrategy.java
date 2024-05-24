package edu.pro.movierentalspring.service;

import edu.pro.movierentalspring.model.Genre;
import edu.pro.movierentalspring.model.RentalPricingPolicy;
import org.springframework.stereotype.Service;
import java.util.EnumMap;
import java.util.Map;

@Service
public class DefaultPricingStrategy {

    private final Map<Genre, RentalPricingPolicy> defaultPrices;

    public DefaultPricingStrategy() {
        defaultPrices = new EnumMap<>(Genre.class);
        initializeDefaultPrices();
    }

    private void initializeDefaultPrices() {
        defaultPrices.put(Genre.REGULAR, new RentalPricingPolicy(2D, 4D, 2));
        defaultPrices.put(Genre.CHILDREN, new RentalPricingPolicy(1D, 3D, 1));
        defaultPrices.put(Genre.NEW_RELEASE, new RentalPricingPolicy(3D, 4D, 3));
    }

    public RentalPricingPolicy getPriceForGenre(Genre genre) {
        return defaultPrices.get(genre);
    }
}


