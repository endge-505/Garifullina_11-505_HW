public class SamostWork {
    public static void main(String[] args) { // Исправлено объявление метода main
        StandardRoom standart = new StandardRoom(702);
        SuiteRoom suit = new SuiteRoom(500);

        standart.check_1();
        standart.start();
        standart.check_2();
        standart.finish();

        suit.check_1();
        suit.orderDinner();
        suit.check_2();
        suit.finish();
    }
}

interface Room_1 {
    void check_1();
    void check_2();
}

interface Cleaning {
    void start();
    void finish();
}

enum RoomStatus {
    FREE("Свободен"),
    OCCUP("Занят"),
    CLEAN("На уборке");

    private final String status;

    RoomStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

abstract class Room_2 {
    protected int r_numb;
    protected String categor;
    protected RoomStatus status;

    public Room_2(int r2_numb, String category) {
        this.r_numb = r2_numb;
        this.categor = category;
        this.status = RoomStatus.FREE;
    }

    public abstract void check_1();
    public abstract void check_2();
}

class StandardRoom extends Room_2 implements Room_1, Cleaning {

    public StandardRoom(int r3_numb) {
        super(r3_numb, "стандартный номер");
    }

    @Override
    public void check_1() {
        if (status == RoomStatus.FREE) {
            status = RoomStatus.OCCUP;
            System.out.println("Гость заселён в стандартный номер " + r_numb);
        } else {
            System.out.println("Номер " + r_numb + " уже занят");
        }
    }

    @Override
    public void check_2() {
        if (status == RoomStatus.OCCUP) {
            status = RoomStatus.CLEAN;
            System.out.println("Гость выселен из номера " + r_numb + " стандартного типа");
        } else {
            System.out.println("Номер " + r_numb + " свободен");
        }
    }

    @Override
    public void start() {
        System.out.println("Идёт уборка номера " + r_numb);
    }

    @Override
    public void finish() {
        if (status == RoomStatus.CLEAN) {
            status = RoomStatus.FREE;
            System.out.println("Уборка в номера " + r_numb + " закончена, можно заселять гостей");
        } else {
            System.out.println("Уборка не нужна, номер чист");
        }
    }
}

class SuiteRoom extends Room_2 implements Room_1, Cleaning {

    public SuiteRoom(int roomNumber) {
        super(roomNumber, "люксовый номер");
    }

    @Override
    public void check_1() {
        if (status == RoomStatus.FREE) {
            status = RoomStatus.OCCUP;
            System.out.println("Гость заселен в люксевый номер " + r_numb);
        } else {
            System.out.println("Номер " + r_numb + " уже занят");
        }
    }

    @Override
    public void check_2() {
        if (status == RoomStatus.OCCUP) {
            status = RoomStatus.CLEAN;
            System.out.println("Гость выселен из номера " + r_numb + " люксового типа");
        } else {
            System.out.println("Номер " + r_numb + " свободен");
        }
    }

    @Override
    public void start() {
        System.out.println("Идёт уборка номера " + r_numb);
    }

    @Override
    public void finish() {
        if (status == RoomStatus.CLEAN) {
            status = RoomStatus.FREE;
            System.out.println("Уборка в номера " + r_numb + " закончена, можно заселять гостей");
        } else {
            System.out.println("Уборка не нужна, номер чист");
        }
    }

    public void orderDinner() {
        if (status == RoomStatus.OCCUP) {
            System.out.println("Ужин заказан для люксевый номер " + r_numb);
        } else {
            System.out.println("Нельзя заказать ужин, номер " + r_numb + " не заселён");
        }
    }
}
