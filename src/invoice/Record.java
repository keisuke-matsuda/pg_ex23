package invoice;

public class Record {

	private static final int RI_OF_OWNER_TEL_NUMBER = 2;
	private static final int RI_OF_SERVICE_CODE = 2;
	private static final int RI_SZ_SERVICE_CODE = 2;
	private static final int RI_OF_SERVICE_OPTION = 5;
	private static final int RI_OF_CALL_START_TIME = 13;
	private static final int RI_SZ_HOUR = 2;
	private static final int RI_OF_CALL_MINUTE = 19;
	private static final int RI_SZ_CALL_MINUTE = 3;
	private static final int RI_OF_CALL_NUMBER = 23;
	private String record;

	public Record(String record) {
		this.record = record;
	}

	public String toString() {
		return record;
	}

	public char getRecordCode() {
		return record.charAt(0);
	}

	public String getOwnerTelNumber() {
		return record.substring(2, 15);
	}

	public String getServiceCode() {
		return record.substring(2, 4);
	}

	public String getServiceOption() {
		return record.substring(5, 18);
	}

	public int getStartHour() {
		return Integer.parseInt(record.substring(13, 15));
	}

	public int getCallMinutes() {
		return Integer.parseInt(record.substring(19, 22));
	}

	public String getCallNumber() {
		return record.substring(23, 36);

	}
}
