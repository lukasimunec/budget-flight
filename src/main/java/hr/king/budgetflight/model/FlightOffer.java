package hr.king.budgetflight.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FlightOffer {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String departureAirport;
    @Column
    private String destinationAirport;
    @Column
    private Date departureDate;
    @Column
    private Date returnDate;
    @OneToMany(cascade = {CascadeType.ALL})
    @Column    
    private List<FlightOfferSegment> segments;
    @OneToMany(cascade = {CascadeType.ALL})
    @Column
    private List<FlightOfferSegment> returnSegments;
    @Column
	private Integer sittings;
    @Column
	private Integer bookableSeats;
    @Column
	private Integer returnSittings;
    @Column
	private String currency;
    @Column
	private String price;
    @OneToOne(cascade = {CascadeType.ALL})
    private FlightOfferDetails flightOfferDetails;
    
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
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public List<FlightOfferSegment> getSegments() {
		return segments;
	}
	public void setSegments(List<FlightOfferSegment> segments) {
		this.segments = segments;
	}
	public List<FlightOfferSegment> getReturnSegments() {
		return returnSegments;
	}
	public void setReturnSegments(List<FlightOfferSegment> returnSegments) {
		this.returnSegments = returnSegments;
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
	public FlightOfferDetails getFlightOfferDetails() {
		return flightOfferDetails;
	}
	public void setFlightOfferDetails(FlightOfferDetails flightOfferDetails) {
		this.flightOfferDetails = flightOfferDetails;
	}
        
}