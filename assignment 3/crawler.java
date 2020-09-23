package webScraper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//JSoup files
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

//writing the CSV files
import com.opencsv.CSVWriter;


public class crawler_Java {
	
	//max_depth for depth first crawling of the web sites
	private static final int MAX_DEPTH = 10;
	
	private static int count= 1;
	// creating a set which contains a list of all the links that have been visited 
    static Set<String> pagesVisited = new HashSet<String>();
    
    //recursive function for crawling
    public static void nextCrawl(String url, int depth) 
    {
    	// used by JSoup for storing the contents of the Web page it has crawled
    	Document document;
		
		try {
			
			
			if(depth > MAX_DEPTH)
			{
				return;
			}
			
			document = Jsoup.connect(url).ignoreContentType(true) .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
		               .referrer("http://www.google.com").ignoreHttpErrors(true).get();

			// scraping the p tags and the anchor tags
			Elements para = document.getElementsByTag("p");
			Elements links = document.select("a[href]");
			
			// Using open CSV
			File file = new File("paragraph_text.csv"); 
			
		    //FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    FileWriter outputfile = new FileWriter(file, true); 
		  
		    //CSVWriter object file writer object as parameter 
		    CSVWriter writer = new CSVWriter(outputfile); 
		    
		    // adding data to CSV
		    String[] arr = {"URL Number:" + Integer.toString(count), "Number of <p> tags:" + Integer.toString(para.size())};
		    writer.writeNext(arr);
		    
		    for (int i=0; i < para.size(); i++) 
		    {
		    	String[] data = { "<p>", para.get(i).text()};
		    	writer.writeNext(data);
		    }
		    
		    String[] leave_line = {" ", " "};
		    writer.writeNext(leave_line);
		    // writer connection closing
		    writer.close(); 
		    
		    
		    
			File file2 = new File("links.csv"); 
		    
		    // create FileWriter object with file2 as parameter 
		    FileWriter outputfile2 = new FileWriter(file2, true); 
		  
		    // create CSVWriter object file writer2 object as parameter 
		    CSVWriter writer2 = new CSVWriter(outputfile2); 
		    
		    // adding data to CSV
		    String[] arr2 = {"URL Number:" + Integer.toString(count), "Number of <a> tags:" + Integer.toString(links.size())};
		    writer2.writeNext(arr2);
		    for (int i=0; i < links.size(); i++) 
		    {	
		    	String[] data = { links.get(i).text(),links.get(i).attr("abs:href")};
		    	writer2.writeNext(data);
		    }
		   
		    writer2.writeNext(leave_line);
		    // writer2 connection closing
		    writer2.close();
		    count++;
		    
		    
			//recursive call to to visit only those pages which are marked not visited
		    for(int i = 0; i < links.size(); i++)
		    {	
		    	if(pagesVisited.contains(links.get(i).attr("abs:href")) == false)
		    	{	
		    		pagesVisited.add(links.get(i).attr("abs:href"));
		    		
		    		if(links.get(i).attr("abs:href").length() > 18 && links.get(i).attr("abs:href").substring(0,18).equals("https://pec.ac.in/"))
		    		{
		    			nextCrawl(links.get(i).attr("abs:href"), depth + 1);
		    		}
		    		
			    	
		    	}
		    	
		    }
		    	
		}
		//various exceptions
		catch (NullPointerException e) 
		{
	        e.printStackTrace();
	    } 
		catch (HttpStatusException e) 
		{
	        e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("running...");
		
		Document document;
		
		// in main file we are scraping the home page
		try {
			
			document = Jsoup.connect("https://pec.ac.in/").ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
		               .referrer("http://www.google.com").ignoreHttpErrors(true).get();

			// scraping the p tags and the anchor tags
			Elements para = document.getElementsByTag("p");
			Elements links = document.select("a[href]");
			
			// Using open CSV
			File file = new File("paragraph_text.csv"); 
			
		    // create FileWriter object with file as parameter and true parameter so that this CSV file gets appended on repeated calls
		    FileWriter outputfile = new FileWriter(file, true); 
		  
		    // create CSVWriter object file writer object as parameter 
		    CSVWriter writer = new CSVWriter(outputfile); 
		     
		    // adding header to CSV 
		    String[] header = { "Paragraph Tag", "Text"}; 
		    writer.writeNext(header); 
		  
		    // adding data to CSV
		    String[] arr = {"URL Number:" + Integer.toString(count), "Number of <p> tags:" + Integer.toString(para.size())};
		    writer.writeNext(arr);
		    
		    for (int i=0; i < para.size(); i++) 
		    {
		    	String[] data = { "<p>", para.get(i).text()};
		    	writer.writeNext(data);
		    }
		    
		 
		    String[] leave_line = {" ", " "};
		    writer.writeNext(leave_line);
	  
		    // writer connection closing
		    writer.close(); 
		    
			File file2 = new File("links.csv"); 
		    
		    // create FileWriter object with file2 as parameter 
		    FileWriter outputfile2 = new FileWriter(file2, true); 
		  
		    // create CSVWriter object file writer2 object as parameter 
		    CSVWriter writer2 = new CSVWriter(outputfile2); 
		     
		    // adding header to CSV
		    String[] header2 = { "Text in Anchor", "Corresponding URL"}; 
		    writer2.writeNext(header2); 
		    
		    
		    
		    // adding data to CSV
		    String[] arr2 = {"URL Number:" + Integer.toString(count), "Number of <a> tags:" + Integer.toString(links.size())};
		    writer2.writeNext(arr2);
		    
		    for (int i=0; i < links.size(); i++) 
		    {	
		    	String[] data = { links.get(i).text(),links.get(i).attr("abs:href")};
		    	writer2.writeNext(data);
		    }
		    
		    writer2.writeNext(leave_line);
		    // writer2 connection closing
		    writer2.close();
		    
		    count++;
			
			//recusive call to visit only those pages that are not marked visited
		    for(int i = 1; i < links.size(); i++)
		    {	
		    	if(!pagesVisited.contains(links.get(i).attr("abs:href")))
		    	{	
		    		pagesVisited.add(links.get(i).attr("abs:href"));
		    		
		    		if(links.get(i).attr("abs:href").length() > 18 && links.get(i).attr("abs:href").substring(0,18).equals("https://pec.ac.in/"))
		    		{
		    			nextCrawl(links.get(i).attr("abs:href"), 0);
		    		}
		    			
		    	}
		    }		    	
		}
		//various exceptions
		catch (NullPointerException e) 
		{
	        e.printStackTrace();
	    } 
		catch (HttpStatusException e) 
		{
	        e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Done.");

	}

}
