package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Notification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationFactoryTest {

    private static Notification notification1 = NotificationFactory.createNotification(
            1,
            "Auction",
            "Auction started",
            false
    );
    private static Notification notification2 = NotificationFactory.createNotification(
            2,
            "Payment",
            "Payment received",
            true
    );
    private static Notification notification3 = NotificationFactory.createNotification(
            3,
            "Bid",
            "New bid placed",
            false
    );

    @Test
    public void testCreateNotification() {
        assertNotNull(notification1);
        System.out.println(notification1.toString());
    }

    @Test
    public void testCreateNotification2() {
        assertNotNull(notification2);
        System.out.println(notification2.toString());
    }

    @Test
    public void testCreateNotification3() {
        assertNotNull(notification3);
        System.out.println(notification3.toString());
    }
}
