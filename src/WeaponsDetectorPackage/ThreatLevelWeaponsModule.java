package WeaponsDetectorPackage;

import java.io.IOException;

public class ThreatLevelWeaponsModule {

    private int WeightageOfWeapon;
    private int scoreWeaponsModule;
    private String submoudleWeponsCategory;
    private ArraysBagWeaponsModule ArraysBagWeaponsModule;

    public ThreatLevelWeaponsModule(String paragraph) throws IOException {
        WeightageOfWeapon = 10;
        scoreWeaponsModule = 0;
        submoudleWeponsCategory = "";
        ArraysBagWeaponsModule =new ArraysBagWeaponsModule();
        calculateThreatLevelInWeaponsSubModule(paragraph);
    }

    private String msg="";

    public String getMsg() {
        return msg;
    }
    
    public void setWeightageOfWeapon(int WeightageOfWeapon) {
        this.WeightageOfWeapon = WeightageOfWeapon;
    }

    private void setScoreWeaponsModule(int ThreeOrTwoOrOne) {
        this.scoreWeaponsModule = ThreeOrTwoOrOne;
        determinCategoryWeaponsModule(ThreeOrTwoOrOne);
    }

    private void setSubmoudleWeponsCategory(String submoudleWeponsCategory) {
        this.submoudleWeponsCategory = submoudleWeponsCategory;
    }

    public int getWeightageOfWeapon() {
        return WeightageOfWeapon;
    }

    public int getScoreWeaponsModule() {
        return scoreWeaponsModule * this.getWeightageOfWeapon();
    }

    public String getSubmoudleWeponsCategory() {
        return submoudleWeponsCategory;
    }

    private void calculateThreatLevelInWeaponsSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagWeaponsModule);
        Weapons w=new Weapons(ArraysBagWeaponsModule);
        int ThreeOrTwoOrOne = w.threatLevelWeaponsModule(lowerCasedText);
        msg=w.getMsg();
        this.setScoreWeaponsModule(ThreeOrTwoOrOne);        
    }

    private void determinCategoryWeaponsModule(int ThreeOrTwoOrOne) {
        if (ThreeOrTwoOrOne == 3) {
            this.setSubmoudleWeponsCategory("High");
        } else if (ThreeOrTwoOrOne == 2) {
            this.setSubmoudleWeponsCategory("Medium");
        } else if (ThreeOrTwoOrOne == 1) {
            this.setSubmoudleWeponsCategory("Low");
        } else if (ThreeOrTwoOrOne == 0) {
            this.setSubmoudleWeponsCategory("No Weapons Found!");
        }
    }//method determinCategoryWeaponsModule ends here.
}//class ThreatLevelWeaponsModule ends here.
