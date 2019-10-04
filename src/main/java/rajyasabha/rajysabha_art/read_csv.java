package rajyasabha.rajysabha_art;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;  

import com.opencsv.CSVReader;


public class read_csv {

	public List<rsClass> readCsv(String url) {
		List<rsClass> rs = new ArrayList<rsClass>();
		long startTime = System.nanoTime();
		try {
			FileInputStream filereaderStream = new  FileInputStream(url);
			InputStreamReader isr = new InputStreamReader(filereaderStream, 
                    StandardCharsets.UTF_8);
			CSVReader csvReader = new CSVReader(isr);
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				rsClass rsobj = new rsClass();

				rsobj.id = nextRecord[0];
				// System.out.println(nextRecord[7]);
				rsobj.answer_date = nextRecord[1];
				rsobj.ministry = nextRecord[2];
				rsobj.question_type = nextRecord[3];
				rsobj.question_no = nextRecord[4];
				rsobj.question_by = nextRecord[5];
				rsobj.question_title = nextRecord[6];
				rsobj.question_description = nextRecord[7];
				rsobj.answer = nextRecord[8];

				rs.add(rsobj);
				// System.out.println(nextRecord[1]);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(rs);
		long endTime = System.nanoTime();
		System.out.println( "OpenCSV time ============>" + (endTime - startTime)/1000000);
		return rs;
	}
}
