package MotiveDetectorPackage;

final class Motive {
    
    ArraysBagMotiveModule ArraysBagMotiveModule;

    public Motive(MotiveDetectorPackage.ArraysBagMotiveModule ArraysBagMotiveModule) {
        this.ArraysBagMotiveModule = ArraysBagMotiveModule;
    }

  private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }

    private  boolean loss(String lowerCasedText) {
        boolean res = false;
        int i = 0, k = 0;
        for (k = 0; k < ArraysBagMotiveModule.relationMotive.length; k++) {
            for (i = 0; i < ArraysBagMotiveModule.deathMotive.length; i++) {
                if (lowerCasedText.contains( ArraysBagMotiveModule.relationMotive[k]) && lowerCasedText.contains( ArraysBagMotiveModule.deathMotive[i])) {
                    res = true;

                }
            }
        }
        for (i = 0; i < ArraysBagMotiveModule.breakupMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.breakupMotive[i])) {
                res = true;

            }
        }
        return res;
    }

    private  boolean beingBullied(String lowerCasedText) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < ArraysBagMotiveModule.fightMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.fightMotive[i])) {
                res = true;

            }
        }
        for (i = 0; i < ArraysBagMotiveModule.bulliedMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.bulliedMotive[i])) {
                res = true;

            }
        }

        return res;
    }

    private  boolean beingExtremist(String lowerCasedText) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < ArraysBagMotiveModule.extremistsMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.extremistsMotive[i])) {
                res = true;

            }
        }
        for (i = 0; i < ArraysBagMotiveModule.martyrMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.martyrMotive[i])) {
                res = true;

            }
        }

        return res;
    }

    private  boolean hatred(String lowerCasedText) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < ArraysBagMotiveModule.hatesMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.hatesMotive[i])) {
                res = true;

            }
        }
        for (i = 0; i < ArraysBagMotiveModule.groupMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.groupMotive[i]) && lowerCasedText.contains( "hatred for")) {
                res = true;

            }
        }
        return res;
    }

    private  boolean checkForRevenge(String lowerCasedText) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < ArraysBagMotiveModule.RevengeMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.RevengeMotive[i])) {
                res = true;

            }
        }

        return res;
    }

    private  boolean checkForFantasies(String lowerCasedText) {
        int i = 0;
        boolean res = false;
        for (i = 0; i < ArraysBagMotiveModule.ideologyMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.ideologyMotive[i])) {
                res = true;

            }
        }
        return res;
    }

    private  boolean checkForDepression(String lowerCasedText) {
        boolean res = false;
        int i = 0, k = 0;
        for (i = 0; i < ArraysBagMotiveModule.depMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.depMotive[i])) {
                res = true;

            }
        }
        for (k = 0; k < ArraysBagMotiveModule.havesMotive.length; k++) {
            if (lowerCasedText.contains( "don't " + ArraysBagMotiveModule.havesMotive[k] + " money")
                    || lowerCasedText.contains( "don't " + ArraysBagMotiveModule.havesMotive[k] + " cash")
                    || lowerCasedText.contains( "don't " + ArraysBagMotiveModule.havesMotive[k] + " any money")
                    || lowerCasedText.contains( "don't " + ArraysBagMotiveModule.havesMotive[k] + " any cash")
                    || lowerCasedText.contains( ArraysBagMotiveModule.havesMotive[k] + " no money")
                    || lowerCasedText.contains( ArraysBagMotiveModule.havesMotive[k] + " no cash")) {
                res = false;

            }
        }
        //wrong logic below by the programmer ?????????? 
        if (lowerCasedText.contains( "moneyless") || lowerCasedText.contains( "penniless") || lowerCasedText.contains( "out of moneney")
                || lowerCasedText.contains( "out of cash") || lowerCasedText.contains( "no money") || lowerCasedText.contains( "no cash")) {
            res = false;
        }
        return res;
    }

    private  boolean checkForFailures(String lowerCasedText) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < ArraysBagMotiveModule.failMotive.length; i++) {
            if (lowerCasedText.contains( ArraysBagMotiveModule.failMotive[i])) {
                res = true;

            }
        }
        return res;
    }

     int threatLevelMotiveModule(String lowerCasedText) {

        int loss = 5, beingBullied = 9, beingExtremist = 4, hatred = 9, checkForRevenge = 7, checkForFantasies = 3, checkForDepression = 7, checkForFailures = 6;

        int runningTotalMotiveModule = 0;

        if (beingBullied(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + beingBullied;
            msg="The perpetrator might have been bullied!";
        }
        if (hatred(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + hatred;
            msg="Hatred related words found!";
        }
        if (checkForDepression(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + checkForDepression;
            msg="The perpetrator might have depression related problems!";
        }
        if (checkForRevenge(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + checkForRevenge;
            msg="The perpetrator might be planning a revenge!";
        }
        if (checkForFailures(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + checkForFailures;
            msg="The perpetrator might have faced failures in life!";
        }
        if (loss(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + loss;
            msg="The perpetrators might have lost a near relative or might have had break up in relations!";
        }
        if (beingExtremist(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + beingExtremist;
            msg="The perpetrator might have been related to extremist ideas!";
        }
        if (checkForFantasies(lowerCasedText)) {
            runningTotalMotiveModule = runningTotalMotiveModule + checkForFantasies;
            msg="The perpetrator might be involved in Satanism or other dangeous fantasies!";
        }        
        //Determine the class of the threat at this submoudle level 
        if (runningTotalMotiveModule >= 18) {
            runningTotalMotiveModule = 3;//Set runningTotalMotiveModule to high level
        } else if (runningTotalMotiveModule < 18 && runningTotalMotiveModule > 9) {
            runningTotalMotiveModule = 2;//set runningTotalMotiveModule to medium level
        } else if (runningTotalMotiveModule <= 9 && runningTotalMotiveModule > 0) {
            runningTotalMotiveModule = 1;//set runningTotalMotiveModule to low level
        } else {
            runningTotalMotiveModule = 0;//set runningTotalMotiveModule to no threat
        }        
        return runningTotalMotiveModule;
    }
}
