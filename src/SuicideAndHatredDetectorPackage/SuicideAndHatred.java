
package SuicideAndHatredDetectorPackage;

public class SuicideAndHatred {

    public SuicideAndHatred(SuicideAndHatredDetectorPackage.ArraysBagSuicideAndHatredModule ArraysBagSuicideAndHatredModule) {
        this.ArraysBagSuicideAndHatredModule = ArraysBagSuicideAndHatredModule;
    }

    private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }

    
    ArraysBagSuicideAndHatredModule ArraysBagSuicideAndHatredModule;
    ////////////////////////////////////////////////////////////////////////////////////////
    private  boolean checkForPreviousSuicideAttempts(String lowerCasedText) {
        //attempted to shoot myself........tried to shoot myself..............
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.killsArrayForSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide.length; j++) {
                if (lowerCasedText.contains("tried to" + " " + ArraysBagSuicideAndHatredModule.killsArrayForSuicide[i] + " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[j])
                        || lowerCasedText.contains("attempted to" + " " + ArraysBagSuicideAndHatredModule.killsArrayForSuicide[i] + " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[j])) {
                    return true;
                }
            }
        }//loop i ends here.
        //have shot myself........shot myself..........have tried to shot myself.............tried to shot myself
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.killsArrayForSuicidePastAndPerfectTense.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.killsArrayForSuicidePastAndPerfectTense[i] + " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[j])) {
                    return true;
                }
            }
        }//loop i ends here.    
        //have shot myself........shot myself..........have tried to shot myself.............tried to shot myself
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.previousAttemptsOfSuicide.length; i++) {

            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.previousAttemptsOfSuicide[i])) {
                return true;
            }
        }//loop i ends here.  

        return false;//This means has not tried to commit suicide previously.
    }//method checkForPreviousSuicideAttempts ends here.    
///////////////////////////////////////////////////////////////////////////////////////

    private  boolean checkForPhrasesIndicatingIntentionForSuicide(String lowerCasedText) {
//will cut my wrists ..... 
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.willShalForSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.suicideVerbsWithWillShall.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.willShalForSuicide[i] + " " + ArraysBagSuicideAndHatredModule.suicideVerbsWithWillShall[j])) {
                    return true;
                }

            }
        }//loop i ends here.
        //killsArrayForSuicide
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.willShalForSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.killsArrayForSuicide.length; j++) {
                for (int k = 0; k < ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide.length; k++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.willShalForSuicide[i] + " " + ArraysBagSuicideAndHatredModule.killsArrayForSuicide[j]+ " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[k])) {
                    return true;
                }
                }
            }
        }//loop i ends here.

        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public  boolean checkForNegativeCasesOfSuicide(String lowerCasedText) {

        //NOT kill myself.....NOT kill themselves .....NOT  kill herself ..... 
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.killsArrayForSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide.length; j++) {
                if (lowerCasedText.contains("not" + " " + ArraysBagSuicideAndHatredModule.killsArrayForSuicide[i] + " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[j])) {
                    return true;
                }
            }
        }//loop i ends here.
//will NOT cut his wrists ..... 
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.willShalForSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.suicideVerbsWithWillShall.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.willShalForSuicide[i] + " " + "not" + " " + ArraysBagSuicideAndHatredModule.suicideVerbsWithWillShall)) {
                    return true;
                }

            }
        }//loop i ends here.
        //checking for statement ... will run away ......will leave the scene ..... will hide
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.nokillsSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.nokillsSuicide[i])) {
                return true;

            }
        }
        return false;
    }//method checkForNegativeCasesOfSuicide ends here.
///////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean takesPsychiatricMedicine(String lowerCasedText) {
        //Array psychiatricMedicineNamesSuicide contains medicine names for depression and anxiety that were previously prescribed to school shooters
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.psychiatricMedicineNamesSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.psychiatricMedicineNamesSuicide[i])) {
                return true;
            }
        }
        return false;//not taking any psychiatric medicine
    }//method takingPsychiatricMedicine ends here.
////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean countDepressionAndAnxietyWords(String lowerCasedText) {
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.depressionAnxietySuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.depressionAnxietySuicide[i])) {
                return true;
            }
        }

        return false;//no symptoms of depression in the text found
    }//method countDepressionAndAnxietyWords ends here.
