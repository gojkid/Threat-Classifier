package WeaponsDetectorPackage;

final class Weapons {
    
    ArraysBagWeaponsModule ArraysBagWeaponsModule;

    public Weapons(WeaponsDetectorPackage.ArraysBagWeaponsModule ArraysBagWeaponsModule) {
        this.ArraysBagWeaponsModule = ArraysBagWeaponsModule;
    }

    private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }


     int HAS_ACCESS_TO_GUNS = 9;
     int WILL_USE_RELATIVES_GUN = 7;
     int WILL_BUY_AND_HAVE_MONEY = 4;
     int WILL_BUY_BUT_HAVE_NO_MONEY = 2;
     int WILL_BUY_BUT_MONEY_NOT_MENTIONED = 3;
     int FRIEND_HAS_GUN = 4;
     int FRIEND_GUN_NOT_MENTIONED = 2;
     int WILL_STEAL_GUN = 6;//often they stealWeapons it from family or relatives.
     int WILL_STEAL_GUN_FROM_ANY_ONE = 3;
     int HEAVEN_HELL_SENDIG_UP = 4;

    ////////////////////////////////////////////////////////////////
    //Checking if there is a weapon in the text.
    private  boolean Weapons(String text) {
        int i = 0;

        for (i = 0; i < ArraysBagWeaponsModule.weaponsWeapons.length; i++) {
            if (text.contains(ArraysBagWeaponsModule.weaponsWeapons[i])) {
                return true;
            }
        }
        return false;
    }//method weapon ends here
//////////////////////////////////////////////////////////////////////////////////////////////
    //Checking if the text says that the shooter has his own gun   

    private  boolean AccessToWeapons(String loweredCasedText) {

        //Checking for "willWeapons useWeapons my gun" kind of sentences.
        for (int i = 0; i < ArraysBagWeaponsModule.willWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.useWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.possessivePronousWeapons.length; k++) {
                    for (int l = 0; l < ArraysBagWeaponsModule.weaponsWeapons.length; l++) {
                        if (loweredCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.useWeapons[j] + " " + ArraysBagWeaponsModule.possessivePronousWeapons[k] + " " + ArraysBagWeaponsModule.weaponsWeapons[l])) {
                            return true;
                        }
                    }//loop L ends here
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        ///////////////////////////////////////////////////////////////////////////////////////////
        //checking for sentences .... have some guns ... have guns ... have made bombs....has made bombs
        for (int i = 0; i < ArraysBagWeaponsModule.accessToGunsPerfectTenseWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.weaponsWeapons.length; k++) {

                    if (loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[k])
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[k] + "s")
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[k])
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[k] + "s")) {                                            
                        return true;
                    }//loop ek ends here.
                }//loop j ends here
            }//loop i ends here
        }//for loop for perfect tenses ends here.

  
        //checking for the present tense "has some guns"  ... "has guns" .... 

        for (int i = 0; i < ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; k++) {
                    if (loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[k] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {                        
                        return true;
                    }
                }
            }
        }//for loop for present tenses ends here.                
  

        //checking for perfect continuous tenses 
        //have been making bombs .... has been making a bomb
        for (int i = 0; i < ArraysBagWeaponsModule.accessToGunsPerfectContinuousTenseWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.weaponsWeapons.length; k++) {
                    if (loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectContinuousTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[k])
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectContinuousTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[k] + "s")
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectContinuousTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[k])
                            || loweredCasedText.contains(ArraysBagWeaponsModule.accessToGunsPerfectContinuousTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[k] + "s")) {
                        return true;
                    }
                }
            }
        }//for loop for perfect continuous tenses ends here.
        //with my gun.....with their swords......using my gun....using their guns
        
            for (int i = 0; i < ArraysBagWeaponsModule.possessivePronousWeapons.length; i++) {
                for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                    if (loweredCasedText.contains("with " + ArraysBagWeaponsModule.possessivePronousWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])
                            || loweredCasedText.contains("using " + ArraysBagWeaponsModule.possessivePronousWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])
                            )
                        return true;                    
                }            
        }//for loop for perfect continuous tenses ends here.
    
        return false;
    }//method AccessToWeapons ends here.
