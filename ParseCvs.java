
/**
 * @author Elijah Pleas
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
;
public class ParseCvs {
	
	public static void main(String[] args) {
	int recordsReceived = 0, recordsSucceeded = 0, recordsFailed = 0;
	Scanner scanner ;
	try {
		scanner = new Scanner (new File ("CodingChal.csv"));
		 scanner.useDelimiter(",");
			while(scanner.hasNext()) {
		
				System.out.println(scanner.next()+" | ");
			}
			scanner.close();
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
        
        // bad data
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new java.util.Date()); 
        BufferedWriter bw = new BufferedWriter(new FileWriter("bad-data-" + date + ".csv"));
        
        BufferedReader br = new BufferedReader(new FileReader("./CodingChal.csv"));
        br.readLine(); //Header, Ignore

        String line = br.readLine();
        
        while (line != null){
            recordsReceived++;
            
            if (line.contains(",,")){   //Line has empty slot
                recordsFailed++;
                bw.append(line + "\n"); //Add to bad-data .csv

                line = br.readLine();
                continue;
            }
            
            String[] entries = new String[10];
            String[] initialEntries = line.split(",");  //Might contain incorrectly parsed entries
            
            int j = 0;
            for (int i = 0; i < entries.length; i++){
                if (initialEntries[j].charAt(0) == '\"'){   //If 2 neighboring entries together are bookended by quotes, they should be seen as 1 entry.
                    entries[i] = initialEntries[j] + initialEntries[j+1];
                    entries[i] = entries[i].substring(1, entries[i].length()-1);    //Trim off quotes
                    j++;
                } else {
                    entries[i] = initialEntries[j];
                }
                j++;
            }
            
            recordsSucceeded++;
	
	
        
	
	
	
	}
	
	
	
	
	
	
}

 