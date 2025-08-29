package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Notification;
import java.util.List;

public interface INotificationService {
    Notification saveNotification(Notification notification);
    Notification getNotificationByID(int id);
    List<Notification> getAllNotifications();
    void deleteNotification(int id);
    // Custom business methods
    List<Notification> getUnreadNotifications();
    List<Notification> getNotificationsByType(String notificationType);
    Notification markAsRead(int notificationId);
    Notification markAsUnread(int notificationId);
}