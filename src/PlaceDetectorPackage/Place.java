
package PlaceDetectorPackage;

final class Place {

    public Place(PlaceDetectorPackage.ArraysBagPlaceModule ArraysBagPlaceModule) {
        this.ArraysBagPlaceModule = ArraysBagPlaceModule;
    }

   private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }

    ArraysBagPlaceModule ArraysBagPlaceModule;
    
    private  boolean checkForPlacesInThreat(String lowerCasedText) {

        for (int i = 0; i < ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular[i])) {
                return true;
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural[i])) {
                return true;
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.placesGenetiveCases.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.placesGenetiveCases[i])) {
                return true;
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.placesDoubtfulBothSingularPlural.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.placesDoubtfulBothSingularPlural[i])) {
                return true;
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.knowledgeAboutPlaces.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.knowledgeAboutPlaces[i])) {
                return true;
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.mapsPlace.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.mapsPlace[i])) {
                return true;
            }
        }
        return false;
    }//method checkForPlacesInThreat ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////        
    private  boolean findPlacesRelatedT0School(String lowerCasedText) {
//For example 
        //in the school.............in the classroom
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular.length; j++) {
                if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular[j])) {
                    return true;
                }
            }
        }
        //.in the classrooms in the school offices.... in the rooms
        //If you are here singular places related to school were not found
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural.length; j++) {
                if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural[j])) {
                    return true;
                }
            }
        }
        //If you are here both plural and singular places related to school were not found
        // in the principal's office............in the teachers' staff room
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesGenetiveCases.length; j++) {
                if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesGenetiveCases[j])) {
                    return true;
                }
            }
        }
        return false;
    }//method findPlacesRelatedT0School ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////   
    //in the ground............ in the pool ....... on the roof
    private  boolean findPlacesDoubtful(String lowerCasedText) {

        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesDoubtfulBothSingularPlural.length; j++) {

                if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesDoubtfulBothSingularPlural[j])) {
                    return true;
                }
            }
        }
        return false;
    }//method findPlacesDoubtful ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////
    private  boolean sketchesOrMaps(String lowerCasedText) {

        for (int i = 0; i < ArraysBagPlaceModule.mapsPlace.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.mapsPlace[i])) {
                return true;
            }
        }
        return false;
    }//method sketchesOrMaps ends here.
