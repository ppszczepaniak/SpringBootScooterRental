package com.example.scooterRental.controller;


import com.example.scooterRental.api.request.AddScooterRequest;
import com.example.scooterRental.api.response.AddScooterResponse;
import com.example.scooterRental.service.ScooterService;
import com.example.scooterRental.service.impl.ScooterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scooter")
public class ScooterController {

    private ScooterServiceImpl scooterService;

    public ScooterController(ScooterServiceImpl scooterService) {
        this.scooterService = scooterService;
    }
    //POST /scooter/add - żądanie będzie pozwalało na wprowadzenie nowej hulajnogi do systemu.

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED) //201
    public ResponseEntity<AddScooterResponse> addScooter(
            @RequestBody AddScooterRequest request
            //to taki rodzaj DTO
    ) {
        return scooterService.addScooter(request);
    }
}
