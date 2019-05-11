package uis;

public class Ant {


    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

    int ID;
    int LifeSpan;
    Boolean Alive;
    String type;
    EnvironmentNode currentLocation;


    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------
    public Ant(EnvironmentNode envNode){
        //Every ant has a life span of 1 year (1 day = 10 turns)
        //365 days * 10 will give us lifespan in turns
        this.currentLocation = envNode;
        LifeSpan = 365 * 10;
        //LifeSpan = 100;
        Alive = true;

    }

    public Ant(){}



    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------
    public void move(){


    }

    public void eat()
    {

        currentLocation.setFoodAmount(currentLocation.foodAmount-1);
        if (currentLocation.foodAmount==0){
            Alive =false;
        }

    }
    public void enterColony(){

    }

    public int getID() {
        return ID;
    }


    public int getLifeSpan() {
        return LifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        LifeSpan = lifeSpan;
    }

    public Boolean getAlive() {
        return Alive;
    }

    public void setAlive(Boolean alive) {
        Alive = alive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
