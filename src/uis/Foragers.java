package uis;

public class Foragers extends Ant {

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

   boolean forageMode;
   boolean hasFood;
   ListGraph movementHistory;

    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Foragers(EnvironmentNode envNode) {
        super(envNode);
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void move()
    {

    };

    public void pickUpFood(){};

    public void setFoodSupply()
    {

    };


    public void checkPhermone(){};

    public void setPhermone(){};

    public void setMoveHistory(){};

    public void clearMoveHistory(){};

}
