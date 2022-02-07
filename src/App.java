import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        
        // COVARIANCE

        Fruit fruit = new Fruit();
        Mango mango = new Mango();

        fruit = mango;
        // mango = fruit; // Doesn't work, assignment is covariant

        Fruit[] fruitArray = {};
        Mango[] mangoArray = {};

        fruitArray = mangoArray;
        // mangoArray = fruitArray; // Doesn't work, arrays are covariant 


        // INVARIANCE

        ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
        ArrayList<Mango> mangoList = new ArrayList<Mango>();

        // fruitList = mangoList; // Doesn't work, generics are invariant
        // mangoList = fruitList; // Doesn't work, generics are invariant
    }
}

