public class RobotWorker implements Work, Clean {

    public void work() {
        System.out.println("Робот работает.");
    }

    public void clean() {
        System.out.println("Робот убирается.");
    }
}