/*
This ArraysBagPlaceModule.java has data only for place module of the software.
 */
package PlaceDetectorPackage;

public class ArraysBagPlaceModule {
    
        
        //check that the threat also contains the word school or university along with the following vocabulary. If found give higher marks
    //If words from array placesRelatedToSchoolOnly[] are found then skip checking for array places[] as a more particular place has been found
    //Check with combination with the array 
         String placesRelatedToSchoolOnlySingular[];
        
		 String placesRelatedToSchoolOnlyPlural[];
                 
         String placesGenetiveCases[];
        
         String[] placesDoubtfulBothSingularPlural;

        
     String prepositionOfPlaces[];
    
      String[] mapsPlace;
    
          String knowledgeAboutPlaces[];
          
           String weaponsPlace[];
           
          String schoolRelatedVocabularyPlace[];

        //setters for the above arrays. The setters are used to set the values of the arrays from the database.  
    public void setKnowledgeAboutPlaces(String[] knowledgeAboutPlaces) {
        this.knowledgeAboutPlaces = knowledgeAboutPlaces;
    }

    public void setMapsPlace(String[] mapsPlace) {
        this.mapsPlace = mapsPlace;
    }

    public void setPlacesDoubtfulBothSingularPlural(String[] placesDoubtfulBothSingularPlural) {
        this.placesDoubtfulBothSingularPlural = placesDoubtfulBothSingularPlural;
    }

    public void setPlacesGenetiveCases(String[] placesGenetiveCases) {
        this.placesGenetiveCases = placesGenetiveCases;
    }

    public void setPlacesRelatedToSchoolOnlyPlural(String[] placesRelatedToSchoolOnlyPlural) {
        this.placesRelatedToSchoolOnlyPlural = placesRelatedToSchoolOnlyPlural;
    }

    public void setPlacesRelatedToSchoolOnlySingular(String[] placesRelatedToSchoolOnlySingular) {
        this.placesRelatedToSchoolOnlySingular = placesRelatedToSchoolOnlySingular;
    }

    public void setPrepositionOfPlaces(String[] prepositionOfPlaces) {
        this.prepositionOfPlaces = prepositionOfPlaces;
    }

    public void setSchoolRelatedVocabularyPlace(String[] schoolRelatedVocabularyPlace) {
        this.schoolRelatedVocabularyPlace = schoolRelatedVocabularyPlace;
    }

    public void setWeaponsPlace(String[] weaponsPlace) {
        this.weaponsPlace = weaponsPlace;
    }
          
          
}//class ArraysBagPlaceModule ends here. Database works only for Place module
