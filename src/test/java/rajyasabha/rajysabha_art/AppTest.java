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
//        assertEquals(32170, rs.size());
//	}
	
	@Test
	void testMainRegex() {
		String url = "/home/test08/Downloads/rajyaSabhaData.csv";
		readCsvRegex readcsv = new readCsvRegex();
        List<rsClass> rs = new ArrayList<rsClass>();
        rs = readcsv.readCsv(url);
        System.out.println("Regex::::::::::::::" + rs.size());
        assertEquals(32170, rs.size());
	}

}
