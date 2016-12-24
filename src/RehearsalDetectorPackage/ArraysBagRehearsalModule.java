//This ArraysBagRehearsalModule is for the submodule RehearsalOrPractic but might contain arrays from other modules
//cross check with others for the final ArraysBagRehearsalModule.java file.
package RehearsalDetectorPackage;

public class ArraysBagRehearsalModule {    
 
     String rehearsalContinuousVerbs[];
    //Helping verbs are already attached to pronousn in the pronousn array so we need only the second and third forms in the array below.
     String rehearsalPastAndPerfectVerbs[];
    
     String torturedAnimalsVerbsRehearsal[];
    
     String liveSpeciesRehearsal[];            
    
     String weaponsRehearsal[];
    
     String pronousAsSubjectRehearsal[];
    
    
     String popularNamesRehearsal[];

     
     //setters for the above arrays. The setters are used to set the values of the arrays from the database.
    public void setLiveSpeciesRehearsal(String[] liveSpeciesRehearsal) {
        this.liveSpeciesRehearsal = liveSpeciesRehearsal;
    }

    public void setPopularNamesRehearsal(String[] popularNamesRehearsal) {
        this.popularNamesRehearsal = popularNamesRehearsal;
    }

    public void setPronousAsSubjectRehearsal(String[] pronousAsSubjectRehearsal) {
        this.pronousAsSubjectRehearsal = pronousAsSubjectRehearsal;
    }

    public void setRehearsalContinuousVerbs(String[] rehearsalContinuousVerbs) {
        this.rehearsalContinuousVerbs = rehearsalContinuousVerbs;
    }

    public void setRehearsalPastAndPerfectVerbs(String[] rehearsalPastAndPerfectVerbs) {
        this.rehearsalPastAndPerfectVerbs = rehearsalPastAndPerfectVerbs;
    }

    public void setTorturedAnimalsVerbsRehearsal(String[] torturedAnimalsVerbsRehearsal) {
        this.torturedAnimalsVerbsRehearsal = torturedAnimalsVerbsRehearsal;
    }

    public void setWeaponsRehearsal(String[] weaponsRehearsal) {
        this.weaponsRehearsal = weaponsRehearsal;
    }
     
     

}//class ArraysBagRehearsalModule ends here.
