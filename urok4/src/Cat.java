import java.text.DecimalFormat;

public class Cat extends Animal{
    DecimalFormat df = new DecimalFormat("#.##");
    public static double jumpLimit = (Math.random() * ( 2 - 0.5 )) + 0.5;
    public static double runLimit = (Math.random() * ( 200 - 50 )) + 50;

    // (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
    public Cat(String name){
        super(name, jumpLimit, runLimit, 0);
    }

}
