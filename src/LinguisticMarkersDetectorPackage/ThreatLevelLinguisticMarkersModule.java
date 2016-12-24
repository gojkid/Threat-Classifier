
package LinguisticMarkersDetectorPackage;

import java.io.IOException;

public class ThreatLevelLinguisticMarkersModule {
        private int WeightageOfLinguisticMarkers;
        private int scoreLinguisticMarkersModule;
        private String submoudleLinguisticMarkersCategory;
        private ArraysBagLinguisiticMarkersModule ArraysBagLinguisiticMarkersModule;

private String msg="";

    public String getMsg() {
        return msg;
    }
    public ThreatLevelLinguisticMarkersModule(String paragraph) throws IOException {
        WeightageOfLinguisticMarkers = 5;
        scoreLinguisticMarkersModule = 0;
        submoudleLinguisticMarkersCategory = "";
        ArraysBagLinguisiticMarkersModule = new ArraysBagLinguisiticMarkersModule();
        calculateThreatLevelInLinguisticMarkersSubModule(paragraph);        
    }
    
    public String getSubmoudleLinguisticMarkersCategory() {
        return submoudleLinguisticMarkersCategory;
    }

    private void setSubmoudleLinguisticMarkersCategory(String submoudleLinguisticMarkersCategory) {
        this.submoudleLinguisticMarkersCategory = submoudleLinguisticMarkersCategory;
    }

    public int getScoreLinguisticMarkersModule() {
        return scoreLinguisticMarkersModule * this.getWeightageOfLinguisticMarkers();
    }

    public void setWeightageOfLinguisticMarkers(int WeightageOfLinguisticMarkers) {
        this.WeightageOfLinguisticMarkers = WeightageOfLinguisticMarkers;
    }

    private void setScoreLinguisticMarkersModule(int ThreeTwoOrOne) {
        this.scoreLinguisticMarkersModule = ThreeTwoOrOne;
        determineCategoryLinguisticMarkersModule(ThreeTwoOrOne);        
    }

    public int getWeightageOfLinguisticMarkers() {
        return WeightageOfLinguisticMarkers;
    }

    private void calculateThreatLevelInLinguisticMarkersSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagLinguisiticMarkersModule);
        LinguisticMarkers l=new LinguisticMarkers(ArraysBagLinguisiticMarkersModule);
        int ThreeTwoOrOne =l.threatLevel(lowerCasedText);
        msg=l.getMsg();
       this.setScoreLinguisticMarkersModule(ThreeTwoOrOne);         
    }                
    private void determineCategoryLinguisticMarkersModule(int ThreeTwoOrOne) {
        if (ThreeTwoOrOne == 3) {
            this.setSubmoudleLinguisticMarkersCategory("High");
        } else if (ThreeTwoOrOne == 2) {
           this.setSubmoudleLinguisticMarkersCategory("Medium");
        } else if (ThreeTwoOrOne == 1) {
            this.setSubmoudleLinguisticMarkersCategory("Low");
        } else if(ThreeTwoOrOne == 0){
            this.setSubmoudleLinguisticMarkersCategory("No linguistic markers found!");
        }
    }//method determineCategoryLinguisticMarkersModule ends here.
}//class ThreatLevelLinguisticMarkersModule ends here.
