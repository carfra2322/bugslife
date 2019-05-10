package uis;

public class testing {



    public static void main(String[] args){

        EnvironmentNode myenv;

        EnvironmentNode myEnv = new EnvironmentNode(13,13);
        //Ant myAnt = new Ant();
        //Ant newAnt = new Ant();
        //myEnv.addAnt(myAnt);
        //myEnv.addAnt(newAnt);

        //Queen myQueen = new Queen(myEnv);
        //System.out.println("is instance of queen ? " + myQueen.getClass().getSimpleName() );
        //System.out.println(myQueen.getClass().getSimpleName().compareTo("Queen"));

        EnvironmentNode firstNode = new EnvironmentNode(0,0);
        EnvironmentNode secondNode = new EnvironmentNode(0,1);
        EnvironmentNode thirdNode = new EnvironmentNode(0,3);

        //String firstNode = "whi";
        //String secondNode = "whi23";
        //String thirdNode = "whi31314";

        LinkedStack myqueue = new LinkedStack();

        myqueue.add(firstNode);
        myqueue.add(secondNode);
        myqueue.add(thirdNode);
        int size = myqueue.size();
        System.out.println("size " + myqueue.size());

        //System.out.println(((EnvironmentNode) myqueue.pop()).getCol());
        //System.out.println(((EnvironmentNode) myqueue.pop()).getCol());
        //System.out.println(((EnvironmentNode) myqueue.pop()).getCol());

        System.out.println("size " + myqueue.size());

        for(int i =0; i< size; i++){
            System.out.println(((EnvironmentNode) myqueue.pop()).getCol());
        }



    }
}
