package csvhandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import transaction.Transaction;

public class CSVReader {
	private static ArrayList<Transaction> transactions  = new ArrayList<Transaction>();
	
	static public ArrayList<Transaction> readCSV(String file) {
		String line = "";  
		String splitBy = ",";  
		try {  
			BufferedReader br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			while ((line = br.readLine()) != null) {  
				String[] trLine = line.split(splitBy);
				Transaction newTransaction = new Transaction(trLine[0],trLine[1],trLine[2],trLine[3],trLine[4]);
				transactions.add(newTransaction);
			}
			br.close();
		}   
		catch (IOException e) {  
			e.printStackTrace();  
		}
		return transactions;
	}  
}
