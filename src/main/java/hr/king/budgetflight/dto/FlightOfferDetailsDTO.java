package hr.king.budgetflight.dto;

public class FlightOfferDetailsDTO{

    private FlightOfferDTO flightOffer;
    private String lastTicketingDate;
    private String oneWay;
    private String instantTicketingRequired;
    private String nonHomogeneous;
    private String basePrice;
    
    public FlightOfferDTO getFlightOffer() {
		return flightOffer;
	}
	public void setFlightOffer(FlightOfferDTO flightOffer) {
		this.flightOffer = flightOffer;
	}
	public String getLastTicketingDate() {
		return lastTicketingDate;
	}
	public void setLastTicketingDate(String lastTicketingDate) {
		this.lastTicketingDate = lastTicketingDate;
	}
	public String getOneWay() {
		return oneWay;
	}
	public void setOneWay(String oneWay) {
		this.oneWay = oneWay;
	}
	public String getInstantTicketingRequired() {
		return instantTicketingRequired;
	}
	public void setInstantTicketingRequired(String instantTicketingRequired) {
		this.instantTicketingRequired = instantTicketingRequired;
	}
	public String getNonHomogeneous() {
		return nonHomogeneous;
	}
	public void setNonHomogeneous(String nonHomogeneous) {
		this.nonHomogeneous = nonHomogeneous;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
    
}
