package hr.king.budgetflight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import hr.king.budgetflight.dto.BudgetFlightError;

@ControllerAdvice
public class BudgetFlightErrorController {

    Logger logger = LoggerFactory.getLogger(BudgetFlightErrorController.class);
    
	@ExceptionHandler({ Exception.class })
	public BudgetFlightError exceptionHandler(Exception ex) {
		logger.error(ex.getMessage(), ex);
		BudgetFlightError error = new BudgetFlightError();
		error.setMessage(ex.getMessage());
		return error;
	}
	
}
