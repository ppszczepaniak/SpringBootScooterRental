package com.example.scooterRental.controller;

import com.example.scooterRental.api.BasicResponse;
import com.example.scooterRental.service.RentalService;
import com.example.scooterRental.service.impl.RentalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental")
public class RentalController {

    private RentalServiceImpl rentalService;

    public RentalController(RentalServiceImpl rentalService) {
        this.rentalService = rentalService;
    }

    //PUT /rental/{scooterId}/scooter - żądanie będzie pozwalało na wypożyczenie hulajnogi o wskazanym id.

    @PutMapping(value = "/{scooterId}/scooter", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BasicResponse> rentScooter(
            @PathVariable Long scooterId,
            @RequestParam Long accountId
    ) {
        return rentalService.rentScooter(scooterId, accountId);
    }

}
