//Checks the text of the threat by looking for proof of rehearsal or practice done or previous cases of shootings.
package RehearsalDetectorPackage;

import java.io.IOException;

public class ThreatLevelRehearsalModule {

    private int WeightageOfRehearsal;
    private int scoreRehearsalModule;
    private String submoudleRehearsalCategory;
    private ArraysBagRehearsalModule ArraysBagRehearsalModule; 


    public ThreatLevelRehearsalModule(String paragraph) throws IOException {
        WeightageOfRehearsal = 10;
        scoreRehearsalModule = 0;
        submoudleRehearsalCategory = "";
        ArraysBagRehearsalModule = new ArraysBagRehearsalModule();
        calculateThreatLevelInRehearsalSubModule(paragraph);
    }
 private String msg="";

    public String getMsg() {
        return msg;
    }

    public void setWeightageOfRehearsal(int WeightageOfRehearsal) {
        this.WeightageOfRehearsal = WeightageOfRehearsal;
    }

    private void setSubmoudleRehearsalCategory(String submoudleRehearsalCategory) {
        this.submoudleRehearsalCategory = submoudleRehearsalCategory;
    }

    private void setScoreRehearsalModule(int ThreeTwoOrOne) {
        this.scoreRehearsalModule = ThreeTwoOrOne;
        determineCategoryRehearsalModule(ThreeTwoOrOne);
    }

    public int getWeightageOfRehearsal() {
        return WeightageOfRehearsal;
    }

    public int getScoreRehearsalModule() {
        return scoreRehearsalModule * this.getWeightageOfRehearsal();
    }

    public String getSubmoudleRehearsalCategory() {
        return submoudleRehearsalCategory;
    }

    private void calculateThreatLevelInRehearsalSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagRehearsalModule);
        RehearsalOrPractice ror=new RehearsalOrPractice(ArraysBagRehearsalModule);
        int ThreeTwoOrOne = ror.threatLevelRehearsalOrPreacticeModule(lowerCasedText);
        msg=ror.getMsg();
        this.setScoreRehearsalModule(ThreeTwoOrOne);
    }

    private void determineCategoryRehearsalModule(int ThreeTwoOrOne) {
        if (ThreeTwoOrOne == 3) {
            this.setSubmoudleRehearsalCategory("High");
        } else if (ThreeTwoOrOne == 2) {
            this.setSubmoudleRehearsalCategory("Medium");
        } else if (ThreeTwoOrOne == 1) {
            this.setSubmoudleRehearsalCategory("Low");
        } else if (ThreeTwoOrOne == 0) {
            this.setSubmoudleRehearsalCategory("No proof or rehearsal or practice of weapons found!");
        }
    }//method determineCategoryRehearsalModule ends here.    
}//class ThreatLevelRehearsalModule ends here.
