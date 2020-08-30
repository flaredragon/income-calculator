package transaction;

public class Transaction {
	private String city;
	private String country;
	private gend gender;
	private currency incomeCurrency;
	private Integer income;
	
	public Transaction(String city,String country,String gender,String incomeCurrency,String income) {
		this.city = city;
		this.country = country;
		this.gender = Enum.valueOf(gend.class, gender);
		this.incomeCurrency = Enum.valueOf(currency.class, incomeCurrency);
		this.income = Integer.parseInt(income);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public gend getGender() {
		return this.gender;
	}
	
	public currency getCurrency() {
		return this.incomeCurrency;
	}
	
	public Integer getIncome() {
		return this.income;
	}
	
	
	
	
}