//////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean hatredSchoolRelatedWords(String lowerCasedText) {
        //abhor(s) teacher...........hate(s) students
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.groupSchoolRelatedSuicide.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide[i] + ArraysBagSuicideAndHatredModule.groupSchoolRelatedSuicide[j])) {
                    return true;
                }
            }
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean slefHatredWords(String lowerCasedText) {
        int countSelfHatredWords = 0;
        //hate myself.........detest themselves..........
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide[i] + " " + ArraysBagSuicideAndHatredModule.myselfOurSelvesSuicide[j])) {
                    return true;
                }
            }
        }//loop i ends here.
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean societyHatredWrods(String lowerCasedText) {
        
        //hate(s) the system............detest(s) the world.........
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide.length; i++) {
            for (int j = 0; j < ArraysBagSuicideAndHatredModule.hatesAllAndSocietySuicide.length; j++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.hateAndItsSynonmysSuicide[i] + " " + ArraysBagSuicideAndHatredModule.hatesAllAndSocietySuicide[j])) {
                    return true;
                }
            }
        }//loop i ends here.
        return false;
    }//method societyHatredWrods ends here.
////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean breakRecordOfExSchoolShooters(String lowerCasedText) {
        boolean gotHim = false;
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.ExSchooShootersSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.ExSchooShootersSuicide[i])) {
                gotHim = true;
                break;
            }
        }
        if (gotHim == false) {
            return false;
        }
        //if you are here, name of some ex-school shooter is in the text.
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.surpassSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.surpassSuicide[i])) {
                return true;
            }
        }
        return false;
    }//method breakRecordOfExSchoolShooters ends here.
///////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean breakRecordOfExMurders(String lowerCasedText) {
        boolean gotHim = false;
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.murderersSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.murderersSuicide[i])) {
                gotHim = true;
                break;
            }
        }
        if (gotHim == false) {
            return false;
        }
        //if you are here, name of some ex-school shooter is in the text.
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.surpassSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.surpassSuicide[i])) {
                return true;
            }
        }
        return false;
    }//method breakRecordOfExMurders ends here.
///////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean breakRecordOfTerrorists(String lowerCasedText) {
        boolean gotHim = false;
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.terroristsSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.terroristsSuicide[i])) {
                gotHim = true;
                break;
            }
        }
        if (gotHim == false) {
            return false;
        }
        //if you are here, name of some ex-school shooter is in the text.
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.surpassSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.surpassSuicide[i])) {
                return true;
            }
        }
        return false;
    }//method breakRecordOfTerrorists ends here.  
///////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean praisesEx(String lowerCasedText) {
        boolean gotHim = false;
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.appreciateExSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.appreciateExSuicide[i])) {
                gotHim = true;
                break;
            }
        }
        if (gotHim == false) {
            return false;//No words of appreciation in the text
        }
        for (int j = 0; j < ArraysBagSuicideAndHatredModule.ExSchooShootersSuicide.length; j++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.ExSchooShootersSuicide[j])) {
                return true;
            }
        }
        return false;
    }//method breakRecordOfTerrorists ends here.
