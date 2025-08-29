package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "http://localhost:8082")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationByID(@PathVariable("id") int id) {
        Notification notification = notificationService.getNotificationByID(id);
        if (notification != null) {
            return ResponseEntity.ok(notification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable("id") int id, @RequestBody Notification updatedNotification) {
        Notification existingNotification = notificationService.getNotificationByID(id);

        if (existingNotification != null) {
            Notification notificationToUpdate = new Notification.Builder()
                    .copy(existingNotification)
                    .setNotificationType(updatedNotification.getNotificationType())
                    .setMessage(updatedNotification.getMessage())
                    .setDateTime(updatedNotification.getDateTime())
                    .setRead(updatedNotification.isRead())
                    .build();

            Notification savedNotification = notificationService.saveNotification(notificationToUpdate);
            return ResponseEntity.ok(savedNotification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotification(@PathVariable("id") int id) {
        Notification notification = notificationService.getNotificationByID(id);
        if (notification == null) {
            return ResponseEntity.notFound().build();
        }
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}