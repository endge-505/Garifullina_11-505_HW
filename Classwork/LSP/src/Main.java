public class Main{
    public static void main(String[] args){
        Bird pinguin = new Pinguin();
        Sparrowl sparrowl = new Sparrowl();

        pinguin.eat();
//        pinguin.fly(); - пигвины не умеют летать

        sparrowl.eat();
//        sparrowl.fly(); -воробьи умеют летать

        sparrowl.eat();
        sparrowl.fly(); // у нас есть наследник, который умеет делать всё,летать тоже может
    }
}