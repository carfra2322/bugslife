package uis;
import java.util.UUID;

public class EnvironmentNode extends ColonyNodeView{

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------


    Map antRoster;
    Map foragerRoster;
    Map scoutRoster;
    Map soldierRoster;
    Map balaRoster;
    Map queenRoster;
    String envNodeID;
    String uniqueID;
    boolean isQueenAlive;
    Queen myQueen;
    //Bala myBala;
    //Scouts myScout;
    //Soldier mySoldier;
    //Foragers myForager;
    int row;
    int col;
    Environment environment;



    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public EnvironmentNode(int x, int y) {
        this.row = x;
        this.col =y;
        antRoster = new HashMap();
        foragerRoster = new HashMap();
        scoutRoster = new HashMap();
        soldierRoster = new HashMap();
        balaRoster = new HashMap();
        queenRoster = new HashMap();

    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    /**
     * This method adds the ants to a map
     * */
    public void addAnt(Ant myAnt){

        //System.out.println("Entering AddAnt function");



        if(myAnt.getClass().getSimpleName().compareTo("Foragers")==0){
            this.foragerRoster.add(myAnt.ID, myAnt);
        }
        else if(myAnt.getClass().getSimpleName().compareTo("Scouts")==0){
            this.scoutRoster.add(myAnt.ID, myAnt);
        }
        else if(myAnt.getClass().getSimpleName().compareTo("Soldier")==0){
            this.soldierRoster.add(myAnt.ID, myAnt);
        }
        else if(myAnt.getClass().getSimpleName().compareTo("Bala")==0){
            this.balaRoster.add(myAnt.ID, myAnt);
        }
        else if(myAnt.getClass().getSimpleName().compareTo("Queen")==0){
            myQueen = new Queen(this);
            myQueen.setAlive(true);
            this.setQueen(true);
            this.showQueenIcon();
            //myAnt.Alive = true;
        }





        //System.out.println("Forager roster size " + foragerRoster.size());
        //System.out.println("Scout roster size " + scoutRoster.size());
        //System.out.println("soldier roster size " + soldierRoster.size());
        //System.out.println("Bala roster size " + balaRoster.size());



    }

    public void removeAnt( Ant antToRemove){
        if(antToRemove.getClass().getSimpleName().compareTo("Foragers")==0){
            foragerRoster.remove(antToRemove.ID);
        }
        else if(antToRemove.getClass().getSimpleName().compareTo("Scouts")==0){
            scoutRoster.remove(antToRemove.ID);
        }
        else if(antToRemove.getClass().getSimpleName().compareTo("Soldier")==0){
            soldierRoster.remove(antToRemove.ID);
        }
        else if(antToRemove.getClass().getSimpleName().compareTo("Bala")==0){
            balaRoster.remove(antToRemove.ID);
        }

    }


    public void updateEnvNode(){
        this.setBalaCount(balaRoster.size());
        this.setScoutCount(scoutRoster.size());
        this.setForagerCount(foragerRoster.size());
        this.setSoldierCount(soldierRoster.size());
        //this.showSoldierIcon();
        //this.showForagerIcon();
        //this.showScoutIcon();
        //this.showBalaIcon();


        if(balaRoster.size()>0){
            this.showBalaIcon();

        }
        if(scoutRoster.size()>0){
            //System.out.println("Entered show scout function");

            List rosterList = scoutRoster.keyList();
            for(int i=0; i<scoutRoster.size(); i++){
                Scouts tempScout = ((Scouts) scoutRoster.get(rosterList.get(i)));
                tempScout.move();
                tempScout.LifeSpan = tempScout.getLifeSpan()-1;

                if(tempScout.getLifeSpan()<1){
                    this.removeAnt(tempScout);
                }

            }
            this.showScoutIcon();
            this.showNode();

        }
        else if (scoutRoster.size()==0){
            //System.out.println("hidding SCOUT ==================================");
            this.hideScoutIcon();
        }
        try{
            if(foragerRoster.size()>0){
                this.showForagerIcon();
                System.out.println("Entered show forager function");

                List rosterList = foragerRoster.keyList();
                for(int i=0; i<rosterList.size(); i++){
                    Foragers tempForager = ((Foragers) foragerRoster.get(rosterList.get(i)));
                    tempForager.move();
                    tempForager.LifeSpan = tempForager.getLifeSpan()-1;

                    if(tempForager.getLifeSpan()<1){
                        this.removeAnt(tempForager);
                    }

                }

            }
            else if (foragerRoster.size()==0){
                System.out.println("hidding FORAGER ==================================");
                this.hideForagerIcon();
            }
        }
        catch(Exception e){};


        if(soldierRoster.size()>0){
            this.showSoldierIcon();
            //System.out.println("Entered show soldiers function");
        }
//        if(myQueen.Alive){
//            this.showQueenIcon();
//            this.setQueen(true);
//        }

    }




    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
