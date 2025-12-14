public class WorkingPerson implements Work, Eat, Clean{

    public  void eat(){
        System.out.println("Я поел.");
    }

    public void work(){
        System.out.println("Я работаю.");
    }

    public void clean(){
        System.out.println("Я убираюсь.");
    }
}
