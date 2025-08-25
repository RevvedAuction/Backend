package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Notification;
import java.util.List;

public interface INotificationRepository extends IRepository<Notification, Integer> {
    List<Notification> findByIsRead(boolean isRead);
    List<Notification> findByNotificationType(String notificationType);
}