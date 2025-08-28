package za.co.revvedAuctions.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.factory.NotificationFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationServiceTest {

    private static INotificationService service = NotificationService.getService();
    private static int testNotificationId;

    private Notification notification = NotificationFactory.createNotification(
            "BID_UPDATE",
            "Your bid was successful on Toyota Corolla",
            LocalDateTime.now(),
            false
    );

    @Test
    void a_create() {
        Notification created = service.create(notification);
        assertNotNull(created);
        testNotificationId = created.getNotificationID();
        System.out.println("Created: " + created.toString());
    }

    @Test
    void b_read() {
        Notification read = service.read(testNotificationId);
        assertNotNull(read);
        assertEquals(testNotificationId, read.getNotificationID());
        System.out.println("Read: " + read.toString());
    }

    @Test
    void c_update() {
        Notification updated = new Notification.Builder().copy(notification)
                .setNotificationID(testNotificationId)
                .setRead(true)
                .build();
        Notification updatedNotification = service.update(updated);
        assertNotNull(updatedNotification);
        assertTrue(updatedNotification.isRead());
        System.out.println("Updated: " + updatedNotification.toString());
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(testNotificationId);
        assertTrue(deleted);
        System.out.println("Deleted notification: " + testNotificationId);
    }

    @Test
    void e_getAll() {
        System.out.println("All Notifications: " + service.getAll());
    }

    @Test
    void f_markAsRead() {
        Notification markedRead = service.markAsRead(testNotificationId);
        assertNotNull(markedRead);
        assertTrue(markedRead.isRead());
        System.out.println("Marked as Read: " + markedRead.toString());
    }

    @Test
    void g_markAsUnread() {
        Notification markedUnread = service.markAsUnread(testNotificationId);
        assertNotNull(markedUnread);
        assertFalse(markedUnread.isRead());
        System.out.println("Marked as Unread: " + markedUnread.toString());
    }

    @Test
    void h_getUnreadNotifications() {
        System.out.println("Unread Notifications: " + service.getUnreadNotifications());
    }

    @Test
    void i_getNotificationsByType() {
        System.out.println("BID_UPDATE Notifications: " + service.getNotificationsByType("BID_UPDATE"));
    }
}