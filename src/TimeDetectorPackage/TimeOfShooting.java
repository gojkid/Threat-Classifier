package TimeDetectorPackage;

import java.util.Calendar;

final class TimeOfShooting {

    public TimeOfShooting(TimeDetectorPackage.ArraysBagTimeModule ArraysBagTimeModule) {
        this.ArraysBagTimeModule = ArraysBagTimeModule;
    }

    private String msg="";//Used to store the message that was previously being printed to the console

    public String getMsg() {
        return msg;
    }

    ArraysBagTimeModule ArraysBagTimeModule;
    
     int EXACT_HOURS_AND_MINUTES = 9, LIKE_EXACT_HOURS_AND_MINUTES = 9, PART_OF_DAY = 8, EXACT_DAY_OR_DATE = 7, ONLY_WEEK = 3, ONLY_MONTH = 2, ONLY_YEAR = 1;
     String separator[] = {"//", "\\", ".", ",", " ", "|", "-", "_", "~"};

    private  boolean exactHoursAndMinutes(String text) {
        boolean res = false;

        //Checking the civilian time
        for (int i = 0; i < ArraysBagTimeModule.civilianTime.length; i++) {
            if (string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "am"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "pm"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "AM"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "PM"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "a.m"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "p.m"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "A.M"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "P.M"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "a.m."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "p.m."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "A.M."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "P.M."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "am."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "pm."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "AM."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "PM."))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "CEST"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "CEWT"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "cest"))
                    || string.contains(text, (ArraysBagTimeModule.civilianTime[i] + " " + "cewt"))) {

                res = true;
            }
        }
        //Checking the military time
        for (int i = 0; i < ArraysBagTimeModule.militaryTime.length; i++) {
            if (string.contains(text, (ArraysBagTimeModule.militaryTime[i] + " " + "hours"))
                    || string.contains(text, (ArraysBagTimeModule.militaryTime[i] + " " + "hrs."))
                    || string.contains(text, (ArraysBagTimeModule.militaryTime[i] + " " + "Hours"))
                    || string.contains(text, (ArraysBagTimeModule.militaryTime[i] + " " + "hr."))) {

                res = true;
            }
        }       
        return res;
    }
////////////////////////////////////////////////////////////////////////////////////////////
    private  boolean likeExactTime(String text) {
        //today , after some time, immediately etc.
        for (int i = 0; i < ArraysBagTimeModule.todayTime.length; i++) {
            if (string.contains(text, ArraysBagTimeModule.todayTime[i])) {
                return true;
            }
        }
        return false;
    }