//////////////////////////////////////////////////////////////////////////////////////////////////////////    
//Most of the shooters useWeapons their relative's guns.

    private  boolean checkWill(String loweredCasedText) {

        int i = 0, j = 0;
        boolean willUseFound = false;
        for (i = 0; i < ArraysBagWeaponsModule.willWeapons.length; i++) {
            for (j = 0; j < ArraysBagWeaponsModule.useWeapons.length; j++) {
                if (loweredCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.useWeapons[j]))
                {
                    willUseFound = true;
                    break;
                }
            }
        }
        if (willUseFound == true) {
            for (int k = 0; k < ArraysBagWeaponsModule.possessivePronousWeapons.length; k++) {
                for (int l = 0; l < ArraysBagWeaponsModule.relationsForGunWeapons.length; l++) {
                    for (int m = 0; m < ArraysBagWeaponsModule.weaponsWeapons.length; m++) {
                        if (loweredCasedText.contains((ArraysBagWeaponsModule.possessivePronousWeapons[k] + " " + ArraysBagWeaponsModule.relationsForGunWeapons[l] + " " + ArraysBagWeaponsModule.weaponsWeapons[m]))
                                //my father's bomb///willWeapons detonate my uncle's bombs  //willWeapons useWeapons fathers' bomb  //willWeapons useWeapons their fathers' bombs
                                || loweredCasedText.contains((ArraysBagWeaponsModule.relationsForGunWeapons[l] + " " + ArraysBagWeaponsModule.weaponsWeapons[m]))
                                //father's bomb//willWeapons detonate bombs  //willWeapons useWeapons their fathers' bomb                                                                                                                                                  
                                || loweredCasedText.contains(("the " + ArraysBagWeaponsModule.weaponsWeapons[m] + " " + ArraysBagWeaponsModule.possessivePronousWeapons[k] + " " + ArraysBagWeaponsModule.relationsForGunWeapons[l]))
                                //the gun of my father  
                                || loweredCasedText.contains((ArraysBagWeaponsModule.weaponsWeapons[m] + " " + ArraysBagWeaponsModule.possessivePronousWeapons[k] + " " + ArraysBagWeaponsModule.relationsForGunWeapons[l]))) {
                            //gun of my father.
                            return true;
                        }
                    }
                }
            }
        }
  
        return false;
    }//method for checking access to guns of relatives ends here.
////////////////////////////////////////////////////////////////////    

/////////////////////////////////////////////////////////////////////////////////////////////
    //Low marks as it is pat tense ... He bought guns... may be he does not have it now.... 
    private  boolean checkPastTense(String lowerCasedText) {

        for (int i = 0; i < ArraysBagWeaponsModule.accessToGunsPastTenseWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; k++) {
                    if (lowerCasedText.contains(ArraysBagWeaponsModule.accessToGunsPastTenseWeapons[i] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[k] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])
                            || lowerCasedText.contains(ArraysBagWeaponsModule.accessToGunsPastTenseWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }//method checkPastTense ends here.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean buyingWeapons(String lowerCasedText) {
        boolean res = false;
        for (int i = 0; i < ArraysBagWeaponsModule.buyWeapons.length; i++) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.buyWeapons[i])) {
                res = true;
                break;
            }
        }
        if (res == false) {
            return false;
        }

        int i = 0, j = 0, k = 0, l = 0;
        for (i = 0; i < ArraysBagWeaponsModule.willWeapons.length; i++) {
            for (j = 0; j < ArraysBagWeaponsModule.buyWeapons.length; j++) {
                for (k = 0; k < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; k++) {
                    for (l = 0; l < ArraysBagWeaponsModule.weaponsWeapons.length; l++) {
                        if (lowerCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.buyWeapons[j] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[k] + " " + ArraysBagWeaponsModule.weaponsWeapons[l])
                                //willWeapons buyWeapons  a/some gun(s))
                                || lowerCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.buyWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[l]) //willWeapons buyWeapons gun(s)                               
                                ) {
                            return true;
                        }
                    }
                }
            }
        }//loop i ends here
 
        return false;
    }//method for buyingWeapons ends here.
/////////////////////////////////////////////////////////////////////////////////////////////
//Check whether the perpetrator who claims to buyWeapons guns has money!

    private  boolean HaveMoneyWeapons(String lowerCasedText) {

        boolean res = false;
        int i = 0;
        while (i < ArraysBagWeaponsModule.HaveMoneyWeapons.length) {
            //for (k = 0; k < ArraysBagWeaponsModule.Money.length; k++) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.HaveMoneyWeapons[i])) {
                return true;
            }
            i++;
        }//while loop ends here.

        return false;
    }//method Money ends here
////////////////////////////////////////////////////////////////////////////////////////////   
//check for words showing that the perpetrator has no money

    private  boolean noMoneyWeapons(String lowerCasedText) {
        int i = 0;
        while (i < ArraysBagWeaponsModule.noMoneyWeapons.length) {
            //for (k = 0; k < ArraysBagWeaponsModule.noMoneyWeapons.length; k++) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.noMoneyWeapons[i])) {
                return true;
            }
            i++;
        }//while loop ends here.
      
        return false;
    }//method noMoneyWeapons ends here.
