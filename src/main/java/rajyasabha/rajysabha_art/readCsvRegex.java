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
				nextRecord[0] = nextRecord[0].replaceAll("^\"|\"$", "");
				nextRecord[0] = nextRecord[0].trim();
				nextRecord[0] = nextRecord[0].replaceAll("\\s+", " ");
				rsobj.id = nextRecord[0];
				
				nextRecord[1] = nextRecord[1].replaceAll("^\"|\"$", "");
				nextRecord[1] = nextRecord[1].trim();
				nextRecord[1] = nextRecord[1].replaceAll("\\s+", " ");
				rsobj.answer_date = nextRecord[1];
				
				nextRecord[2] = nextRecord[2].replaceAll("^\"|\"$", "");
				nextRecord[2] = nextRecord[2].trim();
				nextRecord[2] = nextRecord[2].replaceAll("\\s+", " ");
				rsobj.ministry = nextRecord[2];
				
				nextRecord[3] = nextRecord[3].replaceAll("^\"|\"$", "");
				nextRecord[3] = nextRecord[3].trim();
				nextRecord[3] = nextRecord[3].replaceAll("\\s+", " ");
				rsobj.question_type = nextRecord[3];
				
				nextRecord[4] = nextRecord[4].replaceAll("^\"|\"$", "");
				nextRecord[4] = nextRecord[4].trim();
				nextRecord[4] = nextRecord[4].replaceAll("\\s+", " ");
				rsobj.question_no = nextRecord[4];
				
				nextRecord[5] = nextRecord[5].replaceAll("^\"|\"$", "");
				nextRecord[5] = nextRecord[5].trim();
				nextRecord[5] = nextRecord[5].replaceAll("\\s+", " ");
				rsobj.question_by = nextRecord[5];
				
				nextRecord[6] = nextRecord[6].replaceAll("^\"|\"$", "");
				nextRecord[6] = nextRecord[6].trim();
				nextRecord[6] = nextRecord[6].replaceAll("\\s+", " ");
				rsobj.question_title = nextRecord[6];
				
				nextRecord[7] = nextRecord[7].replaceAll("^\"|\"$", "");
				nextRecord[7] = nextRecord[7].trim();
				nextRecord[7] = nextRecord[7].replaceAll("\\s+", " ");
				rsobj.question_description = nextRecord[7];
				
				nextRecord[8] = nextRecord[8].replaceAll("^\"|\"$", "");
				nextRecord[8] = nextRecord[8].trim();
				nextRecord[8] = nextRecord[8].replaceAll("\\s+", " ");
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
		LOGGER.info("Regex time ============>" + (endTime - startTime)/1000000 + "\n \n");
		rsList.addAll(rs);
		return rsList;
	}

}