////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean partOfDay(String text) {
        boolean res = false;
        int i = 0, j = 0, k = 0;
        for (i = 0; i < ArraysBagTimeModule.lunchTime.length; i++) {
            for (j = 0; j < ArraysBagTimeModule.prepositionOfTime.length; j++) {
                if (string.contains(text, ArraysBagTimeModule.prepositionOfTime[j] + " " + ArraysBagTimeModule.lunchTime[i])) {
                    res = true;

                }
            }
        }
        for (i = 0; i < ArraysBagTimeModule.wordsForCheckinPartOfTheDayTime.length; i++) {
            for (j = 0; j < ArraysBagTimeModule.prepositionOfTime.length; j++) {
                if (string.contains(text, ArraysBagTimeModule.prepositionOfTime[j] + " " + ArraysBagTimeModule.wordsForCheckinPartOfTheDayTime[i])
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[j] + " " + "the" + " " + ArraysBagTimeModule.wordsForCheckinPartOfTheDayTime[i])) {
                    res = true;

                }
            }
        }
        for (k = 0; k < ArraysBagTimeModule.prepositionOfTime.length; k++) {
            for (i = 0; i < 16; i++) {
                if (string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.cardinalNumbersTime[i] + " period")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + ArraysBagTimeModule.cardinalNumbersTime[i] + " period")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.cardinalNumbersTime[i] + " lesson")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + ArraysBagTimeModule.cardinalNumbersTime[i] + " lesson")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.cardinalNumbersTime[i] + " lecture")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + ArraysBagTimeModule.cardinalNumbersTime[i] + " lecture")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.cardinalNumbersTime[i] + " paper")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + ArraysBagTimeModule.cardinalNumbersTime[i] + " paper")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.cardinalNumbersTime[i] + " class")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + ArraysBagTimeModule.cardinalNumbersTime[i] + " class")) {
                    res = true;

                }
            }
            for (i = 0; i < ArraysBagTimeModule.subjectsTime.length; i++) {
                if (string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " period")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + " " + ArraysBagTimeModule.subjectsTime[i] + " period")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " lesson")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + " " + ArraysBagTimeModule.subjectsTime[i] + " lesson")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " class")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the" + " " + ArraysBagTimeModule.subjectsTime[i] + " class")) {
                    res = true;

                }
            }
            for (i = 0; i < ArraysBagTimeModule.subjectsTime.length; i++) {
                if (string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " period")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the " + "period " + "of " + ArraysBagTimeModule.subjectsTime[i])
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " lesson")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the " + "lesson " + "of " + ArraysBagTimeModule.subjectsTime[i])
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.subjectsTime[i] + " class")
                        || string.contains(text, ArraysBagTimeModule.prepositionOfTime[k] + " " + "the " + "class " + "of " + ArraysBagTimeModule.subjectsTime[i])) {
                    res = true;

                }
            }
        }

        return res;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean exactDayOrDate(String text) {
        boolean res = false;
        int t = 0;
        int i = 0, j = 0, k = 0, l = 0;
        String date[] = new String[13392];
        for (i = 1; i <= 12; i++) {
            for (j = 1; j <= 31; j++) {
                for (k = Calendar.getInstance().get(Calendar.YEAR); k < Calendar.getInstance().get(Calendar.YEAR) + 3; k++) {
                    for (l = 0; l < separator.length; l++) {
                        if (i > 10 && j > 10) {
                            date[t] = (i + separator[l] + j + separator[l] + k);
                        } else if (i < 10 && j < 10) {
                            date[t] = ("0" + i + separator[l] + "0" + j + separator[l] + k);
                        } else if (i < 10 && j > 10) {
                            date[t] = ("0" + i + separator[l] + j + separator[l] + k);
                        } else if (i > 10 && j < 10) {
                            date[t] = (i + separator[l] + "0" + j + separator[l] + k);
                        }
                        t++;
                    }
                }
            }
        }


        for (i = 0; i < date.length; i++) {
            if (date[i] != null) {
                if (string.contains(text, date[i])) {
                    res = true;

                }
            }
        }

        for (k = 0; k < ArraysBagTimeModule.cardinalNumbersTime.length; k++) {
            for (i = 0; i < ArraysBagTimeModule.monthsTime.length; i++) {
                if (string.contains(text, ArraysBagTimeModule.cardinalNumbersTime[k] + " " + ArraysBagTimeModule.monthsTime[i]) || string.contains(text, ArraysBagTimeModule.cardinalNumbersTime[k] + " of " + ArraysBagTimeModule.monthsTime[i]) || string.contains(text, ArraysBagTimeModule.monthsTime[i] + " " + ArraysBagTimeModule.cardinalNumbersTime[k]) || string.contains(text, (k + 1) + " " + ArraysBagTimeModule.monthsTime[i]) || string.contains(text, ArraysBagTimeModule.monthsTime[i] + " " + (k + 1))) {
                    res = true;
                }
            }
        }


        for (k = 0; k < ArraysBagTimeModule.prepositionOfTime.length; k++) {
            for (i = 0; i < ArraysBagTimeModule.weekdayTime.length; i++) {
                if (string.contains(text, (ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.weekdayTime[i]))
                        || string.contains(text, (ArraysBagTimeModule.prepositionOfTime[k] + " the " + ArraysBagTimeModule.weekdayTime[i]))) {
                    res = true;
                }
            }
        }
        return res;
    }
