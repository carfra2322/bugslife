package uis;





public class Scouts extends Ant {



    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Scouts(EnvironmentNode envNode) {

        super(envNode);
        System.out.println("Scout HATCHED");


    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------



    public void attack(){

    };


    @Override
    public void move()
    {


        System.out.println(")(*)(&)(*&)(*&)(&)(*&)(*&)(*&)(*&)(&)(");
        ArrayList neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);

        int size = MainDriver.rand.nextInt(neighbors.size());
        System.out.println("Size of neighbors " + size);

        //System.out.println("New neighboring number is " + Math.random());
        currentLocation.removeAnt(this);
        currentLocation = (EnvironmentNode ) neighbors.get(size);
        currentLocation.addAnt(this);

        if(currentLocation.isVisible()==false){
            currentLocation.setVisible(true);
        }


    };
}
