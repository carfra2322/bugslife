package uis;

public class Queen extends Ant {

    int IDcount;
    int hatchProbability;




    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------
    public Queen(EnvironmentNode envNode) {
        super(envNode);
        LifeSpan = LifeSpan*20;
        //LifeSpan = LifeSpan/10;
        IDcount = 0;


    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------


    //hatches new ant
    public void hatch(){



        hatchProbability = MainDriver.rand.nextInt(100);
        if(hatchProbability<=49)
        {
            Foragers myForager = new Foragers(currentLocation);
            myForager.ID = getIDcount()+1;
            currentLocation.addAnt(myForager);
        }

        else if(hatchProbability>49 && hatchProbability<74) {
            Scouts myScout = new Scouts(currentLocation);
            myScout.ID = getIDcount() + 1;
            currentLocation.addAnt(myScout);
        }
        else if(hatchProbability>74){
            Soldier mySoldier = new Soldier(currentLocation);
            mySoldier.ID = getIDcount() + 1;
            currentLocation.addAnt(mySoldier);
        }
        if(hatchProbability<3){

            Bala myBala = new Bala(currentLocation.environment.myEnvNodeList[0][0]);
            myBala.ID = getIDcount() + 1;
            //myBala.currentLocation.addAnt(myBala);
            (currentLocation.environment.myEnvNodeList[0][0]).addAnt(myBala);

        }

        setIDcount(getIDcount()+1);

    }

    public void setIDcount(int theCount){
        IDcount = theCount;
    }

    public int getIDcount(){
        return IDcount;
    }

}


