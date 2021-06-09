package hr.king.budgetflight;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import hr.king.budgetflight.dto.SearchForm;
import hr.king.budgetflight.dto.TableForm;
import hr.king.budgetflight.request.GetFlightOffersRequest;

@AutoConfigureMockMvc
public class BudgetFlightServiceTest extends BudgetFlightApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFlightOffers() throws Exception {

		/*SearchForm searchForm = new SearchForm();
		searchForm.setDepartureAirport("SYD");
		searchForm.setDestinationAirport("BKK");
		searchForm.setDepartureDate(new Date());
		searchForm.setNumberOfPassengers(1);
		searchForm.setCurrency(0);
		TableForm tableForm = new TableForm();
		tableForm.setPage(0);
		tableForm.setPageSize(10);
		GetFlightOffersRequest request = new GetFlightOffersRequest();
		request.setSearchForm(searchForm);
		request.setTableForm(tableForm);

		mockMvc.perform(post("/flight-offers").content(asJsonString(request)).header("contentType", "application/json")
				.header("accept", "application/json").header("Cache-Control", "no-cache")
				.header("access-Control-Allow-Origin", "*")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));*/
	}

	@Test
	public void testFlightOfferDetails() throws Exception {
		/*mockMvc.perform(get("/flight-offer-details")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"));*/

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
