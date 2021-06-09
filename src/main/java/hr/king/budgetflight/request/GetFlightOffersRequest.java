package hr.king.budgetflight.request;

import hr.king.budgetflight.dto.SearchForm;
import hr.king.budgetflight.dto.TableForm;

public class GetFlightOffersRequest {
	
	private SearchForm searchForm;
	private TableForm tableForm;
	
	public SearchForm getSearchForm() {
		return searchForm;
	}
	public void setSearchForm(SearchForm searchForm) {
		this.searchForm = searchForm;
	}
	public TableForm getTableForm() {
		return tableForm;
	}
	public void setTableForm(TableForm tableForm) {
		this.tableForm = tableForm;
	}
	
}
