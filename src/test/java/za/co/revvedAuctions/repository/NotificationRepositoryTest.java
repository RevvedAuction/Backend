package za.co.revvedAuctions.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.revvedAuctions.domain.Notification;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationRepositoryTest {

    private static INotificationRepository repository = (INotificationRepository) NotificationRepository.getRepository();
    private static int testNotificationId;

    private Notification notification = new Notification.Builder()
            .setNotificationType("BID_UPDATE")
            .setMessage("Your bid was successful on Toyota Corolla")
            .setDateTime(LocalDateTime.now())
            .setRead(false)
            .build();

    @Test
    void a_create() {
        Notification created = repository.create(notification);
        assertNotNull(created);
        testNotificationId = created.getNotificationID();
        System.out.println("Created: " + created.toString());
    }

    @Test
    void b_read() {
        Notification read = repository.read(testNotificationId);
        assertNotNull(read);
        assertEquals(testNotificationId, read.getNotificationID());
        assertEquals("BID_UPDATE", read.getNotificationType());
        assertFalse(read.isRead());
        System.out.println("Read: " + read.toString());
    }

    @Test
    void c_update() {
        Notification updated = new Notification.Builder().copy(notification)
                .setNotificationID(testNotificationId)
                .setRead(true)
                .setMessage("Your bid was successful - payment required")
                .build();
        Notification updatedNotification = repository.update(updated);
        assertNotNull(updatedNotification);
        assertTrue(updatedNotification.isRead());
        assertEquals("Your bid was successful - payment required", updatedNotification.getMessage());
        System.out.println("Updated: " + updatedNotification.toString());
    }

    @Test
    void d_delete() {
        boolean deleted = repository.delete(testNotificationId);
        assertTrue(deleted);
        System.out.println("Deleted notification: " + testNotificationId);

        // Verify deletion
        Notification deletedNotification = repository.read(testNotificationId);
        assertNull(deletedNotification);
    }

    @Test
    void e_getAll() {
        // Create another notification for testing getAll
        Notification secondNotification = new Notification.Builder()
                .setNotificationType("AUCTION_END")
                .setMessage("Auction for BMW X5 has ended")
                .setDateTime(LocalDateTime.now())
                .setRead(true)
                .build();
        repository.create(secondNotification);

        System.out.println("All Notifications: " + repository.getAll());
        assertTrue(repository.getAll().size() >= 2);
    }

    @Test
    void f_findByIsRead() {
        // Create a read notification
        Notification readNotification = new Notification.Builder()
                .setNotificationType("PAYMENT_CONFIRMATION")
                .setMessage("Your payment was processed successfully")
                .setDateTime(LocalDateTime.now())
                .setRead(true)
                .build();
        repository.create(readNotification);

        var readNotifications = repository.findByIsRead(true);
        var unreadNotifications = repository.findByIsRead(false);

        assertFalse(readNotifications.isEmpty());
        assertFalse(unreadNotifications.isEmpty());
        assertTrue(readNotifications.get(0).isRead());
        assertFalse(unreadNotifications.get(0).isRead());
        System.out.println("Read Notifications: " + readNotifications);
        System.out.println("Unread Notifications: " + unreadNotifications);
    }

    @Test
    void g_findByNotificationType() {
        // Create another BID_UPDATE notification
        Notification bidNotification = new Notification.Builder()
                .setNotificationType("BID_UPDATE")
                .setMessage("You were outbid on Honda Civic")
                .setDateTime(LocalDateTime.now())
                .setRead(false)
                .build();
        repository.create(bidNotification);

        // Create different type notification
        Notification paymentNotification = new Notification.Builder()
                .setNotificationType("PAYMENT_REMINDER")
                .setMessage("Please complete your payment within 24 hours")
                .setDateTime(LocalDateTime.now())
                .setRead(false)
                .build();
        repository.create(paymentNotification);

        var bidNotifications = repository.findByNotificationType("BID_UPDATE");
        var paymentNotifications = repository.findByNotificationType("PAYMENT_REMINDER");

        assertTrue(bidNotifications.size() >= 2);
        assertFalse(paymentNotifications.isEmpty());
        assertEquals("BID_UPDATE", bidNotifications.get(0).getNotificationType());
        assertEquals("PAYMENT_REMINDER", paymentNotifications.get(0).getNotificationType());
        System.out.println("BID_UPDATE Notifications: " + bidNotifications);
        System.out.println("PAYMENT_REMINDER Notifications: " + paymentNotifications);
    }

    @Test
    void h_findByMessageContaining() {
        // Create notification with specific text
        Notification carNotification = new Notification.Builder()
                .setNotificationType("AUCTION_START")
                .setMessage("New Toyota Camry auction starting soon")
                .setDateTime(LocalDateTime.now())
                .setRead(false)
                .build();
        repository.create(carNotification);

        var toyotaNotifications = repository.findByMessageContaining("Toyota");
        var camryNotifications = repository.findByMessageContaining("Camry");
        var bmwNotifications = repository.findByMessageContaining("BMW");

        assertFalse(toyotaNotifications.isEmpty());
        assertFalse(camryNotifications.isEmpty());
        assertTrue(bmwNotifications.isEmpty()); // Should be empty if no BMW messages
        System.out.println("Toyota Notifications: " + toyotaNotifications);
        System.out.println("Camry Notifications: " + camryNotifications);
    }
}