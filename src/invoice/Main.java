package invoice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private static final int INITIAL_BASIC_CHARGE = 1000;
	private static final int INITIAL_CALL_UNIT_PRICE = 20;
	private static final char RC_OWNER_INFO = '1';
	private static final char RC_SERVICE_INFO = '2';
	private static final char RC_CALL_LOG = '5';
	private static final char RC_SEPARATOR = '9';

	public static void main(String[] args) throws IOException {
		int basicCharge = 500;
		int unitPrice = INITIAL_CALL_UNIT_PRICE;
		int callCharge = 0;
		String invoicefile = "file/invoice.dat";

		RecordReader reader = new RecordReader();
		BufferedWriter writer = new BufferedWriter(new FileWriter(invoicefile));

		for (Record record = reader.read(); record != null; record = reader.read()) {
			char recordCode = record.getRecordCode();
			String ownerTelNumber = null;
			switch (recordCode) {
			case '1':
				ownerTelNumber = record.getOwnerTelNumber();
				break;
			case '2':
				String serviceCode = record.getServiceCode();
				if(serviceCode.equals("E1")){
					break;
				}
				String serviceOption = record.getServiceOption();
				break;
			case '5':
				int callTime = record.getCallMinutes();
				int callStartHour = record.getStartHour();
				break;
			case '9':
				writer.write("1 " + ownerTelNumber + "\n");
				writer.write("5 " + basicCharge + "\n");
				writer.write("7 " + callCharge + "\n");
				writer.write("9 ======================================\n");
				callCharge = 0;
				basicCharge = 0;
				serviceCode = null;
				break;
			}

		}
		reader.close();
		writer.close();

	}

	private static void service(int service, Record record) {

	}

	private static void call(int invoice, int service, Record record) {

	}

	private static void separate(int invoice, int service, int writer) {

	}

}
