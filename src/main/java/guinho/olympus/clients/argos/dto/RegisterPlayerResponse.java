package guinho.olympus.clients.argos.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterPlayerResponse(UUID id, String nickname, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
