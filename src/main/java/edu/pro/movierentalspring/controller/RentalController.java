package edu.pro.movierentalspring.controller;

import edu.pro.movierentalspring.model.Customer;
import edu.pro.movierentalspring.model.Genre;
import edu.pro.movierentalspring.model.Movie;
import edu.pro.movierentalspring.model.Rental;
import edu.pro.movierentalspring.service.RentalCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalCalculationService rentalService;

    @GetMapping("/calculateTotalPrice")
    public String calculateTotalPrice() {

        Customer customer = new Customer("1", "John Doe");

        Movie regularMovie = new Movie("1", "Rembo", Genre.REGULAR);

        Movie childrenMovie = new Movie("1", "Harry Potter", Genre.CHILDREN);

        Movie newReleaseMovie = new Movie("1", "LOTR", Genre.NEW_RELEASE);

        Rental regularRental = new Rental("1",
                customer,
                regularMovie,
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now());

        Rental childrenRental = new Rental("1",
                customer,
                childrenMovie,
                LocalDateTime.now().minusDays(4),
                LocalDateTime.now());

        Rental newReleaseRental = new Rental("1",
                customer,
                newReleaseMovie,
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now());

        List<Rental> rentals = Arrays.asList(childrenRental, regularRental, newReleaseRental);

        double totalPrice = rentalService.calculateTotalPriceForRentals(rentals);
        return String.format("Total price is: %.2f", totalPrice);
    }
}



