package TargetDetectorPackage;

import java.io.IOException;

public class ThreatLevelTargetModule {

    private int WeightageOfTarget;
    private int scoreTargetModule;
    private String submoudleTargetCategory;
    private ArraysBagTargetModule ArraysBagTargetModule;

    public ThreatLevelTargetModule(String paragraph) throws IOException {
        this.WeightageOfTarget = 5;
        this.submoudleTargetCategory = "";
        this.scoreTargetModule = 0;
        ArraysBagTargetModule = new ArraysBagTargetModule();
        calculateThreatLevelInTargetSubModule(paragraph);    
    }//cosntructor ends here.   
    
     private String msg="";

    public String getMsg() {
        return msg;
    }
    
    public void setWeightageOfTarget(int WeightageOfTarget) {
        this.WeightageOfTarget = WeightageOfTarget;
    }

    private void setSubmoudleTargetCategory(String submoudleTargetCategory) {
        this.submoudleTargetCategory = submoudleTargetCategory;
    }

    private void setScoreTargetModule(int ThreeTwoOneZero) {
        this.scoreTargetModule = ThreeTwoOneZero;
        determinCategoryTargetModule(ThreeTwoOneZero);//Determine the new category as the score has been changed and reset the category to the new category.
    }

    public int getWeightageOfTarget() {
        return WeightageOfTarget;
    }

    public int getScoreTargetModule() {
        return scoreTargetModule * this.getWeightageOfTarget();
    }

    public String getSubmoudleTargetCategory() {
        return submoudleTargetCategory;
    }

    private void calculateThreatLevelInTargetSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagTargetModule);
        Target t=new Target(ArraysBagTargetModule);
        int ThreeTwoOneZero = t.threatLevelTargetModule(lowerCasedText);
        msg=t.getMsg();
        this.setScoreTargetModule(ThreeTwoOneZero);
    }//method calculateThreatLevelInTargetSubModule ends here.

    private void determinCategoryTargetModule(int ThreeTwoOneZero) {       
        if (ThreeTwoOneZero == 3) {
            this.setSubmoudleTargetCategory("High");
        } else if (ThreeTwoOneZero == 2) {
           this.setSubmoudleTargetCategory("Medium");
        } else if (ThreeTwoOneZero == 1) {
            this.setSubmoudleTargetCategory("Low");
        } else if (ThreeTwoOneZero == 0){
             this.setSubmoudleTargetCategory("No Target Found!");
        }
    }// method determinCategoryTargetModule ends here.
}// class ThreatLevelTargetModule ends here.
