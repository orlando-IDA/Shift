package br.com.fiap.Shift.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record RentalRequest(
    @NotNull(message = "O ID do cliente é obrigatório")
    Integer customerId,

    @NotNull(message = "O ID do veículo é obrigatório")
    Integer vehicleId,

    @NotNull(message = "A data de início é obrigatória")
    @FutureOrPresent(message = "A data de início não pode ser no passado")
    LocalDateTime startDate,

    LocalDateTime endDate
) {
}
