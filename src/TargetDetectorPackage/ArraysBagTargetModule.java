/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TargetDetectorPackage;

/**
 *
 * @author admin
 */
public class ArraysBagTargetModule {
  
     String RevengeTarget[];
     
  String phrasesIncludingTarget[];
      
  
  String targetIndicatingFewPersons[];
   
    String fightTarget[];
       
      String killTarget[];
      
      String cardinalNumbersTarget[];
       
      String knowledgeFewTargets[];
        
      String knowledgeMoreTargets[];
       
      String subjectsTarget[];
     
      String popularNamesTarget[];

      //setters for the above arrays. The setters are used to set the values of the arrays from the database.
    public void setRevengeTarget(String[] RevengeTarget) {
        this.RevengeTarget = RevengeTarget;
    }

    public void setCardinalNumbersTarget(String[] cardinalNumbersTarget) {
        this.cardinalNumbersTarget = cardinalNumbersTarget;
    }

    public void setFightTarget(String[] fightTarget) {
        this.fightTarget = fightTarget;
    }

    public void setKillTarget(String[] killTarget) {
        this.killTarget = killTarget;
    }

    public void setKnowledgeFewTargets(String[] knowledgeFewTargets) {
        this.knowledgeFewTargets = knowledgeFewTargets;
    }

    public void setKnowledgeMoreTargets(String[] knowledgeMoreTargets) {
        this.knowledgeMoreTargets = knowledgeMoreTargets;
    }

    public void setPhrasesIncludingTarget(String[] phrasesIncludingTarget) {
        this.phrasesIncludingTarget = phrasesIncludingTarget;
    }

    public void setPopularNamesTarget(String[] popularNamesTarget) {
        this.popularNamesTarget = popularNamesTarget;
    }

    public void setSubjectsTarget(String[] subjectsTarget) {
        this.subjectsTarget = subjectsTarget;
    }

    public void setTargetIndicatingFewPersons(String[] targetIndicatingFewPersons) {
        this.targetIndicatingFewPersons = targetIndicatingFewPersons;
    }

}
