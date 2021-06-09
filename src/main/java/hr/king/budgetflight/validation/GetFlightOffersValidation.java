package hr.king.budgetflight.validation;

import org.springframework.stereotype.Component;

import hr.king.budgetflight.constants.BudgetFlightExceptionConstants;
import hr.king.budgetflight.constants.CurrencyEnum;
import hr.king.budgetflight.exception.BudgetFlightException;
import hr.king.budgetflight.request.GetFlightOffersRequest;

@Component
public class GetFlightOffersValidation {
	
	public void validateRequest(GetFlightOffersRequest getFlightsOfferRequest) {

		if(getFlightsOfferRequest.getSearchForm().getDepartureAirport() == null || getFlightsOfferRequest.getSearchForm().getDepartureAirport().length() != 3) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_IATA);
		}else if(getFlightsOfferRequest.getSearchForm().getDepartureAirport() == null || getFlightsOfferRequest.getSearchForm().getDepartureAirport().length() != 3) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_IATA);
		}else if(getFlightsOfferRequest.getSearchForm().getDepartureDate() == null) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_DATE);
		}else if(getFlightsOfferRequest.getSearchForm().getNumberOfPassengers() < 1 || getFlightsOfferRequest.getSearchForm().getNumberOfPassengers() > 9 ) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_PASSENGERS);
		}else if(CurrencyEnum.find(getFlightsOfferRequest.getSearchForm().getCurrency()) == null) {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.INVALID_REQUEST_CURRENCY);
		}
		
	}
	
}
