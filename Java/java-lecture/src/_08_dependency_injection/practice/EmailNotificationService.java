package _08_dependency_injection.practice;

public class EmailNotificationService implements NotificationService {
    public void notificate() {
        System.out.println("Sending email notification: Your order has been processed");
    }
}