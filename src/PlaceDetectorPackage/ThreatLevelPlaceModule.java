/*This ThreatLevelPlaceModule.java is for Place module only*/
package PlaceDetectorPackage;

import java.io.IOException;

public class ThreatLevelPlaceModule {

    private int WeightageOfPlace; //Using variables instead of fixed variables to make it easy to make change at one place if we want to change the value.
    private int scorePlaceModule; //Possible values are: High = 3; Medium = 2; Low = 1; NoThreat = 0; This value will be given according to the seriousness returned by the respective submodule.
    private String submoudlePlaceCategory;
    private ArraysBagPlaceModule ArraysBagPlaceModule;

    public ThreatLevelPlaceModule(String paragraph) throws IOException {
        WeightageOfPlace = 10;
        scorePlaceModule = 0;
        submoudlePlaceCategory = "";
        ArraysBagPlaceModule=new ArraysBagPlaceModule();
        calculateThreatLevelInPlaceSubModule(paragraph);
    }//cosntructor ends here.
    
 private String msg="";

    public String getMsg() {
        return msg;
    }

    public String getSubmoudlePlaceCategory() {
        return submoudlePlaceCategory;
    }

    public void setWeightageOfPlace(int aWeightageOfPlace) {
        WeightageOfPlace = aWeightageOfPlace;
    }

    private void setScorePlaceModule(int ThreeTwoOrOne) {
        this.scorePlaceModule = ThreeTwoOrOne;
        determineCategoryPlaceModule(ThreeTwoOrOne);
    }

    public int getWeightageOfPlace() {
        return WeightageOfPlace;
    }

    public int getScorePlaceModule() {
        return scorePlaceModule * this.getWeightageOfPlace();
    }

    private void setSubmoudlePlaceCategory(String submoudlePlaceCategory) {
        this.submoudlePlaceCategory = submoudlePlaceCategory;
    }

    private void calculateThreatLevelInPlaceSubModule(String lowerCasedText) throws IOException {
        databaseConnector dc=new databaseConnector();
        dc.loadDatabaseUp(ArraysBagPlaceModule);
        Place p=new Place(ArraysBagPlaceModule);
        int ThreeTwoOrOne = p.threatLevelPlaceModule(lowerCasedText);
        msg=p.getMsg();
        this.setScorePlaceModule(ThreeTwoOrOne);
    }

    private void determineCategoryPlaceModule(int ThreeTwoOrOne) {
        if (ThreeTwoOrOne == 3) {
            this.setSubmoudlePlaceCategory("High");
        } else if (ThreeTwoOrOne == 2) {
            this.setSubmoudlePlaceCategory("Medium");
        } else if (ThreeTwoOrOne == 1) {
            this.setSubmoudlePlaceCategory("Low");
        } else if(ThreeTwoOrOne == 0){
            this.setSubmoudlePlaceCategory("No Palce Found!");
        }
    }// method determineCategoryPlaceModule ends here.
}//class ThreatLevelPlaceModule for Place module ends here. 
