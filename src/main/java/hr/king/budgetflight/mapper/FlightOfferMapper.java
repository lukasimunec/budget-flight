package hr.king.budgetflight.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOfferSearch.Itinerary;
import com.amadeus.resources.FlightOfferSearch.SearchSegment;

import hr.king.budgetflight.dto.FlightOfferDTO;
import hr.king.budgetflight.dto.FlightOfferDetailsDTO;
import hr.king.budgetflight.model.FlightOffer;
import hr.king.budgetflight.model.FlightOfferDetails;
import hr.king.budgetflight.model.FlightOfferSegment;
import hr.king.budgetflight.utils.BudgetFlightUtils;

@Component
public class FlightOfferMapper {
	
	@Autowired
	BudgetFlightUtils budgetFlightUtils;
	
	public FlightOfferDTO databaseToDTO(FlightOffer offer) {

			FlightOfferDTO flightDTO = new FlightOfferDTO();
			flightDTO.setId(offer.getId());
			flightDTO.setDepartureAirport(offer.getDepartureAirport());
			flightDTO.setDestinationAirport(offer.getDestinationAirport());
			flightDTO.setDepartureDate(budgetFlightUtils.dbDateTimeToString(offer.getDepartureDate()));
			flightDTO.setReturnDate(offer.getReturnDate() != null ? budgetFlightUtils.dbDateTimeToString(offer.getReturnDate()) : null);
			flightDTO.setPrice(offer.getPrice());
			flightDTO.setBookableSeats(offer.getBookableSeats());
			flightDTO.setCurrency(offer.getCurrency());
			flightDTO.setSittings(offer.getSittings());
			flightDTO.setReturnSittings(offer.getReturnSittings());
			
			List<String> route = new ArrayList<String>();
			List<String> returnRoute = new ArrayList<String>();
						
			for(FlightOfferSegment segment : offer.getSegments()) {
				route.add(segment.getDepartureAirport());
			}
			route.add(offer.getSegments().get(offer.getSegments().size()-1).getArrivalAirport());

			if(offer.getReturnSegments() != null && !offer.getReturnSegments().isEmpty()) {
				for(FlightOfferSegment segment : offer.getReturnSegments()) {
					returnRoute.add(segment.getDepartureAirport());
				}
				returnRoute.add(offer.getReturnSegments().get(offer.getReturnSegments().size()-1).getArrivalAirport());
					
			}
			
			flightDTO.setRoute(route);
			flightDTO.setReturnRoute(returnRoute);
						
			return flightDTO;
	}
	
	public FlightOfferDetailsDTO databaseToDetailsDTO(FlightOffer offer) {
		
		FlightOfferDTO flightOfferDTO = databaseToDTO(offer);
				
		FlightOfferDetailsDTO details = new FlightOfferDetailsDTO();
		details.setFlightOffer(flightOfferDTO);
		details.setBasePrice(offer.getFlightOfferDetails().getBasePrice());
		details.setOneWay(budgetFlightUtils.oneWayToString(offer.getFlightOfferDetails().getOneWay()));
		details.setInstantTicketingRequired(budgetFlightUtils.instantTicketingToString(offer.getFlightOfferDetails().getInstantTicketingRequired()));
		details.setNonHomogeneous(budgetFlightUtils.nonHomogeneousToString(offer.getFlightOfferDetails().getNonHomogeneous()));
		details.setLastTicketingDate(budgetFlightUtils.dbDateToString(offer.getFlightOfferDetails().getLastTicketingDate()));
		
		return details;
	}
	

	public FlightOffer amadeusToDatabase(FlightOfferSearch flightOfferSearch) {

		FlightOffer flightOffer = new FlightOffer();
		flightOffer.setPrice(String.valueOf(flightOfferSearch.getPrice().getTotal()));
		flightOffer.setBookableSeats(flightOfferSearch.getNumberOfBookableSeats());
		flightOffer.setCurrency(flightOfferSearch.getPrice().getCurrency());

		Integer sittings = 0;
		Integer returnSittings = 0;
		Itinerary itinerary = flightOfferSearch.getItineraries()[0];
		
		List<FlightOfferSegment> route = new ArrayList<>();
		
		if(itinerary != null) {
			flightOffer.setDepartureAirport(itinerary.getSegments()[0].getDeparture().getIataCode());
			flightOffer.setDestinationAirport(itinerary.getSegments()[itinerary.getSegments().length-1].getArrival().getIataCode());
			flightOffer.setDepartureDate(budgetFlightUtils.amadeusDateTimeStringToDate(itinerary.getSegments()[0].getDeparture().getAt()));
			
			for(SearchSegment searchSegment : itinerary.getSegments()){
				
				FlightOfferSegment segment = new FlightOfferSegment();
				segment.setDepartureAirport(searchSegment.getDeparture().getIataCode());
				segment.setArrivalAirport(searchSegment.getArrival().getIataCode());
				segment.setDepartureDate(budgetFlightUtils.amadeusDateTimeStringToDate(searchSegment.getDeparture().getAt()));
				segment.setArrivalDate(budgetFlightUtils.amadeusDateTimeStringToDate(searchSegment.getArrival().getAt()));
				route.add(segment);
				
				sittings += 1;
			}
		}

		List<FlightOfferSegment> returnRoute = new ArrayList<>();
		if(flightOfferSearch.getItineraries().length == 2) {
			Itinerary returnItinerary = flightOfferSearch.getItineraries()[1];
			flightOffer.setReturnDate(budgetFlightUtils.amadeusDateTimeStringToDate(returnItinerary.getSegments()[0].getDeparture().getAt()));
			
			for(SearchSegment searchSegment : returnItinerary.getSegments()){
				
				FlightOfferSegment segment = new FlightOfferSegment();
				segment.setDepartureAirport(searchSegment.getDeparture().getIataCode());
				segment.setArrivalAirport(searchSegment.getArrival().getIataCode());
				segment.setDepartureDate(budgetFlightUtils.amadeusDateTimeStringToDate(searchSegment.getDeparture().getAt()));
				segment.setArrivalDate(budgetFlightUtils.amadeusDateTimeStringToDate(searchSegment.getArrival().getAt()));
				returnRoute.add(segment);
				
				returnSittings += 1;
			}
		}

		flightOffer.setSegments(route);
		flightOffer.setReturnSegments(returnRoute);
		flightOffer.setSittings(sittings);
		flightOffer.setReturnSittings(returnSittings);
		
		
		FlightOfferDetails flightOfferDetails = new FlightOfferDetails();
		flightOfferDetails.setBasePrice(String.valueOf(flightOfferSearch.getPrice().getBase()));
		flightOfferDetails.setOneWay(flightOfferSearch.isOneWay());
		flightOfferDetails.setInstantTicketingRequired(flightOfferSearch.isInstantTicketingRequired());
		flightOfferDetails.setNonHomogeneous(flightOfferSearch.isNonHomogeneous());
		flightOfferDetails.setLastTicketingDate(budgetFlightUtils.amadeusDateStringToDate(flightOfferSearch.getLastTicketingDate()));
		
		flightOffer.setFlightOfferDetails(flightOfferDetails);
		
		return flightOffer;
	}
	
}
