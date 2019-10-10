package rajyasabha.rajysabha_art;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AppTest {

//	@Test
//	void testMainOpenCsv() {
//		String url = "/home/test08/Downloads/rajyaSabhaData.csv";
//		read_csv readcsv = new read_csv();
//        List<rsClass> rs = new ArrayList<rsClass>();
//        rs = readcsv.readCsv(url);
//        System.out.println("opencsv:::::::::::::" + rs.size());
//        assertEquals(27824, rs.size());
//	}
	
	@Test
	void testReadCsvRegex() {
		String url = "/home/test08/Downloads/rajyaSabhaData.csv";
		readCsvRegex readcsv = new readCsvRegex();
        List<rsClass> rs = new ArrayList<rsClass>();
        rs = readcsv.readCsv(url);
        System.out.println("Regex::::::::::::::" + rs.size());
        assertEquals(32170, rs.size());
	}
	
	@Test
	void testRegex() {
		String s = "animal, dog, \"cat, lion\"";
		String[] sArray;
		sArray = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);		
		for (int i = 0; i < sArray.length; i++) {
			sArray[i] = sArray[i].trim();
			sArray[i] = sArray[i].replaceAll("\\s+", " ");
		}
		System.out.println(sArray[0] + "," + sArray[1] + "," + sArray[2]);
		String [] expected = {"animal", "dog", "\"cat, lion\""};
        assertArrayEquals(expected, sArray);
	}

}
