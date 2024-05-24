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
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalCalculationService rentalService;

    @GetMapping("/calculateTotalPrice")
    public ResponseEntity<String> calculateTotalPrice() {

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");

        Movie regularMovie = new Movie();
        regularMovie.setId("1");
        regularMovie.setTitle("Rembo");
        regularMovie.setGenre(Genre.REGULAR);

        Movie childrenMovie = new Movie();
        childrenMovie.setId("1");
        childrenMovie.setTitle("Harry Potter");
        childrenMovie.setGenre(Genre.CHILDREN);

        Movie newReleaseMovie = new Movie();
        newReleaseMovie.setId("1");
        newReleaseMovie.setTitle("LOTR");
        newReleaseMovie.setGenre(Genre.NEW_RELEASE);

        Rental regularRental = new Rental();
        regularRental.setId("1");
        regularRental.setMovie(regularMovie);
        regularRental.setCustomer(customer);
        regularRental.setStart(LocalDateTime.now().minusDays(2));
        regularRental.setFinish(LocalDateTime.now());

        Rental childrenRental = new Rental();
        childrenRental.setId("1");
        childrenRental.setMovie(childrenMovie);
        childrenRental.setCustomer(customer);
        childrenRental.setStart(LocalDateTime.now().minusDays(4));
        childrenRental.setFinish(LocalDateTime.now());

        Rental newReleaseRental = new Rental();
        newReleaseRental.setId("1");
        newReleaseRental.setMovie(newReleaseMovie);
        newReleaseRental.setCustomer(customer);
        newReleaseRental.setStart(LocalDateTime.now().minusDays(7));
        newReleaseRental.setFinish(LocalDateTime.now());

        List<Rental> rentals = Arrays.asList(childrenRental, regularRental, newReleaseRental);

        double totalPrice = rentalService.calculateTotalPriceForRentals(rentals);
        String response = String.format("Total price is: %.2f", totalPrice);
        return ResponseEntity.ok(response);
    }
}



