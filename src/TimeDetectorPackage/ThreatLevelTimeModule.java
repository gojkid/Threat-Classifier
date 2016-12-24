package TimeDetectorPackage;

import java.io.IOException;

public class ThreatLevelTimeModule {
 private int WeightageOfTime;
    private int scoreTimeModule; //Possible values are: High = 3; Medium = 2; Low = 1; NoThreat = 0; This value will be given according to the seriousness returned by the respective submodule.
    private String submoudleTimeCategory;    
    private ArraysBagTimeModule ArraysBagTimeModule;

    public ThreatLevelTimeModule(String paragraph) throws IOException {
          WeightageOfTime = 10;
      scoreTimeModule = 0;
      submoudleTimeCategory = ""; 
      ArraysBagTimeModule = new ArraysBagTimeModule();
        calculateThreatLevelInTimeSubModule(paragraph);
    }
    
    private String msg="";

    public String getMsg() {
        return msg;
    }

    public void setWeightageOfTime(int WeightageOfTime) {
        this.WeightageOfTime = WeightageOfTime;
    }

    private void setScoreTimeModule(int ThreeOrTwoOrOne) {
        this.scoreTimeModule = ThreeOrTwoOrOne;
        determinCategoryTimeModule(ThreeOrTwoOrOne);
    }

    private void setSubmoudleTimeCategory(String submoudleTimeCategory) {
        this.submoudleTimeCategory = submoudleTimeCategory;
    }

    public int getWeightageOfTime() {
        return WeightageOfTime;
    }

    public int getScoreTimeModule() {
        return scoreTimeModule * this.getWeightageOfTime();
    }

    public String getSubmoudleTimeCategory() {
        return submoudleTimeCategory;
    }

    private void calculateThreatLevelInTimeSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagTimeModule);
        TimeOfShooting tos=new TimeOfShooting(ArraysBagTimeModule);
        int ThreeOrTwoOrOne = tos.threatLevelTimeModule(lowerCasedText);
        msg=tos.getMsg();
        this.setScoreTimeModule(ThreeOrTwoOrOne);              
    }

    private void determinCategoryTimeModule(int ThreeOrTwoOrOne) {
        if (ThreeOrTwoOrOne == 3) {
            this.setSubmoudleTimeCategory("High");
        } else if (ThreeOrTwoOrOne == 2) {
           this.setSubmoudleTimeCategory("Medium");
        } else if (ThreeOrTwoOrOne == 1) {
            this.setSubmoudleTimeCategory("Low");
        } else if (ThreeOrTwoOrOne == 0) {
             this.setSubmoudleTimeCategory("No Time Found!");
        }
    }//method determinCategoryTimeModule ends here.   
}//class ThreatLevelTimeModule ends here.
