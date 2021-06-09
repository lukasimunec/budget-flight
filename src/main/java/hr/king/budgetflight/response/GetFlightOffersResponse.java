package hr.king.budgetflight.response;

import java.util.List;

import hr.king.budgetflight.dto.FlightOfferDTO;

public class GetFlightOffersResponse {

	private List<FlightOfferDTO> flightList;
	private Integer pages;
	
	public List<FlightOfferDTO> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<FlightOfferDTO> flightList) {
		this.flightList = flightList;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

}
