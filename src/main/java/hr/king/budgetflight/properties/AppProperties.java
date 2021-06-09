package hr.king.budgetflight.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppProperties {
	
	@Value( "${amadeus.client.id}" )
	private String amadeusClientId;
	@Value( "${amadeus.client.secret}" )
	private String amadeusClientSecret;
	
	public String getAmadeusClientId() {
		return amadeusClientId;
	}
	public void setAmadeusClientId(String amadeusClientId) {
		this.amadeusClientId = amadeusClientId;
	}
	public String getAmadeusClientSecret() {
		return amadeusClientSecret;
	}
	public void setAmadeusClientSecret(String amadeusClientSecret) {
		this.amadeusClientSecret = amadeusClientSecret;
	}
	
}
