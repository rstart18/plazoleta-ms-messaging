package co.com.bancolombia.usecase.smsnotification;

import co.com.bancolombia.model.smsnotification.SmsNotification;

public interface SmsNotificationService {
    void sendSms(SmsNotification smsNotification);
}
