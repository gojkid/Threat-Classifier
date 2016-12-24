//Target module methods and determination of category at this submodule level.
package TargetDetectorPackage;

final class Target {

    public Target(TargetDetectorPackage.ArraysBagTargetModule ArraysBagTargetModule) {
        this.ArraysBagTargetModule = ArraysBagTargetModule;
    }

 private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    ArraysBagTargetModule ArraysBagTargetModule;
    
    private  boolean targetWithRevenge(String lowerCasedText) {

        for (int i = 0; i < ArraysBagTargetModule.RevengeTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.phrasesIncludingTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.phrasesIncludingTarget[j])) {
                    return true;
                }
            }
        }
        String t1 = "class ", t2 = "class ";

        for (int i = 1; i < ArraysBagTargetModule.RevengeTarget.length; i++) {
            for (int j = 1; j < 12; j++) {
                t1 = t1 + j;
                t2 = t2 + ArraysBagTargetModule.cardinalNumbersTarget[j];
                if ((lowerCasedText.contains(t1) && lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[i])) || ((lowerCasedText.contains(t2) && lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[i])))) {
                    return true;
                }
            }
        }
        return false;
    }// method targetWithRevenge ends here.    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    private  boolean targetWithKillFight(String lowerCasedText) {

        for (int i = 0; i < ArraysBagTargetModule.fightTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.phrasesIncludingTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.fightTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.phrasesIncludingTarget[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.killTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.phrasesIncludingTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.killTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.phrasesIncludingTarget[j])) {
                    return true;
                }
            }
        }
        String t1 = "class ", t2 = "class ";
        for (int i = 1; i < ArraysBagTargetModule.killTarget.length; i++) {
            for (int j = 1; j < 12; j++) {
                t1 = t1 + j;
                t2 = t2 + ArraysBagTargetModule.cardinalNumbersTarget[j];
                if ((lowerCasedText.contains(t1) && lowerCasedText.contains(ArraysBagTargetModule.killTarget[i])) || ((lowerCasedText.contains(t2) && lowerCasedText.contains(ArraysBagTargetModule.killTarget[i])))) {
                    return true;
                }
            }
        }
        for (int i = 1; i < ArraysBagTargetModule.fightTarget.length; i++) {
            for (int j = 1; j < 12; j++) {
                t1 = t1 + j;
                t2 = t2 + ArraysBagTargetModule.cardinalNumbersTarget[j];
                if ((lowerCasedText.contains(t1) && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[i])) || ((lowerCasedText.contains(t2) && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[i])))) {
                    return true;
                }
            }
        }
        return false;
    }// method targetWithKillFight ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//Targetting one or two persons with proof of revenge

    private  boolean targetRevengeOneOrFew(String lowerCasedText) {
        for (int i = 0; i < ArraysBagTargetModule.RevengeTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.targetIndicatingFewPersons.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.targetIndicatingFewPersons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.RevengeTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.popularNamesTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.popularNamesTarget[j])) {
                    return true;
                }
            }
        }

        return false;
    }// method targetWithRevenge ends here.    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//Targetting one or two persons without proof of revenge

    private  boolean targetWithKillFightOneOrFew(String lowerCasedText) {

        for (int i = 0; i < ArraysBagTargetModule.fightTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.targetIndicatingFewPersons.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.fightTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.targetIndicatingFewPersons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.fightTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.popularNamesTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.fightTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.popularNamesTarget[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.subjectsTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.killTarget.length; j++) {
                if ((lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "teacher") && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j]))
                        || (lowerCasedText.contains("teacher of " + ArraysBagTargetModule.subjectsTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "sir") && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "maam") && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "miss") && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j]))) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.subjectsTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.fightTarget.length; j++) {
                if ((lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "teacher") && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j]))
                        || (lowerCasedText.contains("teacher of " + ArraysBagTargetModule.subjectsTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "sir") && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "maam") && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j]))
                        || (lowerCasedText.contains(ArraysBagTargetModule.subjectsTarget[i] + "miss") && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j]))) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.killTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.targetIndicatingFewPersons.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.killTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.targetIndicatingFewPersons[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.killTarget.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.popularNamesTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.killTarget[i]) && lowerCasedText.contains(ArraysBagTargetModule.popularNamesTarget[j])) {
                    return true;
                }
            }
        }
        return false;
    }// method targetWithKillFight ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
