package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    // These methods will be implemented by Spring Data JPA
//    List<Notification> findByIsRead(boolean isRead);
//    List<Notification> findByNotificationType(String notificationType);
//    Notification saveNotification(Notification notification);
//    Notification getNotificationByID(int id);
//    List<Notification> getAllNotifications();
//    void deleteNotification(int id);
    // Custom business methods
//    List<Notification> getUnreadNotifications();
//    List<Notification> getNotificationsByType(String notificationType);
//    Notification markAsRead(int notificationId);
//    Notification markAsUnread(int notificationId);
}