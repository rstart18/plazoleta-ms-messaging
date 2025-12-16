package co.com.bancolombia.api.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {
    private String message;
    private LocalDateTime sentAt;
}
