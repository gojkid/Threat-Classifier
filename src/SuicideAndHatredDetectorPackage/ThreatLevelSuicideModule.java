package SuicideAndHatredDetectorPackage;

import java.io.IOException;

public class ThreatLevelSuicideModule {

    private int WeightageOfSuicide;
    private int scoreSuicideModule;
    private String submoudleSuicideCategory;
    private ArraysBagSuicideAndHatredModule ArraysBagSuicideAndHatredModule;

    public ThreatLevelSuicideModule(String paragraph) throws IOException {
        WeightageOfSuicide = 5;
        scoreSuicideModule = 0;
        submoudleSuicideCategory = "";
        ArraysBagSuicideAndHatredModule = new ArraysBagSuicideAndHatredModule();
        calculateThreatLevelInSuicideSubModule(paragraph);
    }

  private String msg="";

    public String getMsg() {
        return msg;
    }
    
    public void setWeightageOfSuicide(int WeightageOfSuicide) {
        this.WeightageOfSuicide = WeightageOfSuicide;
    }

    private void setScoreSuicideModule(int ThreeTwoOrOne) {
        this.scoreSuicideModule = ThreeTwoOrOne;
        determinCategoryTargetModule(ThreeTwoOrOne);
    }

    private void setSubmoudleSuicideCategory(String submoudleSuicideCategory) {
        this.submoudleSuicideCategory = submoudleSuicideCategory;
    }

    public int getWeightageOfSuicide() {
        return WeightageOfSuicide;
    }

    public int getScoreSuicideModule() {
        return scoreSuicideModule * this.getWeightageOfSuicide();
    }

    public String getSubmoudleSuicideCategory() {
        return submoudleSuicideCategory;
    }

    private void calculateThreatLevelInSuicideSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagSuicideAndHatredModule);
        SuicideAndHatred sah=new SuicideAndHatred(ArraysBagSuicideAndHatredModule);
        int ThreeTwoOrOne = sah.threatLevelSuicideAndHatredModule(lowerCasedText);
        msg=sah.getMsg();
        this.setScoreSuicideModule(ThreeTwoOrOne);        
    }//method calculateThreatLevelInSuicideSubModule ends here

    private void determinCategoryTargetModule(int ThreeTwoOrOne) {
        if (ThreeTwoOrOne == 3) {
            this.setSubmoudleSuicideCategory("High");
        } else if (ThreeTwoOrOne == 2) {
            this.setSubmoudleSuicideCategory("Medium");
        } else if (ThreeTwoOrOne == 1) {
            this.setSubmoudleSuicideCategory("Low");
        } else if (ThreeTwoOrOne == 0) {
            this.setSubmoudleSuicideCategory("No Intentions of suicide found!");
        }
    }// mehtod determinCategoryTargetModule ends here.
}//class ThreatLevelSuicideModule ends here.
