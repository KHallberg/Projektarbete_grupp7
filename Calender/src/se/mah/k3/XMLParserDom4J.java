package se.mah.k3;

import java.io.*;
import java.net.URL;
import java.util.*;
import org.dom4j.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;



public class XMLParserDom4J {
	
	public static List<Node> nodes ;
	
	public static void main(String[] args) {
	

      try {
         File inputFile = new File("rss/rss.xml");
         SAXReader reader = new SAXReader();
         Document document = reader.read( inputFile );

         System.out.println("Root element :" 
            + document.getRootElement().getName());

         Element classElement = document.getRootElement();

         nodes = document.selectNodes("//item" );
         System.out.println("----------------------------");
         for (Node node : nodes) {
        	 Item item = new Item();
            System.out.println("\nCurrent Element :" 
               + node.getName());

            System.out.println("Title : " + node.selectSingleNode("title").getText());
           
            
            String title = node.selectSingleNode("title").getText();
			item.setTitle(title);
            //System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
            //System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
            //System.out.println("Marks : " + node.selectSingleNode("marks").getText());
         }
      } catch (DocumentException e) {
         e.printStackTrace();
    
     }

   }
	
	
}