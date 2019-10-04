package rajyasabha.rajysabha_art;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


/**
 * Hello world!
 *
 */
public class App 
{
	

    public static void main( String[] args )
    {
//    	String curDir = System.getProperty("user.dir");
//    	System.out.println(curDir);
    	String url = "/home/test08/Downloads/rajyaSabhaData.csv";
        
        readCsvRegex readcsvRegex = new readCsvRegex();
        
        List<rsClass> rs = new ArrayList<rsClass>();
        rs = readcsvRegex.readCsv(url);
//        rs = readcsv.readCsv(url);
//        for(rsClass name : rs)
//        {
//            System.out.println(name.ministry + "\t" + name.question_no);
//        }
//        System.out.println(rs);
        
        Map<String, Integer> hm = new HashMap<String, Integer>(); 
        for (rsClass i : rs.subList(1, rs.size())) { 
            Integer j = hm.get(i.ministry); 
            hm.put(i.ministry, (j == null) ? 1 : j + 1); 
        }
        
        for (Map.Entry<String, Integer> val : hm.entrySet()) { 
            System.out.println("Ministry " + val.getKey() + " "
                               + "asked "
                               + val.getValue() + " questions"); 
        } 
    }
}
