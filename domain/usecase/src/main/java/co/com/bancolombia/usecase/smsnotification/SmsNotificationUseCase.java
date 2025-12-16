package co.com.bancolombia.usecase.smsnotification;

import co.com.bancolombia.model.smsnotification.SmsNotification;
import co.com.bancolombia.model.smsnotification.gateways.SmsNotificationGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmsNotificationUseCase implements SmsNotificationService {

    private final SmsNotificationGateway smsNotificationGateway;

    @Override
    public void sendSms(SmsNotification smsNotification) {
        smsNotificationGateway.sendSms(smsNotification);
    }
}
