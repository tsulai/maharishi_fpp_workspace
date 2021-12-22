package prog2_4_parse_soln;

public class Prog4 {
	public static void main(String[] args){
		String theRecords = Data.records;
		
		//separate into individual records
		String[] records = theRecords.split(":");
		
		//for each record, extract the productId and print
		String nextRecordStr = null;
		String[] nextRecordArray = null;
		for(int i = 0; i < records.length; ++i){
			nextRecordStr = records[i];
			nextRecordArray = nextRecordStr.split(",");
			System.out.println(nextRecordArray[0]);
		}
	}
	

}
