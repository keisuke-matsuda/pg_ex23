package invoice;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest {

	@Test
	public void testCode1() {
		String record1 = "1 090-1234-0001";
		Record rc1 = new Record(record1);
		assertEquals(rc1.getRecordCode(), '1');
		assertEquals(rc1.getOwnerTelNumber(),"090-1234-0001");
	}

	@Test
	public void testCode2() {
		String record2 = "2 C1 090-1234-0002";
		Record rc2 = new Record(record2);
		assertEquals(rc2.getRecordCode(), '2');
		assertEquals(rc2.getServiceCode(), "C1");
		assertEquals(rc2.getServiceOption(), "090-1234-0002");
	}

	@Test
	public void testCode5() {
		String record5 = "5 2004/06/04 03:34 003 090-1234-0002";
		Record rc5 = new Record(record5);
		assertEquals(rc5.getRecordCode(), '5');
		assertEquals(rc5.getStartHour(), 3);
		assertEquals(rc5.getCallMinutes(), 3);
		assertEquals(rc5.getCallNumber(), "090-1234-0002");
	}

}
