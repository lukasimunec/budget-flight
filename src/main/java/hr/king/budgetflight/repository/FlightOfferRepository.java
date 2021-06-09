package hr.king.budgetflight.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hr.king.budgetflight.model.FlightOffer;

@Repository
public interface FlightOfferRepository extends JpaRepository<FlightOffer, Long> {
	
	@Query(value = "select * from FLIGHT_OFFER where upper(DEPARTURE_AIRPORT) like upper(?1) "
			+ "AND upper(DESTINATION_AIRPORT) like upper(?2) "
			+ "AND CAST(DEPARTURE_DATE AS DATE) = CAST(?3 AS DATE) "
			+ "AND ( (?4 IS NULL AND RETURN_DATE IS NULL) OR CAST(RETURN_DATE AS DATE) = CAST(?4 AS DATE) )"
			+ "AND ?5 <= BOOKABLE_SEATS "
			+ "AND CURRENCY = ?6", 
			countQuery = "select COUNT(*) from FLIGHT_OFFER where upper(DEPARTURE_AIRPORT) like upper(?1) "
					+ "AND upper(DESTINATION_AIRPORT) like upper(?2) "
					+ "AND CAST(DEPARTURE_DATE AS DATE) = CAST(?3 AS DATE) "
					+ "AND ( (?4 IS NULL AND RETURN_DATE IS NULL) OR CAST(RETURN_DATE AS DATE) = CAST(?4 AS DATE) )"
					+ "AND ?5 <= BOOKABLE_SEATS "
					+ "AND CURRENCY = ?6", nativeQuery = true)
	Page<FlightOffer> getBySearch(String departureAirport, 
			String destinationAirport, 
			Date departureDate,
			Date returnDate,
			Integer passengers, 
			String currency,
			Pageable pageable);
	
	
}
