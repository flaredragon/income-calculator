package summary;

import java.util.Comparator;

public class RTSorter implements Comparator<ReportTransaction> {
	public int compare(ReportTransaction o1, ReportTransaction o2) {
        if(!o1.getPlace().equals(o2.getPlace()))
        	return o1.getPlace().compareTo(o2.getPlace());
        else if(!o1.getGender().toString().equals(o2.getGender().toString())) {
        	return o1.getGender().toString().compareTo(o2.getGender().toString());
        }
        else if(!o1.getAvgIncome().equals(o2.getAvgIncome())) {
        	return o1.getAvgIncome().compareTo(o2.getAvgIncome());
        }
        else {
        	return 0;
        }
    }
}
