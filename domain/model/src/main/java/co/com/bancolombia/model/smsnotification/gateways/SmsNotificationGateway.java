package co.com.bancolombia.model.smsnotification.gateways;

import co.com.bancolombia.model.smsnotification.SmsNotification;

public interface SmsNotificationGateway {
    void sendSms(SmsNotification smsNotification);
}
