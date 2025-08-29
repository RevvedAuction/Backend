package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Notification;
import za.co.revvedAuctions.domain.User;

import java.util.List;

public interface INotificationService extends IService<Notification, Integer> {
    List<Notification> getAll();
}