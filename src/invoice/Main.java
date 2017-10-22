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
		String invoicefile = "C:/KM_Person/pleiades-4.6.3-ultimate-win-64bit-jre_20170422/pg_ex23/src/invoice/invoice.dat";

		RecordReader reader = new RecordReader();
		BufferedWriter writer = new BufferedWriter(new FileWriter(invoicefile));

		Record record;
		for (record = reader.read(); record != null; record = reader.read()) {
			char recordcode = record.getRecordCode();
			String ownerTelNumber = null;

			switch (recordcode) {
			case 1:
				ownerTelNumber = record.getOwnerTelNumber();
			case 2:
				String serviceCode = record.getServiceCode();
				String serviceOption = record.getServiceOption();
			case 5:
				int callTime = record.getCallMinutes();
			case 9:
				writer.write("1" + ownerTelNumber + "\n");
				writer.write("5" + basicCharge + "\n");
				writer.write("7" + callCharge + "\n");
				writer.write("9======================================\n");
				callCharge = 0;
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
