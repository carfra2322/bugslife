package uis;

public class Queen extends Ant {

    int IDcount;
    int hatchProbability;




    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------
    public Queen(EnvironmentNode envNode) {
        super(envNode);
        //LifeSpan = LifeSpan*20;
        LifeSpan = LifeSpan/10;
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

        if(hatchProbability>49 && hatchProbability<74) {
            Scouts myScout = new Scouts(currentLocation);
            myScout.ID = getIDcount() + 1;
            currentLocation.addAnt(myScout);
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


