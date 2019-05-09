package uis;

public class EnvironmentNodeCopy extends ColonyNodeView{

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------


    Map antRoster;
    Map ForagersRoster;
    Map ScoutsRoster;
    Map SoldierRoster;
    Map BalaRoster;
    String envNodeID;
    String uniqueID;

    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public EnvironmentNodeCopy() {
        ForagersRoster = new HashMap();
        ScoutsRoster = new HashMap();
        SoldierRoster = new HashMap();
        BalaRoster = new HashMap();
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    /**
     * This method adds the ants to a map
     * */
    public void addAnt(Ant myAnt){

        System.out.println("Entering AddAnt function");

        System.out.println("Key: " + uniqueID);

        if(myAnt.getClass().getSimpleName().compareTo("Foragers")==0){
            System.out.println("Forager added");
            this.ForagersRoster.add(uniqueID, myAnt);
        }

        if(myAnt.getClass().getSimpleName().compareTo("Scouts")==0){
            System.out.println("Scout added");
            this.ScoutsRoster.add(uniqueID, myAnt);
        }

        if(myAnt.getClass().getSimpleName().compareTo("Soldier")==0){
            System.out.println("Soldier added");
            this.SoldierRoster.add(uniqueID, myAnt);
        }

        if(myAnt.getClass().getSimpleName().compareTo("Bala")==0){
            System.out.println("Bala added");
            this.BalaRoster.add(uniqueID, myAnt);
        }

        System.out.println("Bala roster size " + BalaRoster.size());



    }


    public void updateEnvNode(){


    }





}