////////////////////////////////////////////////////////////////////////////////////////    
//check for words for borrowing guns
//willWeapons borrowWeapons some guns 

    private  boolean borrowWeapons(String lowerCasedText) {

        boolean willBorrowStringFound = false;
        for (int i = 0; i < ArraysBagWeaponsModule.willWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.borrowWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.borrowWeapons[j])) {
                    willBorrowStringFound = true;
                    break;
                }
            }
        }
        if (willBorrowStringFound == false) {
            return false;
        }


        for (int i = 0; i < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                {
                    if (lowerCasedText.contains(ArraysBagWeaponsModule.quantityOfGunsWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }//method borrowWeapons ends here.
/////////////////////////////////////////////////////////////////////////////////////////////
//Check for words that shows that the text has the word friendWeapons or its synonyms.
//When we reach here we have already ensured that the text contains some form of "willWeapons borrowWeapons a gun"

    private  boolean friendHasGun(String lowerCasedText) {

        for (int i = 0; i < ArraysBagWeaponsModule.friendWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.friendWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagWeaponsModule.weaponsWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.friendWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.weaponsWeapons[i] + " from a " + ArraysBagWeaponsModule.friendWeapons[j])
                        || lowerCasedText.contains(ArraysBagWeaponsModule.weaponsWeapons[i] + " of a " + ArraysBagWeaponsModule.friendWeapons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagWeaponsModule.possessivePronousWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.friendWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.possessivePronousWeapons[i] + " " + ArraysBagWeaponsModule.friendWeapons[j])
                        || lowerCasedText.contains(ArraysBagWeaponsModule.friendWeapons[j] + ArraysBagWeaponsModule.possessivePronousWeapons[i])) {
                    return true;
                }
            }
        }
        return false;
    }//method friendHasGun ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//check for words showing that the perpetrator willWeapons stealWeapons a gun from relatives.
//willWeapons stealWeapons my father's gun
    private  boolean stealWeaponsFromRelatives(String lowerCasedText) {

        boolean willSteelStringFound = false;
        for (int i = 0; i < ArraysBagWeaponsModule.willWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.stealWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.willWeapons[i] + " " + ArraysBagWeaponsModule.stealWeapons[j])) {
                    willSteelStringFound = true;
                    break;
                }
            }
        }
        if (willSteelStringFound == false) {
            return false;
        }

        for (int i = 0; i < ArraysBagWeaponsModule.relationsForGunWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.relationsForGunWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagWeaponsModule.weaponsWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.possessivePronousWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.relationsForGunWeapons.length; k++) {
                    if (lowerCasedText.contains(ArraysBagWeaponsModule.weaponsWeapons[i] + " " + ArraysBagWeaponsModule.possessivePronousWeapons[j] + " " + ArraysBagWeaponsModule.relationsForGunWeapons[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }//method stealWeaponsFromRelatives ends here.
////////////////////////////////////////////////////////////////////////////////////////
//check for words showing that the perpetrator willWeapons stealWeapons a gun from relatives.
//willWeapons stealWeapons my father's gun
    private  boolean stealWeaponsSourceFromAnyOne(String lowerCasedText) {

        boolean SteelStringFound = false;

        for (int i = 0; i < ArraysBagWeaponsModule.stealWeapons.length; i++) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.stealWeapons[i])) {
                SteelStringFound = true;
                break;
            }
        }
        if (SteelStringFound == false) {
            return false;
        }

        for (int i = 0; i < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.weaponsWeapons.length; j++) {
                if (lowerCasedText.contains(ArraysBagWeaponsModule.quantityOfGunsWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[j])) {
                    return true;
                }
            }
        }
        return false;
    }//method stealWeaponsFromAnyOne ends here.            
////////////////////////////////////////////////////////////////////////////////////////

    private  boolean checkForPhrasesHeavenHellUp(String lowerCasedText) {
        for (int i = 0; i < ArraysBagWeaponsModule.completePhrasesWeapons.length; i++) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.completePhrasesWeapons[i])) {
                return true;
            }
        }
        return false;

    }//method checkForPhrasesHeavenHellUp ends here.
///////////////////////////////////////////////////////////////////////////////////////
//checking for negative cases
    private  boolean checkNegativeCases(String lowerCasedText) {
        boolean res = false;
        int loop = 0;
        while (loop < ArraysBagWeaponsModule.negativeHelpingVerbsWeapons.length) {
            if (lowerCasedText.contains(ArraysBagWeaponsModule.negativeHelpingVerbsWeapons[loop])) {
                res = true;
                break;
            }
            loop++;
        }//while loop ends here.
        if (res == false) {
            return false;
        }

        for (int i = 0; i < ArraysBagWeaponsModule.negativeHelpingVerbsWeapons.length; i++) {
            for (int j = 0; j < ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons.length; j++) {
                for (int k = 0; k < ArraysBagWeaponsModule.quantityOfGunsWeapons.length; k++) {
                    for (int l = 0; l < ArraysBagWeaponsModule.weaponsWeapons.length; l++) {
                        if (lowerCasedText.contains(ArraysBagWeaponsModule.negativeHelpingVerbsWeapons[i] + " " + ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons[j] + " " + ArraysBagWeaponsModule.quantityOfGunsWeapons[k] + " " + ArraysBagWeaponsModule.weaponsWeapons[l])
                                || lowerCasedText.contains(ArraysBagWeaponsModule.negativeHelpingVerbsWeapons[i] + " " + ArraysBagWeaponsModule.accessToGunsPresentTenseWeapons[j] + " " + ArraysBagWeaponsModule.weaponsWeapons[l])
                                || lowerCasedText.contains(ArraysBagWeaponsModule.negativeHelpingVerbsWeapons[i] + " " + ArraysBagWeaponsModule.weaponsWeapons[l])) {
                            return true;
                        }
                    }
                }
            }
        }//for loop for negative cases ends here.
 
        return false;
    }//method for checking negative cases ends here