////////////////////////////////////////////////////////////////////////////////////////

    private  boolean movingFromPlaceToPlaceInSchool(String lowerCasedText) {

        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular.length; j++) {
                for (int k = 0; k < ArraysBagPlaceModule.prepositionOfPlaces.length; k++) {

                    if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesRelatedToSchoolOnlySingular[j] + " " + ArraysBagPlaceModule.prepositionOfPlaces[k])) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural.length; j++) {
                for (int k = 0; k < ArraysBagPlaceModule.prepositionOfPlaces.length; k++) {

                    if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesRelatedToSchoolOnlyPlural[j] + " " + ArraysBagPlaceModule.prepositionOfPlaces[k])) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesGenetiveCases.length; j++) {
                for (int k = 0; k < ArraysBagPlaceModule.prepositionOfPlaces.length; k++) {

                    if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesGenetiveCases[j] + " " + ArraysBagPlaceModule.prepositionOfPlaces[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }//method movingFromPlaceToPlace ends here.
////////////////////////////////////////////////////////////////////////////////////////////////
    private  boolean movingFromPlaceToPlaceDoubtful(String lowerCasedText) {
// from pool to pool ............. from ground to ground  .....
        for (int i = 0; i < ArraysBagPlaceModule.prepositionOfPlaces.length; i++) {
            for (int j = 0; j < ArraysBagPlaceModule.placesDoubtfulBothSingularPlural.length; j++) {
                for (int k = 0; k < ArraysBagPlaceModule.prepositionOfPlaces.length; k++) {
                    if (lowerCasedText.contains(ArraysBagPlaceModule.prepositionOfPlaces[i] + " " + ArraysBagPlaceModule.placesDoubtfulBothSingularPlural[j] + " " + ArraysBagPlaceModule.prepositionOfPlaces[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }//method movingFromPlaceToPlace ends here.
////////////////////////////////////////////////////////////////////////////////////////////////
    private  boolean knowledgeAboutPlaces(String lowerCasedText) {
        for (int i = 0; i < ArraysBagPlaceModule.knowledgeAboutPlaces.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.knowledgeAboutPlaces[i])) {
                return checkForWeaponInPlaceModule(lowerCasedText);
            }
        }
        return false;
    }//method knowledgeAboutPlaces ends here.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean checkForWeaponInPlaceModule(String lowerCasedText) {
        for (int i = 0; i < ArraysBagPlaceModule.weaponsPlace.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.weaponsPlace[i])) {
                return true;//weapon was found in the text.
            }
        }
        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////   
    private  int checkForSchoolRelatedVocabulary(String lowerCasedText) {
        int numberOfSchoolRelatedVocabularyFoundInText = 0;
        for (int i = 0; i < ArraysBagPlaceModule.schoolRelatedVocabularyPlace.length; i++) {
            if (lowerCasedText.contains(ArraysBagPlaceModule.schoolRelatedVocabularyPlace[i])) {
                numberOfSchoolRelatedVocabularyFoundInText++;
            }
        }
        return numberOfSchoolRelatedVocabularyFoundInText;
    }// method checkForSchoolRelatedVocabulary ends here.
//////////////////////////////////////////////////////////////////////////////////////////////    
     int threatLevelPlaceModule(String lowerCasedText) {

        int runningTotalPlaceModule = 0;

        boolean weaponsAlsoFoundInText = checkForWeaponInPlaceModule(lowerCasedText);//May be moved to a common file between all modules when merged with other modules
        int NumberOfRelatedVocabulary = checkForSchoolRelatedVocabulary(lowerCasedText);//May be moved to a common file between all modules when merged with other modules

        if (NumberOfRelatedVocabulary >= 3) {//May be moved to a common file between all modules when merged with other modules
            runningTotalPlaceModule += 2;//May be moved to a common file between all modules when merged with other modules
        } else if (NumberOfRelatedVocabulary < 3 && NumberOfRelatedVocabulary > 0) {//May be moved to a common file between all modules when merged with other modules
            runningTotalPlaceModule += 1;//May be moved to a common file between all modules when merged with other modules
        }//May be moved to a common file between all modules when merged with other modules

        if (checkForPlacesInThreat(lowerCasedText)) {

            //if you are here, then some kind of place is there in the text.
            if (movingFromPlaceToPlaceInSchool(lowerCasedText)) {
                if (weaponsAlsoFoundInText == true) {
                    runningTotalPlaceModule += 9;                    
                } else {
                    runningTotalPlaceModule += 6;               
                }
                msg="Movement from one school-relted place to another school-related place found!";
            }else if(findPlacesRelatedT0School(lowerCasedText)) {

             if (weaponsAlsoFoundInText == true) {
             runningTotalPlaceModule += 9;          
             } else {
             runningTotalPlaceModule += 6;             
             }
             msg="School related place(s) found!";
             }else if (movingFromPlaceToPlaceDoubtful(lowerCasedText)) {

                if (weaponsAlsoFoundInText == true) {
                    runningTotalPlaceModule += 6;

                } else {
                    runningTotalPlaceModule += 3;             
                }
                msg="Moving from one place to another place found!";
            } else if (findPlacesDoubtful(lowerCasedText)) {
                //if you are here then places particularly related to school were not found in the text. 
                if (weaponsAlsoFoundInText == true) {
                    runningTotalPlaceModule += 6;                
                } else {
                    runningTotalPlaceModule += 3;               
                }
                msg="Place found! Might not be related to school!";
            } else if (knowledgeAboutPlaces(lowerCasedText)) {
                //Existence of weapons is checked inside that method by calling the method that checks weapons.
                runningTotalPlaceModule += 5;             
                msg="The text shows that the perpetrator might have some knowledge about the place where the target might be found!";
            } else if (sketchesOrMaps(lowerCasedText)) {
                if (weaponsAlsoFoundInText == true) {
                    runningTotalPlaceModule += 5;                   
                } else {
                    runningTotalPlaceModule += 3;                
                }
                msg="The perpetrator might have some maps or sketeches that might be used in school shooting";
            }
        }
        if (runningTotalPlaceModule >= 9) {
            return 3; //High level
        } else if (runningTotalPlaceModule < 9 && runningTotalPlaceModule >= 6) {
            return 2; //Medium level
        } else if (runningTotalPlaceModule < 6 && runningTotalPlaceModule > 0) {
            return 1; //Low level
        } else {
            return 0;//No place found
        }
    }//method threatLevelPlaceModule ends here.
}//class checkForPlacesInThreat ends here.