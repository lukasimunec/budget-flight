package hr.king.budgetflight.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FlightOfferDetails {
	
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Date lastTicketingDate;
    @Column
    private Boolean oneWay;
    @Column
    private Boolean instantTicketingRequired;
    @Column
    private Boolean nonHomogeneous;
    @Column
    private String basePrice;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getOneWay() {
		return oneWay;
	}
	public void setOneWay(Boolean oneWay) {
		this.oneWay = oneWay;
	}
	public Date getLastTicketingDate() {
		return lastTicketingDate;
	}
	public void setLastTicketingDate(Date lastTicketingDate) {
		this.lastTicketingDate = lastTicketingDate;
	}
	public Boolean getInstantTicketingRequired() {
		return instantTicketingRequired;
	}
	public void setInstantTicketingRequired(Boolean instantTicketingRequired) {
		this.instantTicketingRequired = instantTicketingRequired;
	}
	public Boolean getNonHomogeneous() {
		return nonHomogeneous;
	}
	public void setNonHomogeneous(Boolean nonHomogeneous) {
		this.nonHomogeneous = nonHomogeneous;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
          
}
