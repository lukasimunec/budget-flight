package hr.king.budgetflight.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;

import hr.king.budgetflight.constants.CurrencyEnum;
import hr.king.budgetflight.dto.SearchForm;
import hr.king.budgetflight.exception.BudgetFlightException;
import hr.king.budgetflight.properties.AppProperties;
import hr.king.budgetflight.utils.BudgetFlightUtils;

@Component
public class AmadeusRest {
	
	@Autowired
	AppProperties appProperties;
	@Autowired
	BudgetFlightUtils budgetFlightUtils;
	
	public FlightOfferSearch[] getFlightOffers(SearchForm searchForm) {

		Amadeus amadeus = Amadeus.builder(appProperties.getAmadeusClientId(), appProperties.getAmadeusClientSecret()).build();
		
		Params params = Params.with("originLocationCode", searchForm.getDepartureAirport())
				.and("destinationLocationCode", searchForm.getDestinationAirport())
				.and("departureDate", budgetFlightUtils.dateToAmadeusString(searchForm.getDepartureDate()))
				.and("currencyCode", CurrencyEnum.find(searchForm.getCurrency()))
				.and("adults", searchForm.getNumberOfPassengers());
		
		if(searchForm.getReturnDate() != null) {
			params.and("returnDate", budgetFlightUtils.dateToAmadeusString(searchForm.getReturnDate()));
		}
		
		try {
			return amadeus.shopping.flightOffersSearch.get(params);
		} catch (ResponseException e) {
			throw new BudgetFlightException(e.getMessage());
		}
	}
	
}
