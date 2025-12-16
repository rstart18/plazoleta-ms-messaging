package co.com.bancolombia.usecase.smsnotification;

import co.com.bancolombia.model.smsnotification.SmsNotification;
import co.com.bancolombia.model.smsnotification.gateways.SmsNotificationGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class SmsNotificationUseCaseTest {

    @Mock
    private SmsNotificationGateway smsNotificationGateway;

    @InjectMocks
    private SmsNotificationUseCase smsNotificationUseCase;

    private SmsNotification smsNotification;

    @BeforeEach
    void setUp() {
        smsNotification = SmsNotification.builder()
                .phoneNumber("+573001234567")
                .message("Test message")
                .build();
    }

    @Test
    void shouldSendSmsSuccessfully() {
        // When
        smsNotificationUseCase.sendSms(smsNotification);

        // Then
        verify(smsNotificationGateway, times(1)).sendSms(smsNotification);
    }
}