//Check if the perpetrator has been observing a few targets and target's routine and words fightTarget and killTarget.

    private  boolean knowledgeAboutTargetFewKillFight(String lowerCasedText) {

        for (int i = 0; i < ArraysBagTargetModule.knowledgeFewTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.fightTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeFewTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.knowledgeFewTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.killTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeFewTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j])) {
                    return true;
                }
            }
        }
        return false;
    }// method knowledgeAboutTarget ends here.
//////////////////////////////////////////////////////////////////////////////////////    
//Check if the perpetrator has been observing target more than  a few with words killTarget and fig´ht in text and target's routine.

    private  boolean knowledgeAboutTargetMoreKillFight(String lowerCasedText) {

        for (int i = 0; i < ArraysBagTargetModule.knowledgeMoreTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.fightTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeMoreTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.fightTarget[j])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ArraysBagTargetModule.knowledgeMoreTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.killTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeMoreTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.killTarget[j])) {
                    return true;
                }
            }
        }
        return false;
    }// method knowledgeAboutTarget ends here.
//////////////////////////////////////////////////////////////////////////////////////    
//Check if the perpetrator has been observing target that are one or a few and target's routine with revenge.

    private  boolean knowledgeAboutTargetRevengeFew(String lowerCasedText) {
        for (int i = 0; i < ArraysBagTargetModule.knowledgeFewTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.RevengeTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeFewTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[j])) {
                    return true;
                }
            }
        }
        return false;
    }// method knowledgeAboutTarget ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//Check if the perpetrator has been observing target more than few and target's routine with revenge as motive.

    private  boolean knowledgeAboutTargetRevengeMore(String lowerCasedText) {
        for (int i = 0; i < ArraysBagTargetModule.knowledgeMoreTargets.length; i++) {
            for (int j = 0; j < ArraysBagTargetModule.RevengeTarget.length; j++) {
                if (lowerCasedText.contains(ArraysBagTargetModule.knowledgeMoreTargets[i]) && lowerCasedText.contains(ArraysBagTargetModule.RevengeTarget[j])) {
                    return true;
                }
            }
        }
        return false;
    }// method knowledgeAboutTarget ends here.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     int threatLevelTargetModule(String lowerCasedText) {
        int runningTotalTargetModule = 0;

        if (knowledgeAboutTargetRevengeMore(lowerCasedText)) {
            runningTotalTargetModule += 10;
            msg="The perpetrator might be observing or following the vitim(s)!";
        }
        if (targetWithRevenge(lowerCasedText)) {
            runningTotalTargetModule += 9;
            msg="The perpetrator might be targetting more than one person to take revenge!";
        }

        if (knowledgeAboutTargetMoreKillFight(lowerCasedText)) {
            runningTotalTargetModule += 9;
            msg="The perpetrator might be following or observing the routine of more than one person!";
        }
        if (targetWithKillFight(lowerCasedText)) {
            runningTotalTargetModule += 8;
            msg="The perpetrator might be planning to killTarget or fightTarget with mroe than one person!";
        }

        if (knowledgeAboutTargetRevengeFew(lowerCasedText)) {
            runningTotalTargetModule += 5;
             msg="The perpetrator might be observing or following one or a few person(s)!";
        }
        if (targetRevengeOneOrFew(lowerCasedText)) {
            runningTotalTargetModule += 4;
             msg="The perpetrator might be targetting one or a few person(s) to take revenge!";
        }
        if (knowledgeAboutTargetFewKillFight(lowerCasedText)) {
            runningTotalTargetModule += 4;
              msg="The perpetrator might be following or observing the routine of one or a few person(s)!";
        }
        if (targetWithKillFightOneOrFew(lowerCasedText)) {
            runningTotalTargetModule += 3;
            msg="The perpetrator might be planning to killTarget or fightTarget with oen or a few persons!";
        }
//Deciding the 3, 2, 1 score
        if(runningTotalTargetModule >= 9)
            return 3;//High category
        else if(runningTotalTargetModule < 9 && runningTotalTargetModule >= 6)
            return 2;//Medium category
        else if (runningTotalTargetModule < 6 && runningTotalTargetModule >0)
            return 1;//Low category
        else
            return 0;//No target found in the text of the threat.        
    }//method threatLevelTargetModule ends here.
}//class Target ends here.
