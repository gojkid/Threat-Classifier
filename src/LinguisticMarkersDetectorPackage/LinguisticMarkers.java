//LinguisticMarkers.java decides the class or category of a text on the base of linguistic features of the text
//It is a submodule and will work with other submodule to give the final category.
package LinguisticMarkersDetectorPackage;

/**
 *
 * @author admin
 */
final class LinguisticMarkers {

    public LinguisticMarkers(LinguisticMarkersDetectorPackage.ArraysBagLinguisiticMarkersModule ArraysBagLinguisiticMarkersModule) {
        this.ArraysBagLinguisiticMarkersModule = ArraysBagLinguisiticMarkersModule;
    }

   private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }
    
ArraysBagLinguisiticMarkersModule ArraysBagLinguisiticMarkersModule;
/////////////////////////////////////////////////////////////////////////////////////////////////
    private  boolean oppositeGroups(String lowerCasedText) {
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.group1LinguisticMarkers.length; i++) {
            for (int j = 0; j < ArraysBagLinguisiticMarkersModule.fightLinguisticMarkers.length; j++) {
                for (int k = 0; k < ArraysBagLinguisiticMarkersModule.group2LinguisticMarkers.length; k++) {
                    if (lowerCasedText.contains(ArraysBagLinguisiticMarkersModule.group1LinguisticMarkers[i]) && stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.fightLinguisticMarkers[j]) && lowerCasedText.contains(ArraysBagLinguisiticMarkersModule.group2LinguisticMarkers[k])) {
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.group1LinguisticMarkers.length; i++) {
            for (int j = 0; j < ArraysBagLinguisiticMarkersModule.killLinguisticMarkers.length; j++) {
                for (int k = 0; k < ArraysBagLinguisiticMarkersModule.group2LinguisticMarkers.length; k++) {
                    if (lowerCasedText.contains(ArraysBagLinguisiticMarkersModule.group1LinguisticMarkers[i]) && stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.killLinguisticMarkers[j]) && stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.group2LinguisticMarkers[k])) {
                        return true;
                    }
                }
            }
        }
        return false;//No opposing groups found
    }//method oppositeGroups ends here.
////////////////////////////////////////////////////////////////////////////////////////////////

    private  int checkViolentWords(String lowerCasedText) {
        int CounterViolentWords = 0;
        //check for violenceLinguisticMarkers related terms
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.violenceLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.violenceLinguisticMarkers[i])) {
                CounterViolentWords++;
            }
        }
        //check for killLinguisticMarkers and other such terms.
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.killLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.killLinguisticMarkers[i])) {
                CounterViolentWords++;
            }
        }

        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.markersLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.markersLinguisticMarkers[i])) {
                CounterViolentWords++;
            }
        }
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.negativeLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.negativeLinguisticMarkers[i])) {
                CounterViolentWords++;
            }
        }
        return CounterViolentWords;
    }//method checkViolentWords ends here.
///////////////////////////////////////////////////////////////////////////////////////////////

    private  int dirtyLanguageAndSlangs(String lowerCasedText) {
        int CounterNegativeAdjectives = 0;
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.slangsLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.slangsLinguisticMarkers[i])) {
                CounterNegativeAdjectives++;
            }
        }
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.dirtyWordsLinguisticMarkers.length; i++) {
            if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, ArraysBagLinguisiticMarkersModule.dirtyWordsLinguisticMarkers[i])) {
                CounterNegativeAdjectives++;
            }
        }
        return CounterNegativeAdjectives;
    }//method negativeAdjectives ends here.
////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean checkForInterjections(String lowerCasedText) {
        boolean res = false;
        String temp = "";
        for (int i = 0; i < ArraysBagLinguisiticMarkersModule.symbolsLinguisticMarkers.length; i++) {
            for (int j = 0; j < 10; j++) {
                temp = temp + ArraysBagLinguisiticMarkersModule.symbolsLinguisticMarkers[i];
                if (stringMethodOnlyForLinguisticMarkersModule.contains(lowerCasedText, temp) && j > 1) {// i > 1 means 3 or more symbolsLinguisticMarkers consecutively
                    res = true;
                }
            }
            temp = "";//Making temp empty for the next item in the array symbolsLinguisticMarkers[]
        }
        return res;
    }
///////////////////////////////////////////////////////////////////////////////////////////
    //count the number of words in the threat.

    public  int countWords(String s) {

        int counter = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is letter, word = true.
            if (Character.isLetter(s.charAt(i)) == true && i != endOfLine) {
                word = true;
                // if char isnt letter and there have been letters before (word
                // == true), counter goes up.
            } else if (Character.isLetter(s.charAt(i)) == false && word == true) {
                counter++;
                word = false;
                // last word of String, if it doesnt end with nonLetter it
                // wouldnt count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                counter++;
            }
        }
        return counter;
    }
/////////////////////////////////////////////////////////////////////////////////////////////

     int threatLevel(String lowerCasedText) {
        int runningTotalLinguisticMarkersmodule = 0;
        int numberOfWordsInThreat = countWords(lowerCasedText) - 1;//subtract 1 for the word exit that we enter afte typing the threat. Not needed to subtract in the URL and file upload version.        

        if (oppositeGroups(lowerCasedText)) {
            runningTotalLinguisticMarkersmodule += 3; //The two groups group1LinguisticMarkers and group2LinguisticMarkers could be misleading and the words related to fightLinguisticMarkers and killLinguisticMarkers are marked in method checkViolentWords so 3 marks
            msg="The perpetrator might have some opposing groups in mind!";
        }
        if (checkForInterjections(lowerCasedText)) {
            runningTotalLinguisticMarkersmodule += 2; //might not know the language and find it difficult to express in full sentences. 
            msg="The text has indicator that might indicate that the perpetrator might be emotionally disturbed or instable!";
        }
        int scoreOfViolentWords = checkViolentWords(lowerCasedText);
        if (scoreOfViolentWords > 0) {
            msg="Violence related words found in the text!";
        }
        runningTotalLinguisticMarkersmodule += scoreOfViolentWords;
        int scoreOfSlangsDirtyLanguage = dirtyLanguageAndSlangs(lowerCasedText);
        if (scoreOfSlangsDirtyLanguage > 0) {
            msg="Improper language has been used in the text!";
        }
        runningTotalLinguisticMarkersmodule += scoreOfSlangsDirtyLanguage;

        if (runningTotalLinguisticMarkersmodule >= 5) {
            if (numberOfWordsInThreat >= 6) {
                return 3;
            } else {
                return 2;
            }
        } else if (runningTotalLinguisticMarkersmodule < 10 && runningTotalLinguisticMarkersmodule >= 2) {
            if (numberOfWordsInThreat >= 4) {
                return 2;
            } else {
                return 1;
            }
        } else if (runningTotalLinguisticMarkersmodule < 2 && runningTotalLinguisticMarkersmodule >= 1) {
            return 1;
        } else {
            return 0;
        }
    }//method threatLevel ends here.
}//class LinguisticMarkers ends here.
