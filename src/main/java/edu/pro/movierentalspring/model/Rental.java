package edu.pro.movierentalspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental {
    private String id;
    private Customer customer;
    private Movie movie;
    private LocalDateTime start;
    private LocalDateTime finish;
}

