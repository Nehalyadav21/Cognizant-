package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.Loan;

@RestController
public class LoanController {

	// Dummy response, no backend connectivity - as per exercise instructions
	@GetMapping("/loans/{number}")
	public Loan getLoanDetails(@PathVariable String number) {
		return new Loan(number, "car", 400000, 3258, 18);
	}

}
