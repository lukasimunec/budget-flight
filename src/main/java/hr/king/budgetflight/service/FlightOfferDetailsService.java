package hr.king.budgetflight.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.king.budgetflight.constants.BudgetFlightExceptionConstants;
import hr.king.budgetflight.dto.FlightOfferDetailsDTO;
import hr.king.budgetflight.exception.BudgetFlightException;
import hr.king.budgetflight.mapper.FlightOfferMapper;
import hr.king.budgetflight.model.FlightOffer;
import hr.king.budgetflight.repository.FlightOfferRepository;
import hr.king.budgetflight.response.GetFlightOfferDetailsResponse;
import hr.king.budgetflight.validation.GetFlightOfferDetailsValidation;

@Service
public class FlightOfferDetailsService {

	@Autowired
	GetFlightOfferDetailsValidation getFlightOfferDetailsValidation;
	@Autowired
	FlightOfferRepository flightOfferRepository;
	@Autowired
	FlightOfferMapper flightOfferMapper;
	
	public GetFlightOfferDetailsResponse getResponse(Long id) {
		
		getFlightOfferDetailsValidation.validateRequest(id);
		
		Optional<FlightOffer> flightOffer = flightOfferRepository.findById(id);

		GetFlightOfferDetailsResponse getFlightOfferDetailsResponse = new GetFlightOfferDetailsResponse();
		
		if(flightOffer.isPresent()) {

			FlightOfferDetailsDTO details = flightOfferMapper.databaseToDetailsDTO(flightOffer.get());
			getFlightOfferDetailsResponse.setFlightOfferDetails(details);
			return getFlightOfferDetailsResponse;
			
		}else {
			throw new BudgetFlightException(BudgetFlightExceptionConstants.NOT_EXISTS);
		}
	}
		
}

