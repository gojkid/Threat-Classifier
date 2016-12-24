package MotiveDetectorPackage;

import java.io.IOException;

public class ThreatLevelMotiveModule {

    private String submoudleMotiveCategory;
    private int scoreMotiveModule;
    private int weightageMotiveModle;
    private ArraysBagMotiveModule ArraysBagMotiveModule;

    public ThreatLevelMotiveModule(String paragraph) throws IOException {
        submoudleMotiveCategory = "";
        scoreMotiveModule = 0;
        weightageMotiveModle = 5;
        ArraysBagMotiveModule=new ArraysBagMotiveModule();
        calculateThreatLevelInMotiveSubModule(paragraph);
    }
 private String msg="";

    public String getMsg() {
        return msg;
    }
    public int getWeightageMotiveModule() {
        return weightageMotiveModle;
    }

    public void setweightageMotiveModle(int weightageMotivePassed) {
        this.weightageMotiveModle = weightageMotivePassed;
    }

    private void setScoreMotiveModule(int ThreeTwoOrOne) {
        this.scoreMotiveModule = ThreeTwoOrOne;
        determinCategoryMotiveModule(ThreeTwoOrOne);
    }

    private void setSubmoudleMotiveCategory(String submoudleMotiveCategory) {
        this.submoudleMotiveCategory = submoudleMotiveCategory;
    }

    public int getScoreMotiveModule() {
        return scoreMotiveModule * this.getWeightageMotiveModule();
    }

    public String getSubmoudleMotiveCategory() {
        return submoudleMotiveCategory;
    }

    private void calculateThreatLevelInMotiveSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagMotiveModule);
        Motive m=new Motive(ArraysBagMotiveModule);
        int ThreeTwoOrOne = m.threatLevelMotiveModule(lowerCasedText);
        msg=m.getMsg();
        this.setScoreMotiveModule(ThreeTwoOrOne);
    }

    private void determinCategoryMotiveModule(int ThreeTwoOrOne) {
        if (ThreeTwoOrOne == 3) {
            this.setSubmoudleMotiveCategory("High");
        } else if (ThreeTwoOrOne == 2) {
            this.setSubmoudleMotiveCategory("Medium");
        } else if (ThreeTwoOrOne == 1) {
            this.setSubmoudleMotiveCategory("Low");
        } else if (ThreeTwoOrOne == 0) {
            this.setSubmoudleMotiveCategory("No Motive for school shooting found!");
        }
    }//method determinCategoryMotiveModule ends here.
}//class ThreatLevelMotiveModule ends here