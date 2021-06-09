package hr.king.budgetflight.response;

import hr.king.budgetflight.dto.FlightOfferDetailsDTO;

public class GetFlightOfferDetailsResponse {
	
	private FlightOfferDetailsDTO flightOfferDetails;
	
	public FlightOfferDetailsDTO getFlightOfferDetails() {
		return flightOfferDetails;
	}

	public void setFlightOfferDetails(FlightOfferDetailsDTO flightOfferDetails) {
		this.flightOfferDetails = flightOfferDetails;
	}
	
}