///////////////////////////////////////////////////////////////////////////////////////////////   

    private  boolean humanloss(String lowerCasedText) {
        boolean res = false;

        for (int k = 0; k < ArraysBagSuicideAndHatredModule.relationSuicide.length; k++) {
            for (int i = 0; i < ArraysBagSuicideAndHatredModule.deathSuicide.length; i++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.relationSuicide[k]) && lowerCasedText.contains(ArraysBagSuicideAndHatredModule.deathSuicide[i])) {
                    res = true;

                }
            }
        }
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.breakupSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.breakupSuicide[i])) {
                res = true;

            }
        }
        return res;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean economicloss(String lowerCasedText) {
        boolean res = false;

        for (int k = 0; k < ArraysBagSuicideAndHatredModule.relationSuicide.length; k++) {
            for (int i = 0; i < ArraysBagSuicideAndHatredModule.deathSuicide.length; i++) {
                if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.relationSuicide[k]) && lowerCasedText.contains(ArraysBagSuicideAndHatredModule.deathSuicide[i])) {
                    res = true;

                }
            }
        }
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.breakupSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.breakupSuicide[i])) {
                res = true;

            }
        }
        for (int i = 0; i < ArraysBagSuicideAndHatredModule.economicCrisisSuicide.length; i++) {
            if (lowerCasedText.contains(ArraysBagSuicideAndHatredModule.economicCrisisSuicide[i])) {
                res = true;

            }
        }
        return res;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

     int threatLevelSuicideAndHatredModule(String lowerCasedText) {
        
        int runningTotalSuicideAndHatredModule = 0;
        
        {
            if (checkForPreviousSuicideAttempts(lowerCasedText)) {
                runningTotalSuicideAndHatredModule += 10;//checking for complete phrases and has proven record to do it, so 10.
                msg="The perpetrator might have tried to commit suicide at some stage in life!";
            } else if (checkForPhrasesIndicatingIntentionForSuicide(lowerCasedText)) {
                runningTotalSuicideAndHatredModule += 9; //might be boasting or might not have heart to do it.
            msg="The perpetrator might be planning to do a suicidal attack!";
            } else if (slefHatredWords(lowerCasedText)) {//dangerous to hate oneself
                runningTotalSuicideAndHatredModule += 8;
                msg="The perpetrator might be dangeous as (s)he might hate himself/herself!";
            }
        }

        {
            if (breakRecordOfExSchoolShooters(lowerCasedText)) {
                runningTotalSuicideAndHatredModule += 6; //might be boasting so medium level
               msg="The perpetrator might be thinking of breaking a previous record of school shooting record in terms of targeting more people!";
            } else if (breakRecordOfExMurders(lowerCasedText)) {
                runningTotalSuicideAndHatredModule += 6; //might be boasting so medium level
                msg="The perpetrator might be thinking of breaking famous murderersSuicide' record in terms of targeting more people!";
            } else if (breakRecordOfTerrorists(lowerCasedText)) {
                runningTotalSuicideAndHatredModule += 6; //might be boasting so medium level
                msg="The perpetrator might be thinking of breaking a previous record of famous terroristsSuicide in terms of targeting more people!";
            }

        }
        if (societyHatredWrods(lowerCasedText)) {//many teenagers talk like that.....so medium
            runningTotalSuicideAndHatredModule += 6;
            msg="The perpetrator might be entertaining thoughts of hatred towards society, the world or humanity!";
        }
        if (takesPsychiatricMedicine(lowerCasedText)) {
            runningTotalSuicideAndHatredModule += 6;//Many of the previous cases were using prescribed medicine and withdrawl was one main reason.
        msg="The perpetrator might be using prescribed psychiatric medicine!";
        }
        if (praisesEx(lowerCasedText)) {//praising ex-school shooter is dangerous but many praising them will not do it. Hence medium.
            runningTotalSuicideAndHatredModule += 6;
            msg="The perpetrator seems to prainse ex-school shooters, ex-murderersSuicide or/and ex-terroristsSuicide!";
        }
        if (humanloss(lowerCasedText)) {//break up with a grilfriend or loss or near relatives
            runningTotalSuicideAndHatredModule += 2;
            msg="The perpetrator might have lost a reltive or a gril friend!";
        }
        if (economicloss(lowerCasedText)) {//economic problems, debts
            runningTotalSuicideAndHatredModule += 4;//In some cases it caused withdrawl from prescribed medicine. Many didn't like running after money.
        msg="The perpetrator might be having economic problems!";
        }
        if (countDepressionAndAnxietyWords(lowerCasedText)) {//Depression related words. Can be depressed due to studies.
            runningTotalSuicideAndHatredModule += 1;
        }
        if (hatredSchoolRelatedWords(lowerCasedText)) {//hate teachers ...hate students...... many students hate teachers and school so low
            runningTotalSuicideAndHatredModule += 4;
        }

        if (checkForNegativeCasesOfSuicide(lowerCasedText)) {
            if (runningTotalSuicideAndHatredModule >= 6) {
                runningTotalSuicideAndHatredModule = 2;
                msg="The perpetrator might not have any intentions of suicide!";
            }
        }

        //Determing the category or class at the SucideOrHaterd level
        if (runningTotalSuicideAndHatredModule >= 10) {
            return 3;//HIGH level
        } else if (runningTotalSuicideAndHatredModule < 10 && runningTotalSuicideAndHatredModule >= 6) {
            return 2;//MEDIUM level
        } else if (runningTotalSuicideAndHatredModule < 6 && runningTotalSuicideAndHatredModule > 0) {
            return 1;//LOW level
        } else {
            return 0; //Not a threat.
        }   

    }//method threatLevelSuicideAndHatredModule ends here.
}//class SuicideAndHatred ends here.
