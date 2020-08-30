package summary;


import transaction.gend;

public class ReportTransaction {
	private String place;
	private gend gender;
	private Double avgIncome;
	private Double totalIncome;
	
	public ReportTransaction(String place,gend gender,Double convertedNewIncome) {
		this.place = place;
		this.gender = gender;
		this.avgIncome = convertedNewIncome;
		this.totalIncome = convertedNewIncome;
	}
	
	public String getPlace() {
		return this.place;
	}
	
	
	public gend getGender() {
		return this.gender;
	}
	
	public Double getAvgIncome() {
		return this.avgIncome;
	}
	
	public Double getTotalIncome() {
		return this.totalIncome;
	}
	
	public void setAvgIncome(Double income) {
		this.avgIncome = income;
	}
	
	public void addToTotalIncome(Double income) {
		this.totalIncome += income;
	}
	
}
