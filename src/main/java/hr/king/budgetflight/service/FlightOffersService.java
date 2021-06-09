package hr.king.budgetflight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amadeus.resources.FlightOfferSearch;

import hr.king.budgetflight.constants.CurrencyEnum;
import hr.king.budgetflight.dto.FlightOfferDTO;
import hr.king.budgetflight.dto.SearchForm;
import hr.king.budgetflight.dto.TableForm;
import hr.king.budgetflight.mapper.FlightOfferMapper;
import hr.king.budgetflight.model.FlightOffer;
import hr.king.budgetflight.repository.FlightOfferRepository;
import hr.king.budgetflight.request.GetFlightOffersRequest;
import hr.king.budgetflight.response.GetFlightOffersResponse;
import hr.king.budgetflight.rest.AmadeusRest;
import hr.king.budgetflight.validation.GetFlightOffersValidation;

@Service
public class FlightOffersService {

	@Autowired
	GetFlightOffersValidation getFlightsOfferValidation;
	@Autowired
	FlightOfferRepository flightOfferRepository;
	@Autowired
	FlightOfferMapper flightOfferMapper;
	@Autowired
	AmadeusRest amadeusRest;
	
	public GetFlightOffersResponse getResponse(GetFlightOffersRequest getFlightsRequest) {
		
		getFlightsOfferValidation.validateRequest(getFlightsRequest);
		
		Page<FlightOffer> flightOffersList = getPageableFlightOffers(getFlightsRequest.getSearchForm(), getFlightsRequest.getTableForm());
		if(flightOffersList == null || flightOffersList.getTotalElements() == 0) {
			populateFlightOffersAmadeus(getFlightsRequest.getSearchForm());
			flightOffersList = getPageableFlightOffers(getFlightsRequest.getSearchForm(), getFlightsRequest.getTableForm());
		}

		List<FlightOfferDTO> flightOffersDTO = new ArrayList<FlightOfferDTO>();
		for(FlightOffer offer : flightOffersList) {
			flightOffersDTO.add(flightOfferMapper.databaseToDTO(offer));
		}

		GetFlightOffersResponse getFlightsOfferResponse = new GetFlightOffersResponse();
		getFlightsOfferResponse.setFlightList(flightOffersDTO);
		getFlightsOfferResponse.setPages(flightOffersList.getTotalPages());

		return getFlightsOfferResponse;
	}
	
	
	private Page<FlightOffer> getPageableFlightOffers(SearchForm searchForm, TableForm tableForm){

		Pageable pageable = PageRequest.of(tableForm.getPage(), tableForm.getPageSize());
		
		Page<FlightOffer> flightOfferList = flightOfferRepository.getBySearch(searchForm.getDepartureAirport().trim(),
				searchForm.getDestinationAirport().trim(),
				searchForm.getDepartureDate(),
				searchForm.getReturnDate(),
				searchForm.getNumberOfPassengers(),
				CurrencyEnum.find(searchForm.getCurrency()).getKey().trim(),
				pageable);
		
		return flightOfferList;
	}

	
	private void populateFlightOffersAmadeus(SearchForm searchForm) {
		FlightOfferSearch[] flightOffersSearch = amadeusRest.getFlightOffers(searchForm);
		for(FlightOfferSearch offer : flightOffersSearch) {
			FlightOffer flightOffer = flightOfferMapper.amadeusToDatabase(offer);
			flightOfferRepository.save(flightOffer);
		}
	}
	
}
