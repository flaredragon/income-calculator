package runner;

import java.util.ArrayList;

import csvhandler.CSVReader;
import csvhandler.CSVWriters;
import summary.ReportTransaction;
import transaction.Processor;
import transaction.Transaction;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transactions = CSVReader.readCSV("Sample_Input.csv");
		ArrayList<ReportTransaction> reports = Processor.processTransactions(transactions);
		CSVWriters.writeToFile(reports);
	}

}
