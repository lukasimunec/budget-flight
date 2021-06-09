package hr.king.budgetflight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetFlightHtml5Controller {

	@GetMapping(value = { "/error", "/{regex:\\w+}", "/**/{regex:\\w+}" })
	public String forward404() {
		return "forward:/";
	}
	
}
