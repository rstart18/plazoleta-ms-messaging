package co.com.bancolombia.api.rest.notification;

import co.com.bancolombia.api.dto.request.SmsRequest;
import co.com.bancolombia.api.dto.response.NotificationResponse;
import co.com.bancolombia.api.mapper.SmsNotificationMapper;
import co.com.bancolombia.model.smsnotification.SmsNotification;
import co.com.bancolombia.usecase.smsnotification.SmsNotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class SmsApiRest {

    private final SmsNotificationService smsNotificationService;

    @PostMapping("/sms")
    public ResponseEntity<NotificationResponse> sendSms(@Valid @RequestBody SmsRequest request) {
        SmsNotification notification = SmsNotificationMapper.toModel(request);
        smsNotificationService.sendSms(notification);
        NotificationResponse response = SmsNotificationMapper.toResponse();
        return ResponseEntity.ok(response);
    }
}
