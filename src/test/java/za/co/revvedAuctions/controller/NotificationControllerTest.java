package za.co.revvedAuctions.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.factory.NotificationFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationControllerTest {

    @Autowired
    private NotificationController notificationController;

    private static int testNotificationId;

    private Notification notification = NotificationFactory.createNotification(
            "BID_UPDATE",
            "Your bid was successful on Toyota Corolla",
            LocalDateTime.now(),
            false
    );

    @Test
    void a_createNotification() {
        Notification created = notificationController.createNotification(notification);
        assertNotNull(created);
        testNotificationId = created.getNotificationID();
        System.out.println("Created via Controller: " + created.toString());
    }

    @Test
    void b_getNotificationByID() {
        Notification found = notificationController.getNotificationByID(testNotificationId);
        assertNotNull(found);
        assertEquals(testNotificationId, found.getNotificationID());
        System.out.println("Found via Controller: " + found.toString());
    }

    @Test
    void c_getAllNotifications() {
        System.out.println("All Notifications via Controller: " + notificationController.getAllNotifications());
        assertNotNull(notificationController.getAllNotifications());
    }

    @Test
    void d_updateNotification() {
        Notification updatedNotification = new Notification.Builder().copy(notification)
                .setNotificationID(testNotificationId)
                .setRead(true)
                .setMessage("Your bid was successful - payment required")
                .build();

        Notification updated = notificationController.updateNotification(testNotificationId, updatedNotification);
        assertNotNull(updated);
        assertTrue(updated.isRead());
        System.out.println("Updated via Controller: " + updated.toString());
    }

    @Test
    void e_deleteNotification() {
        String result = notificationController.deleteNotification(testNotificationId);
        assertEquals("Notification deleted successfully", result);
        System.out.println("Deleted via Controller: " + testNotificationId);
    }

    @Test
    void f_getUnreadNotifications() {
        System.out.println("Unread Notifications via Controller: " + notificationController.getUnreadNotifications());
    }

    @Test
    void g_getNotificationsByType() {
        System.out.println("BID_UPDATE Notifications via Controller: " + notificationController.getNotificationsByType("BID_UPDATE"));
    }

    @Test
    void h_markAsRead() {
        Notification markedRead = notificationController.markAsRead(testNotificationId);
        assertNotNull(markedRead);
        assertTrue(markedRead.isRead());
        System.out.println("Marked as Read via Controller: " + markedRead.toString());
    }

    @Test
    void i_markAsUnread() {
        Notification markedUnread = notificationController.markAsUnread(testNotificationId);
        assertNotNull(markedUnread);
        assertFalse(markedUnread.isRead());
        System.out.println("Marked as Unread via Controller: " + markedUnread.toString());
    }
}