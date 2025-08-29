package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.repository.INotificationRepository;

import java.util.List;

@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository notificationRepository;

    @Autowired
    public NotificationService(INotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationByID(int id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteNotification(int id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByIsRead(false);
    }

    @Override
    public List<Notification> getNotificationsByType(String notificationType) {
        return notificationRepository.findByNotificationType(notificationType);
    }

    @Override
    public Notification markAsRead(int notificationId) {
        Notification notification = getNotificationByID(notificationId);
        if (notification != null) {
            notification.setRead(true);
            return saveNotification(notification);
        }
        return null;
    }

    @Override
    public Notification markAsUnread(int notificationId) {
        Notification notification = getNotificationByID(notificationId);
        if (notification != null) {
            notification.setRead(false);
            return saveNotification(notification);
        }
        return null;
    }
}