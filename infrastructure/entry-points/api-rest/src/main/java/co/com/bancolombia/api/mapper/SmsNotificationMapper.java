package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.request.SmsRequest;
import co.com.bancolombia.api.dto.response.NotificationResponse;
import co.com.bancolombia.model.smsnotification.SmsNotification;
import java.time.LocalDateTime;

public class SmsNotificationMapper {

    public static SmsNotification toModel(SmsRequest request) {
        return SmsNotification.builder()
                .phoneNumber(request.getPhoneNumber())
                .message(request.getMessage())
                .build();
    }

    public static NotificationResponse toResponse() {
        return NotificationResponse.builder()
                .message("SMS sent successfully")
                .sentAt(LocalDateTime.now())
                .build();
    }
}