package Factory;
/* Author: Makungo FM (KodeKnack)
   Student NO: 230787932
*/
import Domain.Notification;
import Util.Helper;
public class NotificationFactory {

    public static Notification createNotification(
            int notificationID,
            String notificationType,
            String message,
            boolean isRead) {

        if (Helper.isNullOrEmpty(notificationID)
                || Helper.isNullOrEmpty(notificationType)
                || Helper.isNullOrEmpty(message)) {
            return null;
        }

        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setNotificationType(notificationType)
                .setMessage(message)
                .setRead(isRead)
                .build();
    }
}
