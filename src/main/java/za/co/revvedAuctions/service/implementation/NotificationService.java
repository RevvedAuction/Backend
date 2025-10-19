package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.repository.NotificationRepository;
import za.co.revvedAuctions.service.INotificationService;

import java.util.List;

@Service
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Integer integer) {
        return notificationRepository.findById(integer).orElseThrow();
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification delete(Integer integer) {
        notificationRepository.deleteById(integer);
        return null;
    }

    @Override
    public List<Notification> getAll() {
        return this.notificationRepository.findAll();
    }
}