/////////////////////////////////////////////////////////////////////////////////////////////    
     int threatLevelWeaponsModule(String text) {
        String loweredCasedText = text.toLowerCase();
        int res = 0;
        if (Weapons(loweredCasedText)) {//First check for words related to weaponsWeapons. If none, don't do anything.            

            if (checkNegativeCases(loweredCasedText)) {
                res += 0;
            } //Checking personal weaponsWeapons
            else if (AccessToWeapons(loweredCasedText)) {

                res += HAS_ACCESS_TO_GUNS; //gets 9
                msg="The perpetrator migh have access to a personal weapon!";

            } //willWeapons useWeapons my father's gun ..... type of sentences. checking acess to relatives's weaponsWeapons
            else if (checkWill(loweredCasedText)) {

                res += WILL_USE_RELATIVES_GUN;  //gets 7 
                msg="The perpetrator might have access to relatives' guns";
            } //Does the threat say anything about buying weaponsWeapons?
            else if (stealWeaponsFromRelatives(loweredCasedText)) {   //gets 6. Most of the shooter steals from relatives
                res += WILL_STEAL_GUN;
                msg="The perpetrator might be planning to steal Weapons guns from relatives, family or friends!";
            } else if (stealWeaponsSourceFromAnyOne(loweredCasedText)) {   //gets 3. Most of the shooter steals from relatives
                res += WILL_STEAL_GUN_FROM_ANY_ONE;
                msg="The perepetrators might be planning to steal Weapons guns from anywhere!";
            } else if (checkPastTense(loweredCasedText)) {
                res += 5;
            } else if (buyingWeapons(loweredCasedText)) {                
                //Has the shooter money to buyWeapons guns?
                if (noMoneyWeapons(loweredCasedText)) {
                    res += WILL_BUY_BUT_HAVE_NO_MONEY;
                    msg="The perpetrator has money to buy Weapons guns and wants to buyWeapons it too!";
                } //Checking for words that prove that the shooter has no money.
                else if (HaveMoneyWeapons(loweredCasedText)) {
                    res += WILL_BUY_AND_HAVE_MONEY;
                    msg="The perpetrator might be planning to buyWeapons guns although he doen't have money!";
                }//No proof of having money or not having any money so lets give him some thing for saying that he willWeapons buyWeapons guns
                else {
                    res += WILL_BUY_BUT_MONEY_NOT_MENTIONED;
                    msg="The perpetrator might be planning to buyWeapons weaponsWeapons!";
                }
            } //Does the text say something about borrowing guns?
            else if (borrowWeapons(loweredCasedText)) {
                //Does the text mentions his friends having guns with them?
                if (friendHasGun(loweredCasedText)) {
                    res += FRIEND_HAS_GUN;
                    msg="The perpetrator might be planning to borrowWeapons a gun from a friendWeapons that has gun!";
                } //Check that friendWeapons is not mentioned.
                else {
                    res += FRIEND_GUN_NOT_MENTIONED;
                    msg="The perpetrator might be planning to borrowWeapons a gun from someone!";
                }
            } //Does the text mentions stealing weaponsWeapons from father, mother etc or friends.

            if (checkForPhrasesHeavenHellUp(loweredCasedText)) {
                res += HEAVEN_HELL_SENDIG_UP;
                msg="The perpetrator might be able to arrange a gun and is using language that suggests bad intentions!";
            }
            //Determine the class of the threat at this submoudle level 
        }
        if (res >= 9) {//9 means the perpetrator already has gun
            return 3;//High level
        } else if (res < 9 && res >= 6) {//6 means the perpetrator has a fair chance of stealing a gun. 7 means perpetrator  might have access to relatives' gun.
            return 2;//Medium level
        } else if (res < 6 && res > 0) {//can buyWeapons or borrowWeapons gun
            return 1;//Low level
        } else {
            return 0;//No threat
        }
    }//method threatLevelWeaponsModule ends here.
}//class Weapons ends here.
