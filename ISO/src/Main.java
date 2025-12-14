public class Main {
    public static void main(String[] args){
        WorkingPerson people = new WorkingPerson();
        RobotWorker robot = new RobotWorker();

        people.eat();
        people.work();
        people.clean();

        robot.clean();
        robot.work();
//      robot.eat(); = роботы не умеют кушать,
//      если бы нам пришлось выводить это в одном интерфейсе,
//      то программа выводила бы ошибку.
    }
}
