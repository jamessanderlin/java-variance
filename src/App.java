import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Fruit fruit = new Fruit();
        Mango mango = new Mango();
        
        ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
        ArrayList<Mango> mangoList = new ArrayList<Mango>();

        FruitComparator fruitComparator = new FruitComparator();
        MangoComparator mangoComparator = new MangoComparator();

        // COVARIANCE

        fruit = mango;
        // mango = fruit; // Doesn't work, assignment is covariant

        Fruit[] fruitArray = {};
        Mango[] mangoArray = {};

        fruitArray = mangoArray;
        // mangoArray = fruitArray; // Doesn't work, arrays are covariant 

        fruitFuncCovariant(fruitList);
        fruitFuncCovariant(mangoList);

        mangoFuncCovariant(mangoList);
        // mangoFuncCovariant(fruitList); // Doesn't work, method parameter is covariant


        // CONTRAVARIANCE
        
        fruitComparer(fruitComparator);
        // fruitComparer(mangoComparator);

        mangoComparer(mangoComparator);
        mangoComparer(fruitComparator);

        // INVARIANCE

        fruitList = mangoList; // Doesn't work, generics are invariant
        mangoList = fruitList; // Doesn't work, generics are invariant


        fruitFuncInvariant(fruitList);
        // fruitFuncInvariant(mangoList); // Doesn't work, method parameter is invariant

        mangoFuncInvariant(mangoList);
        // mangoFuncInvariant(fruitList); // Doesn't work, method parameter is invariant
    }

    static void fruitFuncInvariant(ArrayList<Fruit> fruits) {
        // simple method that accepts a list of fruit
    }

    static void mangoFuncInvariant(ArrayList<Mango> mangos) {
        // simple method that accepts a list of mango
    }

    static void fruitFuncCovariant(List<? extends Fruit> fruits) {
        // simple method that accepts a list of fruit
    }

    static void mangoFuncCovariant(List<? extends Mango> mangos) {
        // simple method that accepts a list of mango
    }

    static void fruitComparer(Comparator<? super Fruit> fruitComparator) {
        Fruit fruit1 = new Fruit();
        Fruit fruit2 = new Fruit();
        fruitComparator.isGreaterThanOrEqualTo(fruit1, fruit2);
    }

    static void mangoComparer(Comparator<? super Mango> mangoComparator) {
        Mango mango1 = new Mango();
        Mango mango2 = new Mango();
        mangoComparator.isGreaterThanOrEqualTo(mango1, mango2);
    }
}

class Fruit {
    // Sample Fruit class
    public int size;
}

class Mango extends Fruit {
    // Sample Mango class (Subtype of Fruit)
}

interface Comparator<T> {
    boolean isGreaterThanOrEqualTo(T t1, T t2);
}

class FruitComparator implements Comparator<Fruit> {
    public boolean isGreaterThanOrEqualTo(Fruit fruit1, Fruit fruit2) {
        return fruit1.size >= fruit2.size;
    }
}

class MangoComparator implements Comparator<Mango> {
    public boolean isGreaterThanOrEqualTo(Mango mango1, Mango mango2) {
        return mango1.size >= mango2.size;
    }
}