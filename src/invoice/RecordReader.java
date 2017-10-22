package invoice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RecordReader {

	private BufferedReader reader;

	public RecordReader() throws FileNotFoundException {
		this(new FileReader(
				"C:/KM_Person/pleiades-4.6.3-ultimate-win-64bit-jre_20170422/pg_ex23/src/invoice/record.log"));
	}

	public RecordReader(Reader reader) {
		this.reader = new BufferedReader(reader);
	}

	public Record read() throws IOException {
		String line = reader.readLine();
		if(line == null){
			return null;
		}
		return new Record(line);
	}

	public void close() throws IOException {
		reader.close();
	}

}
