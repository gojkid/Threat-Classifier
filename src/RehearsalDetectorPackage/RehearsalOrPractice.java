//contains logic for detemining whether the perpetrator has done any rehearsal
package RehearsalDetectorPackage;

final class RehearsalOrPractice {

    public RehearsalOrPractice(RehearsalDetectorPackage.ArraysBagRehearsalModule ArraysBagRehearsalModule) {
        this.ArraysBagRehearsalModule = ArraysBagRehearsalModule;
    }

    private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }

    ArraysBagRehearsalModule ArraysBagRehearsalModule;
    
////////////////////////////////////////////////////////////////////////////////////////   
//check if rehearsal has been done or doing now.    
    private  boolean rehearsingOrRhearsed(String lowerCasedText) {
        //check for  "I'm practicing && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalContinuousVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " " + ArraysBagRehearsalModule.rehearsalContinuousVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "John IS practicing && guns "
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalContinuousVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " is " + ArraysBagRehearsalModule.rehearsalContinuousVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "I've practiced && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " " + ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "John practiced && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " " + ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.                       

        return false;
    }//method rehearsingOrRhearsed ends here.
////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean torturedAnimalsOrHumans(String lowerCasedText) {
        //check for  I've tortured && animals
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " " + ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.liveSpeciesRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //Joh has tortured && animals ............
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " has " + ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.liveSpeciesRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.                                      
        //Searching for "practiced killing animals
        for (int i = 0; i < ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; k++) {

                    if (lowerCasedText.contains(ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs[i]
                            + ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[j]
                            + lowerCasedText.contains(ArraysBagRehearsalModule.liveSpeciesRehearsal[k]))) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here. 
        //Searching for "tortured animals

        for (int i = 0; i < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; j++) {
                if (lowerCasedText.contains(ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[i] + " " + ArraysBagRehearsalModule.liveSpeciesRehearsal[j])
                        ) {
                 
                    return true;
                }

            }//loop i ends here.
        }//loop j ends here. 
        return false;
    }//method torturedAnimalsOrHumans ends here.
//////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean NegativeCasesRehearsal(String lowerCasedText) {
        //check for  "I'm NOT pracicing && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalContinuousVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " not " + ArraysBagRehearsalModule.rehearsalContinuousVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "John is NOT practicing && guns."
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalContinuousVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " is not " + ArraysBagRehearsalModule.rehearsalContinuousVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "I've NOT practiced && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " not " + ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for  "John HAS NOT practiced && guns"
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.weaponsRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " has not " + ArraysBagRehearsalModule.rehearsalPastAndPerfectVerbs[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.weaponsRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.                       

        //check for "I've NOT tortured && dogs"
        for (int i = 0; i < ArraysBagRehearsalModule.pronousAsSubjectRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; k++) {
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.pronousAsSubjectRehearsal[i] + " not " + ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.liveSpeciesRehearsal[k])) {
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.
        //check for "John HAS NOT tortured && dogs"
        for (int i = 0; i < ArraysBagRehearsalModule.popularNamesRehearsal.length; i++) {
            for (int j = 0; j < ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal.length; j++) {
                for (int k = 0; k < ArraysBagRehearsalModule.liveSpeciesRehearsal.length; k++) {
//                    System.out.print(" " + ArraysBagRehearsalModule.popularNames[i] + " has not " + ArraysBagRehearsalModule.torturedAnimalsVerbs[j]+" " + ArraysBagRehearsalModule.liveSpecies[k]);                    
                    if (lowerCasedText.contains(ArraysBagRehearsalModule.popularNamesRehearsal[i] + " has not " + ArraysBagRehearsalModule.torturedAnimalsVerbsRehearsal[j])
                            && lowerCasedText.contains(ArraysBagRehearsalModule.liveSpeciesRehearsal[k])) {
                        //System.out.print(ArraysBagRehearsalModule.popularNames[i] + " has not " + ArraysBagRehearsalModule.torturedAnimalsVerbs[j]+"   ");
                        return true;
                    }
                }//loop k ends here.
            }//loop j ends here.
        }//loop i ends here.                                      

        return false;
    }//method NegativeCasesRehearsal ends here.
//////////////////////////////////////////////////////////////////////////////////////////////////////     

     int threatLevelRehearsalOrPreacticeModule(String lowerCasedText) {

        int runningTotalRehearsalModule = 0;

        if (rehearsingOrRhearsed(lowerCasedText)) {
            runningTotalRehearsalModule += 8;//Not giving 9 as the text might have something like I'VE + then something here + PRACTICED tennis + then something + hate GUNS
            msg="The perpetrator migth have practiced or might be practicing some kind of weapons!!!!!!";
        }
        if (torturedAnimalsOrHumans(lowerCasedText)) {
            runningTotalRehearsalModule += 9;//Not giving 9 as the text might have something like I'VE + then something here + TARGETED the bulleye while practicing + then something + love DOGS           
            msg="The perpetrator might have tortured animals or humans!!!!!!";
        }
        if (NegativeCasesRehearsal(lowerCasedText)) {
            runningTotalRehearsalModule = 0;
            msg="The perpetrator might not have practised or might not be practicing some kind of weapons but we are not sure!";
        }
        //Determining the level        

        if (runningTotalRehearsalModule >= 9) {
            return 3;//High level
        } else if (runningTotalRehearsalModule < 9 && runningTotalRehearsalModule >= 6) {
            return 2;//Medium level
        } else if (runningTotalRehearsalModule < 6 && runningTotalRehearsalModule > 0) {
            return 1;//Low level
        } else {
            return 0;//No proof of rehearsal or practice
        }
    }//method threatLevelRehearsalOrPreacticeModule ends here.
}// class RehearsalOrPractice ends here 
