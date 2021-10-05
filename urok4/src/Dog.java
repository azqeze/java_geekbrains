import java.text.DecimalFormat;

public class Dog extends Animal{
    public static double jumpLimit =(Math.random() * ( 0.5 - 0.1 )) + 0.1;
    public static double runLimit = (Math.random() * ( 500 - 150 )) + 150;
    public static double swimLimit = (Math.random() * ( 10 - 2 )) + 2;

// (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
    public Dog(String name){
        super(name, jumpLimit, runLimit, swimLimit);
    }

}
