public class Animal {
    protected String name;
    protected double jumpLimit;
    protected double runLimit;
    protected double swimLimit;

    public Animal(String name, double jumpLimit, double runLimit, double swimLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }

    public void jump(double height) {
        if(height <= jumpLimit) {
            System.out.println(name + " прыгнет на " + height + " метра т.к. его лимит: " + jumpLimit);
        }
        else {
            System.out.println(name + " не прыгнет на " + height + " метра т.к. его лимит: " + jumpLimit);
        }
    }

    public void run(double distance) {
        if(distance <= runLimit) {
            System.out.println(name + " пробежит " + distance + " метров т.к. его лимит: " + runLimit);
        }
        else {
            System.out.println(name + " не пробежит " + distance + " метров т.к. его лимит: " + runLimit);
        }
    }

    public void swim(double distance) {
        if (swimLimit != 0) {
            if(distance <= swimLimit) {
                System.out.println(name + " проплывет " + distance + " метров т.к. его лимит: " + swimLimit);
            }
            else {
                System.out.println(name + " не проплывет " + distance + " метров т.к. его лимит: " + swimLimit);
            }
        } else {
            System.out.println(name + " не умеет плавать");
        }
    }

    public void animalTest(){
        run(100);
        jump(1);
        swim(3);
    }
}
