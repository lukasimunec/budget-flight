package hr.king.budgetflight.dto;

import java.util.List;

public class FlightOfferDTO {

    private Long id;
    private String departureAirport;
    private String destinationAirport;
    private String departureDate;
    private String returnDate;
    List<String> route;
    List<String> returnRoute;
	private Integer bookableSeats;
	private Integer sittings;
	private Integer returnSittings;
	private String currency;
	private String price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public List<String> getRoute() {
		return route;
	}
	public void setRoute(List<String> route) {
		this.route = route;
	}
	public List<String> getReturnRoute() {
		return returnRoute;
	}
	public void setReturnRoute(List<String> returnRoute) {
		this.returnRoute = returnRoute;
	}
	public Integer getSittings() {
		return sittings;
	}
	public void setSittings(Integer sittings) {
		this.sittings = sittings;
	}
	public Integer getBookableSeats() {
		return bookableSeats;
	}
	public void setBookableSeats(Integer bookableSeats) {
		this.bookableSeats = bookableSeats;
	}
	public Integer getReturnSittings() {
		return returnSittings;
	}
	public void setReturnSittings(Integer returnSittings) {
		this.returnSittings = returnSittings;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
