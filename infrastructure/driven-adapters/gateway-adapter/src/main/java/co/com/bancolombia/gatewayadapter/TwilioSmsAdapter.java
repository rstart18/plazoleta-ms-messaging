package co.com.bancolombia.gatewayadapter;

import co.com.bancolombia.model.smsnotification.SmsNotification;
import co.com.bancolombia.model.smsnotification.gateways.SmsNotificationGateway;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioSmsAdapter implements SmsNotificationGateway {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @Override
    public void sendSms(SmsNotification smsNotification) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                        new PhoneNumber(smsNotification.getPhoneNumber()),
                        new PhoneNumber(fromPhoneNumber),
                        smsNotification.getMessage())
                .create();
    }
}
