package uis;

public class Bala extends Ant {

    int killprobability = 100;

    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Bala(EnvironmentNode envNode) {
        super(envNode);
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void EnterColony()
    {

    };

    public void move()
    {
        ArrayList neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);

        int size = MainDriver.rand.nextInt(neighbors.size());
        //System.out.println("Size of neighbors " + size);

        //System.out.println("New neighboring number is " + Math.random());
        currentLocation.removeAnt(this);
        currentLocation = (EnvironmentNode ) neighbors.get(size);

        currentLocation.addAnt(this);

        if(currentLocation.soldierRoster.size() > 0)
        {
            attack("soldier");
        }
        else if(currentLocation.foragerRoster.size() >0)
        {
            attack("forage");
        }
        else if(currentLocation.scoutRoster.size()>0)
        {
            attack("scout");
        }
        if(currentLocation.hasQueen){
            attack("queen");
        }

    };

    public void attack(String type) {
        if (MainDriver.rand.nextInt(killprobability) > 49) {

            if(type.compareTo("queen")==0){
                //currentLocation.removeAnt(currentLocation.myQueen);
                currentLocation.myQueen.setAlive(false);
            }
            else if (type.compareTo("soldier") == 0) {
                try {
                    List soldierList = currentLocation.soldierRoster.keyList();
                    Soldier mytempSoldier = ((Soldier) soldierList.get(0));

                    currentLocation.removeAnt(mytempSoldier);
                    soldierList.remove(0);
                } catch (Exception e) {

                }
            } else if (type.compareTo("forage") == 0) {


            }
            try {
                List forageList = currentLocation.foragerRoster.keyList();
                Foragers mytempForager = ((Foragers) forageList.get(0));

                currentLocation.removeAnt(mytempForager);
                forageList.remove(0);
            } catch (Exception e) {

            }

        } else if (type.compareTo("scout") == 0) {

            try {
                List scoutList = currentLocation.scoutRoster.keyList();
                Scouts mytempScout = ((Scouts) scoutList.get(0));

                currentLocation.removeAnt(mytempScout);
                scoutList.remove(0);
            } catch (Exception e) {

            }
        }
    }
    }


