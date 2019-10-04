package rajyasabha.rajysabha_art;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map; 
import java.util.Map.Entry; 
import java.util.Comparator;


/**
 * Hello world!
 *
 */
public class App 
{
	

    public static void main( String[] args )
    {
    	final Logger LOGGER = Logger.getLogger(App.class);
//    	String curDir = System.getProperty("user.dir");
//    	System.out.println(curDir);
    	String url = "/home/test08/Downloads/rajyaSabhaData.csv";
        
        readCsvRegex readcsvRegex = new readCsvRegex();
        read_csv readcsv = new read_csv();
      
        List<rsClass> rs = new ArrayList<rsClass>();
        rs = readcsvRegex.readCsv(url);
//        rs = readcsv.readCsv(url);
//        for(rsClass name : rs)
//        {
//            System.out.println(name.id + "\t" + name.ministry);
//        }
//        System.out.println(rs);
//        
        Map<String, Integer> hm = new HashMap<String, Integer>(); 
        for (rsClass i : rs.subList(1, rs.size())) { 
            Integer j = hm.get(i.ministry); 
            hm.put(i.ministry, (j == null) ? 1 : j + 1); 
        }
        
        Map<String, Integer> sortedMapAsc = sortByComparator(hm, true);

        
        for (Map.Entry<String, Integer> val : sortedMapAsc.entrySet()) { 
            System.out.println("Ministry " + val.getKey() + " "
                               + "asked "
                               + val.getValue() + " questions"); 
        } 
        
        
    }
    
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });
     // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
