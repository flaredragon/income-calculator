package transaction;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;

import summary.RTSorter;
import summary.ReportTransaction;

public class Processor {
	private static HashMap<String, ReportTransaction> incomePerPlace = new HashMap<String, ReportTransaction>();
	private static HashMap<String, Integer> occurences = new HashMap<String, Integer>();
	public static ArrayList<ReportTransaction> processTransactions(ArrayList<Transaction> transactions){
		ArrayList<ReportTransaction> summary = new ArrayList<ReportTransaction>();
		for(Transaction transaction:transactions) {
			String place;
			if(transaction.getCountry().length()<1) {
				place = transaction.getCity();
			}
			else {
				place = transaction.getCountry();
			}
			String key = place+transaction.getGender().toString();
			Double convertedNewIncome = incomeConverter(transaction.getIncome(),transaction.getCurrency());
			if(incomePerPlace.containsKey(key)) {
			    ReportTransaction oldTransaction = incomePerPlace.get(key);
			    Double totalTillNow = oldTransaction.getTotalIncome();
			    Integer n = occurences.get(key);
			    Double avgIncome = (totalTillNow + convertedNewIncome)/(n+1);
			    occurences.put(key, n+1);
			    oldTransaction.addToTotalIncome(convertedNewIncome);
			    oldTransaction.setAvgIncome(avgIncome);
			    incomePerPlace.put(key, oldTransaction);
			}
			else {
				ReportTransaction newPlaceTransaction = new ReportTransaction(place,transaction.getGender(),convertedNewIncome);
				occurences.put(key, 1);
				incomePerPlace.put(key, newPlaceTransaction);
			}
		}
		summary = incomePerPlace.values().stream()
                	.collect(Collectors.toCollection(ArrayList::new));
		summary.sort(new RTSorter());
		return summary;
	}
	
	public static Double incomeConverter(Integer income,currency incomeCurrency) {
		Double incomeInUSD = income.doubleValue();
		switch(incomeCurrency) {
			case INR:
				incomeInUSD /=66;
				break;
			case GBP:
				incomeInUSD /=0.67;
				break;
			case SGP:
				incomeInUSD /=1.5;
				break;
			case HKD:
				incomeInUSD /=8;
				break;
			default:
				break;
		}
		return incomeInUSD;
	}	
}