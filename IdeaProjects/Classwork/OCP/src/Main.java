public  class Main{
    public  static void main(String[] args) {
        NotificationServise letter_1 = new InstagramNotification();
        NotificationServise letter_2 = new SMSNotification();

        letter_1.send();
        letter_2.send();
    }
}