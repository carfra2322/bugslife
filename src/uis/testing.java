package uis;

public class testing {
    public static void main(String[] args){



        EnvironmentNode myEnv = new EnvironmentNode(13,13);
        //Ant myAnt = new Ant();
        //Ant newAnt = new Ant();
        //myEnv.addAnt(myAnt);
        //myEnv.addAnt(newAnt);

        Queen myQueen = new Queen(myEnv);
        System.out.println("is instance of queen ? " + myQueen.getClass().getSimpleName() );
        System.out.println(myQueen.getClass().getSimpleName().compareTo("Queen"));


    }
}
