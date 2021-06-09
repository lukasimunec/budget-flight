package hr.king.budgetflight.validation;

import org.springframework.stereotype.Component;

import hr.king.budgetflight.constants.BudgetFlightExceptionConstants;
import hr.king.budgetflight.exception.BudgetFlightException;


@Component
public class GetFlightOfferDetailsValidation {
	
	public void validateRequest(Long id) {
		if(id < 1) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_ID);
		}
	}
	
}
