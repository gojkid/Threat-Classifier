//This is the main driver class of the application.
package PresentingTheResult;

import LinguisticMarkersDetectorPackage.ThreatLevelLinguisticMarkersModule;
import MotiveDetectorPackage.ThreatLevelMotiveModule;
import PlaceDetectorPackage.ThreatLevelPlaceModule;
import RehearsalDetectorPackage.ThreatLevelRehearsalModule;
import SuicideAndHatredDetectorPackage.ThreatLevelSuicideModule;
import TargetDetectorPackage.ThreatLevelTargetModule;
import TimeDetectorPackage.ThreatLevelTimeModule;
import WeaponsDetectorPackage.ThreatLevelWeaponsModule;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchoolShootingThreatClassifier {

File f=new File("resultGoogleSheet2.txt");
    
    private String getUrlContents(int cellNoInExcellSheet,String staticURL) {

        
        StringBuilder content = new StringBuilder();
        // String staticURL = "https://docs.google.com/spreadsheet/pub?key=0At9JhjvuyFxidGMzX0k4UWhjcjQ3Y1NwOHNUbEU0T0E&single=true&gid=0&range=B2&output=txt";
        String lastElevenCharacters = staticURL.substring(115);//This will give  &output=txt
        String first114Characters = staticURL.substring(0, 114);//This will give all the URL up to B but not including the number after B
        String updatedURL = first114Characters + Integer.toString(cellNoInExcellSheet) + lastElevenCharacters;

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try {

            URL url = new URL(updatedURL.toString());

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line;

                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append(" ");
                }
            }
        } catch (Exception e) {
        }
        return content.toString();

    }//method getUrlContents ends here.  

  

    public void goToExcelSheet(String choiceStr,String usermail,String url) throws IOException {
        //Getting input from the Google Excel Sheet. Making the connection with web and manipulating the URL
        
        if(!f.exists())
            f.createNewFile();
        int choiceInt = Integer.parseInt(choiceStr);
        int finalCellOfExcelSheet = choiceInt + 2;//Adding 2 becuase we start from cell B2 and one for the for loop has the condtion <
        int startingCellOfExcelSheet = 2;
        String output = "";
        String resultOfCurrentThreat = "";
        BufferedWriter writer = null;
        try {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\resultGoogleSheet2.txt"), "utf-8"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SchoolShootingThreatClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SchoolShootingThreatClassifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = startingCellOfExcelSheet; i < finalCellOfExcelSheet; i++) {
            output = "Threat Number: " + (i - 1); //Becasue we start from cell B2
            try {
                writer.write(output);
                writer.newLine();               
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(SchoolShootingThreatClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
            output = getUrlContents(i,url);
            try {
                writer.write(output);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                Logger.getLogger(SchoolShootingThreatClassifier.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultOfCurrentThreat = getResults(output);
            
            try {

                writer.write("Category Assigned: ");                
                writer.write(resultOfCurrentThreat);
                writer.newLine();writer.newLine();
                writer.flush();

            } catch (IOException e) {
            }
        }
        try {
            writer.close();
        } catch (Exception ex) {
            
        }
        sendResultToEmail(usermail);
       
    }//method goToExcelSheet ends here.
    
    public void goToURL(String usermail,String url) throws  MalformedURLException, IOException {
        //Making the connection with web and manipulating the URL
        String paragraph=tools.getContents(url);
        if(!f.exists())
            f.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"));
        String res=getResults(paragraph)+getDetailedResults(paragraph);
        writer.write(res);
        writer.flush();
        writer.close();
        sendResultToEmail(usermail);
    }//method goToURL ends here.

    public String getDetailedResults(String paragraph) throws IOException {
        String res="";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
//creating the objects of all the modules and pass them the threat to process.        
        ThreatLevelLinguisticMarkersModule objectLinguisticMarkersModule = new ThreatLevelLinguisticMarkersModule(paragraph);
        ThreatLevelMotiveModule objectMotiveModule = new ThreatLevelMotiveModule(paragraph);
        ThreatLevelRehearsalModule objectRehearsalModule = new ThreatLevelRehearsalModule(paragraph);
        ThreatLevelPlaceModule objectPlaceModule = new ThreatLevelPlaceModule(paragraph);
        ThreatLevelSuicideModule objectSuicideModule = new ThreatLevelSuicideModule(paragraph);
        ThreatLevelTargetModule objectTargetModule = new ThreatLevelTargetModule(paragraph);
        ThreatLevelTimeModule objectTimeModule = new ThreatLevelTimeModule(paragraph);
        ThreatLevelWeaponsModule objectWeaponsModule = new ThreatLevelWeaponsModule(paragraph);
        
        res=calculateAndDisplaySubcategories(objectWeaponsModule, objectTimeModule, objectTargetModule, objectSuicideModule, objectPlaceModule, objectRehearsalModule, objectMotiveModule, objectLinguisticMarkersModule);
        
        //Added later by Gojkid
        res=res+moreInfo(objectWeaponsModule, objectTimeModule, objectTargetModule, objectSuicideModule, objectPlaceModule, objectRehearsalModule, objectMotiveModule, objectLinguisticMarkersModule);
        return res;
    
    }//method getDetailedResults ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String getResults(String paragraph) throws IOException {
         ///////////////////////////////////////////////////////////////////////////////////////////////////////
//creating the objects of all the modules and pass them the threat to process.        
        ThreatLevelLinguisticMarkersModule objectLinguisticMarkersModule = new ThreatLevelLinguisticMarkersModule(paragraph);
        ThreatLevelMotiveModule objectMotiveModule = new ThreatLevelMotiveModule(paragraph);
        ThreatLevelRehearsalModule objectRehearsalModule = new ThreatLevelRehearsalModule(paragraph);
        ThreatLevelPlaceModule objectPlaceModule = new ThreatLevelPlaceModule(paragraph);
        ThreatLevelSuicideModule objectSuicideModule = new ThreatLevelSuicideModule(paragraph);
        ThreatLevelTargetModule objectTargetModule = new ThreatLevelTargetModule(paragraph);
        ThreatLevelTimeModule objectTimeModule = new ThreatLevelTimeModule(paragraph);
        ThreatLevelWeaponsModule objectWeaponsModule = new ThreatLevelWeaponsModule(paragraph);

//Calculating the total score, PTW(addition of Place, Time and Weapon) score 
        int totalScore = objectLinguisticMarkersModule.getScoreLinguisticMarkersModule() + objectMotiveModule.getScoreMotiveModule()
                + objectRehearsalModule.getScoreRehearsalModule() + objectPlaceModule.getScorePlaceModule()
                + objectSuicideModule.getScoreSuicideModule() + objectTargetModule.getScoreTargetModule()
                + objectTimeModule.getScoreTimeModule() + objectWeaponsModule.getScoreWeaponsModule();
        int placeTimeWeaponScore = objectPlaceModule.getScorePlaceModule() + objectTimeModule.getScoreTimeModule() + objectWeaponsModule.getScoreWeaponsModule();
        String OverallCategory = callFinalCategoryCalculator(placeTimeWeaponScore, totalScore);

        return OverallCategory;
    
    }//method getResults ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private String callFinalCategoryCalculator(int ptw, int total) {
        if (ptw >= 65) //we don’t care about the totalScore here and only scorePTWR will determine the high category.        
        {
            return "HIGH";
        } else {
            if (total > 80) {
                return "MEDIUM";
            } else if (total <= 80 && total > 35) {
                return "LOW";
            } else if (total <= 35) {
                return "NOT A THREAT";
            }
        }
        return "Can't decide the class of the threat. Please consult a human expert in threat assessment.";
    }//method callFinalCategoryCalculator ends here.

    private String calculateAndDisplaySubcategories(ThreatLevelWeaponsModule objectWeaponsModule, ThreatLevelTimeModule objectTimeModule, ThreatLevelTargetModule objectTargetModule, ThreatLevelSuicideModule objectSuicideModule, ThreatLevelPlaceModule objectPlaceModule, ThreatLevelRehearsalModule objectRehearsalModule, ThreatLevelMotiveModule objectMotiveModule, ThreatLevelLinguisticMarkersModule objectLinguisticMarkersModule) {
        String res="";
        
        res=res+"Weapons Module classified as: " + objectWeaponsModule.getSubmoudleWeponsCategory()+"\n";
        res=res+"Time Module classified as: " + objectTimeModule.getSubmoudleTimeCategory()+"\n";
        res=res+"Target Module classified as: " + objectTargetModule.getSubmoudleTargetCategory()+"\n";
        res=res+"Suicide Module classified as: " + objectSuicideModule.getSubmoudleSuicideCategory()+"\n";
        res=res+"Place Module classified as: " + objectPlaceModule.getSubmoudlePlaceCategory()+"\n";
        res=res+"Rehearsal Module classified as: " + objectRehearsalModule.getSubmoudleRehearsalCategory()+"\n";
        res=res+"Motive Module classified as: " + objectMotiveModule.getSubmoudleMotiveCategory()+"\n";
        res=res+"Linguistic Markers Module classified as: " + objectLinguisticMarkersModule.getSubmoudleLinguisticMarkersCategory()+"\n\n\n";
        
       
        return res;
    
    
    }
    
     //Added by Gojkid, change it if not needed
    //This method collects all the output that were otherwise being printed ThreatLevel[name]Module   ; name differs in each module
    private String moreInfo(ThreatLevelWeaponsModule objectWeaponsModule, ThreatLevelTimeModule objectTimeModule, ThreatLevelTargetModule objectTargetModule, ThreatLevelSuicideModule objectSuicideModule, ThreatLevelPlaceModule objectPlaceModule, ThreatLevelRehearsalModule objectRehearsalModule, ThreatLevelMotiveModule objectMotiveModule, ThreatLevelLinguisticMarkersModule objectLinguisticMarkersModule) {
        String res="";
       
        res=res+"Some Probable possibilities about the perpetrator\n\n";
        if(objectWeaponsModule.getMsg().length()>0)
        res=res+objectWeaponsModule.getMsg()+"\n";
        if(objectTimeModule.getMsg().length()>0)
        res=res+objectTimeModule.getMsg()+"\n";
        if(objectTargetModule.getMsg().length()>0)
        res=res+objectTargetModule.getMsg()+"\n";
        if(objectSuicideModule.getMsg().length()>0)
        res=res+objectSuicideModule.getMsg()+"\n";
        if(objectPlaceModule.getMsg().length()>0)
        res=res+objectPlaceModule.getMsg()+"\n";
        if(objectRehearsalModule.getMsg().length()>0)
        res=res+objectRehearsalModule.getMsg()+"\n";
        if(objectMotiveModule.getMsg().length()>0)
        res=res+objectMotiveModule.getMsg()+"\n";
        if(objectLinguisticMarkersModule.getMsg().length()>0)
        res=res+objectLinguisticMarkersModule.getMsg()+"\n";
        return res;
    }

    public void sendResultToEmail(String userEmail) {
         MailSend2 objectSendResult = new MailSend2(userEmail);
                  
    }
}//class SchoolShootingThreatClassifier ends here.
