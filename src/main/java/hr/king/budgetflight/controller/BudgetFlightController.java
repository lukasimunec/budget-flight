package hr.king.budgetflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.king.budgetflight.request.GetFlightOffersRequest;
import hr.king.budgetflight.response.GetFlightOfferDetailsResponse;
import hr.king.budgetflight.response.GetFlightOffersResponse;
import hr.king.budgetflight.service.FlightOfferDetailsService;
import hr.king.budgetflight.service.FlightOffersService;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class BudgetFlightController {

	@Autowired
	FlightOffersService flightOffersService;
	@Autowired
	FlightOfferDetailsService flightOfferDetailsService;

	@RequestMapping(value = "/flight-offers", method = RequestMethod.POST)
	public GetFlightOffersResponse getFlightOffers(@RequestBody GetFlightOffersRequest request) {

		return flightOffersService.getResponse(request);

	}

	@RequestMapping(value = "/flight-offer-details", method = RequestMethod.GET)
	public GetFlightOfferDetailsResponse getFlightOfferDetails(@RequestParam("id") Long id) {

		return flightOfferDetailsService.getResponse(id);

	}

}
