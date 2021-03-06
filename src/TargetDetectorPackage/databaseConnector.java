/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TargetDetectorPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Souvik
 */
public class databaseConnector {
   
    private  File f1=new File("ArraysBagTargetModule.DAT");
    private  Properties db= new Properties();
    //load up the respective arrays from the database
    public void loadDatabaseUp(ArraysBagTargetModule database) throws IOException
    {
            
        database.setCardinalNumbersTarget(fetch("cardinalNumbersTarget"));
        
        database.setFightTarget(fetch("fightTarget"));
        
        database.setKillTarget(fetch("killTarget"));
        
        database.setKnowledgeFewTargets(fetch("knowledgeFewTargets"));
        
        database.setKnowledgeMoreTargets(fetch("knowledgeMoreTargets"));
        
        database.setPhrasesIncludingTarget(fetch("phrasesIncludingTarget"));
        
        database.setPopularNamesTarget(fetch("popularNamesTarget"));
        
        database.setRevengeTarget(fetch("RevengeTarget"));
        
        database.setSubjectsTarget(fetch("subjectsTarget"));
        
        database.setTargetIndicatingFewPersons(fetch("targetIndicatingFewPersons"));
        
       
    }
    
    //to update a particular array to the database for persistence
    //param - Name of the array
    //arr - the modified array
   public  void upload(String param,String arr[]) throws IOException
    {
        
                 if(!f1.exists())
                   f1.createNewFile();
                     String path=f1.getAbsolutePath();                 
                    FileOutputStream fos=new FileOutputStream(path,true);
                 String temp="",put="";
                 for(int i=0;i<arr.length;i++)
                {
                    temp=temp+arr[i]+"$";
                }
                put=(String) db.put(param, temp);
                db.store(fos, "ArraysBagTargetModule");
                fos.close();
    }
    
   //used to fetch a particular array's contents from the database by its name
    //key - Name of the array to be fetched
   public String[] fetch(String key) throws FileNotFoundException, IOException
    {
        if(!f1.exists())
        {
            System.err.println("ArraysBagTargetModule missing");
            System.exit(0);
        }
        String path=f1.getAbsolutePath();
        FileInputStream fis=new FileInputStream(path);
        db.load(fis);
        String query=db.getProperty(key);
        query=query.trim();
        if(query.endsWith("$"))
            query=query.substring(0, query.length()-1);
        query=query.replace('$', '%');
        String q[];
        q=query.split("%");
        fis.close();
        return q;
    }
    
}