////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean onlyWeek(String text) {
        boolean res = false;
        int i = 0, k = 0;
        for (i = 0; i < ArraysBagTimeModule.weekTime.length; i++) {
            if (string.contains(text, ArraysBagTimeModule.weekTime[i])) {
                res = true;

            }
        }
        for (k = 0; k < 10; k++) {
            for (i = 0; i < ArraysBagTimeModule.monthsTime.length; i++) {
                if (string.contains(text, ArraysBagTimeModule.cardinalNumbersTime[k] + " weekTime of " + ArraysBagTimeModule.monthsTime[i])) {
                    res = true;
                }
            }
        }

        return res;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean onlyMonth(String text) {
        boolean res = false;
        int i, j, k;

        for (k = 0; k < ArraysBagTimeModule.prepositionOfTime.length; k++) {
            for (i = 0; i < ArraysBagTimeModule.monthsTime.length; i++) {

                if (string.contains(text, (ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.monthsTime[i]))) {
                    res = true;
                }
            }
        }

        //check for monthsTime of this year only.
        int curr_year = Calendar.getInstance().get(Calendar.YEAR);
        for (i = 0; i < 24; i++) {//24 because the first 24 entries of cardinal_Numbers contains first, 1st ....12th, twelfth

            if (string.contains(text, ArraysBagTimeModule.monthsTime[i] + " " + curr_year)
                    || string.contains(text, ArraysBagTimeModule.cardinalNumbersTime[i] + " month of " + curr_year)) {
                res = true;
            }

        }
        for (k = 0; k < ArraysBagTimeModule.prepositionOfTime.length; k++) {
            for (i = 0; i < ArraysBagTimeModule.seasonTime.length; i++) {

                if (string.contains(text, (ArraysBagTimeModule.prepositionOfTime[k] + " " + ArraysBagTimeModule.seasonTime[i]))) {
                    res = true;
                }
            }
        }
        return res;
    }
//////////////////////////////////////////////////////////////////////////////////////////////

    private  boolean onlyYear(String text) {
        String year[] = new String[20];
        boolean res = false;

        if (string.contains(text, "this year") || string.contains(text, "next year")) {
            res = true;
        }
        int curr_year = Calendar.getInstance().get(Calendar.YEAR);

        //Checking 5 years only including the current year.
        for (int i = 0; i < 5; i++) {
            year[i] = "" + curr_year++;
        }

        for (int i = 0; i < 5; i++) {
            if (string.contains(text, year[i])) {
                res = true;
            }
        }
        return res;
    }
/////////////////////////////////////////////////////////////////////////////////////

     int threatLevelTimeModule(String text) {

        int runningTotalTimeModule = 0;

        if (exactHoursAndMinutes(text)) {
            runningTotalTimeModule = runningTotalTimeModule + EXACT_HOURS_AND_MINUTES;
            msg="The perpetrator might have exact time in mind to launch some kind of attack!";
        }
         if (likeExactTime(text)) {
            runningTotalTimeModule = runningTotalTimeModule + LIKE_EXACT_HOURS_AND_MINUTES;
            msg="The perpetrator might have approximately exact time in mind to launch some kind of attack!";
        }
        
        if (partOfDay(text)) {
            runningTotalTimeModule = runningTotalTimeModule + PART_OF_DAY;
            msg="The perpetrator might have decided which part of the day is suitable for the attack!";
        }
        if (exactDayOrDate(text)) {
            runningTotalTimeModule = runningTotalTimeModule + EXACT_DAY_OR_DATE;
            msg="The perpetrator might have decided an exact day or date for the attack!";
        }
        if (onlyWeek(text)) {
            runningTotalTimeModule = runningTotalTimeModule + ONLY_WEEK;
            msg="The perpetrator might have decided the weekTime in which (s)he might launch some kind of attack!";
        }
        if (onlyMonth(text)) {
            runningTotalTimeModule = runningTotalTimeModule + ONLY_MONTH;
           msg="The perpetrator might have decided the month in which (s)he might launch some kind of attack!";
        }
        if (onlyYear(text)) {
            runningTotalTimeModule = runningTotalTimeModule + ONLY_YEAR;
            msg="The perpetrator might have decided the year in which (s)he might launch some kind of attack!";
        }
//Determine the class of the threat at this submoudle level 
        if (runningTotalTimeModule >= 10) {//10 out of 30. Since 9 is the highest score, we don't want just sepecific time to retun High level
            return 3;//high level
        } else if (runningTotalTimeModule < 10 && runningTotalTimeModule >= 6) {
            return 2;// medium level
        } else if (runningTotalTimeModule < 6 && runningTotalTimeModule > 0) {
            return 1;// low level
        } else {
            return 0;//no threat
        }                
    }//method threatLevelTimeModule ends here.
}//class TimeOfShooting ends here.