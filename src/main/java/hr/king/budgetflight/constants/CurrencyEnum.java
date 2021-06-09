package hr.king.budgetflight.constants;

public enum CurrencyEnum {

	HRK("HRK", 0), EUR("EUR", 1), USD("USD", 2);

	private final String key;
	private final Integer value;

	CurrencyEnum(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}
	
	public static CurrencyEnum find(Integer value) {
	    for (CurrencyEnum currency : CurrencyEnum.values()) {
	        if (currency.getValue().equals(value)) {
	            return currency;
	        }
	    }
	    return null;
	}
}
