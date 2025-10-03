public class NotificationService {
    public void sendEmail(String to, String subject, String body) {
        if (!validateRecipient(to, "Invalid email address")) {
            return;
        }
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

    public void sendSms(String phone, String message) {
        if (!validateRecipient(phone, "Invalid phone number")) {
            return;
        }
        System.out.println("Sending SMS to: " + phone);
        System.out.println("Message: " + message);
    }

    public void sendPush(String deviceToken, String message) {
        if (!validateRecipient(deviceToken, "Invalid device token")) {
            return;
        }
        System.out.println("Sending Push Notification to: " + deviceToken);
        System.out.println("Message: " + message);
    }

    private boolean validateRecipient(String recipient, String errorMessage) {
        if (recipient == null || recipient.isEmpty()) {
            System.out.println(errorMessage);
            return false;
        }
        return true;
    }
}