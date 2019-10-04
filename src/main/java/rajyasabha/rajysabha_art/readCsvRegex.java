package rajyasabha.rajysabha_art;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.opencsv.CSVReader;


public class readCsvRegex {
	final Logger LOGGER = Logger.getLogger(readCsvRegex.class);
	public List<rsClass> readCsv(String url) {
		Set<rsClass> rs = new HashSet<rsClass>();
		List<rsClass> rsList = new ArrayList<rsClass>();
		long startTime = System.nanoTime();
		try {
			
			FileReader filereader = new FileReader(url);
			
			LOGGER.info("File read successful! \n \n");
			
			BufferedReader br = new BufferedReader(filereader);
			String[] nextRecord;
			String line;
			while ((line = br.readLine()) != null) {
				nextRecord = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				rsClass rsobj = new rsClass();

				rsobj.id = nextRecord[0].replaceAll("^\"|\"$", "");
				// System.out.println(nextRecord[7]);
				rsobj.answer_date = nextRecord[1].replaceAll("^\"|\"$", "");
				rsobj.ministry = nextRecord[2].replaceAll("^\"|\"$", "");
				rsobj.question_type = nextRecord[3].replaceAll("^\"|\"$", "");
				rsobj.question_no = nextRecord[4].replaceAll("^\"|\"$", "");
				rsobj.question_by = nextRecord[5].replaceAll("^\"|\"$", "");
				rsobj.question_title = nextRecord[6].replaceAll("^\"|\"$", "");
				rsobj.question_description = nextRecord[7].replaceAll("^\"|\"$", "");
				rsobj.answer = nextRecord[8].replaceAll("^\"|\"$", "");

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
		LOGGER.info("Regex time ============>" + (endTime - startTime)/1000000 + "\n \n");
		rsList.addAll(rs);
		return rsList;
	}

}
