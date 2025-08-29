package _08_dependency_injection.practice;

public class SMSNotificationService implements NotificationService {
    public void notificate() {
        System.out.println("Sending SMS notification: Your order has been processed");
    }
}