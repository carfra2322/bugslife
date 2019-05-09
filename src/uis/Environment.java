package uis;
import java.util.*;
/**
 * This is the class that will be creating a list of Environment nodes
 * */

public class Environment extends ColonyView{

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

    /**
     * @Param myEnvNodeList to store the 27 x 27 nodes required for this simulation
     * @Param environment is an instance of ColonyView in startSim() we initialize all 27 x 27 nodes in the environment.
     * */

    EnvironmentNode [][] myEnvNodeList;
    //Environment environment;
    Ant newAnt;
    EnvironmentNode myQueenNode;
    int AntID;





    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------


    public Environment(int colonyHeight, int colonyWidth) {
        super(colonyHeight, colonyWidth);
        myEnvNodeList = new EnvironmentNode[27][27];

    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------


    public void startSim(){

        for (int row =0; row < 27; row++){
            for(int col=0; col < 27; col++){
                //System.out.println("Row: " + row + " Column: " + col);
                //ColonyNodeView myTempNode = new ColonyNodeView();
                EnvironmentNode envNode = new EnvironmentNode(row, col);
                envNode.setID(row + " , " + col);
                myEnvNodeList[row][col] = envNode;
                envNode.setEnvironment(this);
                this.addColonyNodeView(envNode, row, col);


                if((row >=12 && row <=14) && (col >= 12 && col <=14)){
                    System.out.println("Row: " + row + " Column: " + col);
                    envNode.showNode();
                    /**
                     * Sets the middle node with the initial state requirements
                     * the queen an
                     * 10 soldier ants
                     * 50 forager ants
                     * 4 scout ants
                     * 1000 units of food
                     * */
                    if(row==13 && col==13){
                        int i;
                        Queen myQueen = new Queen(envNode);
                        myQueen.ID = 0;
                        envNode.setFoodAmount(1000);
                        envNode.addAnt(myQueen);
                        System.out.println("queen life span " + myQueen.LifeSpan);

;

                        //This code will add the initial group of ants
                        for(i=0; i<64; i++){
                            //4 scout ants
                            if(i<4){
                                System.out.println("Adding " + (i+1) + " scout ants ");
                                Scouts myScout = new Scouts(envNode);
                                myScout.ID = i;
                                envNode.addAnt(myScout);
                            }
                            //10 soldier ants
                            if(i>3 && i < 14){
                                System.out.println("Adding " + (i+1) + " soldier ants ");
                                Soldier mySoldier = new Soldier(envNode);
                                mySoldier.ID = i;
                                envNode.addAnt(mySoldier);
                            }
                            //50 forager ants
                            if(i>13 && i<64){
                                System.out.println("adding " + (i+1) + " forager ants");
                                Foragers myForager = new Foragers(envNode);
                                myForager.ID = i;
                                envNode.addAnt(myForager);
                            }

                            //envNode.updateEnvNode();
                            myQueen.setIDcount(i);
                        }

                        System.out.println("ID of the square " + envNode.getID().substring(0,2));
                        envNode.updateEnvNode();


                    }
                }


            }
        }
        //After loading all nodes we have the node where the queen lives
        myQueenNode = myEnvNodeList[13][13];


    }


    public void turnUpdate(){
        System.out.println("turn has passed");
        checkQueenLife();
        myQueenNode.myQueen.LifeSpan--;
        myQueenNode.myQueen.eat();
        myQueenNode.myQueen.hatch();
        myQueenNode.updateEnvNode();

        //Going to have to change this to iterate through all the visible nodes to get them updated.
        for (int row =0; row < 27; row++){
            for(int col=0; col < 27; col++){
                myEnvNodeList[row][col].updateEnvNode();
            }
        }



    }

    public void checkQueenLife(){


        if(myQueenNode.myQueen.LifeSpan==0 || myQueenNode.foodAmount==0){
            System.out.println("That's it life is over queenie");
            myQueenNode.myQueen.setAlive(false);
        }


    }

    public ArrayList getNeighborNodes(EnvironmentNode envnode){
        int row = envnode.getRow();
        int col = envnode.getCol();
        ArrayList neighborNodes = new ArrayList();


        for (int forrow=row-1; forrow<=row+1; forrow++){
            for(int forcol=col-1; forcol<=col+1; forcol++){
                //Sets the boundaries where row and column should never go below 0 and beyond 26
                //Also sets the restriction where col and row equal the same so that it does not move to the same spot
                if(forrow!=-1 || forrow!=26 || forcol!=-1 || forcol!=26 || (forcol==col && forrow==row)){
                    try {
                        neighborNodes.add(myEnvNodeList[forrow][forcol]);
                    }
                    catch(Exception e){}
                }
            }
        }

        return neighborNodes;
    }


}
