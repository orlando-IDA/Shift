package br.com.fiap.Shift.dto;

import br.com.fiap.Shift.models.Rental;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record RentalRequest(
    @NotNull(message = "Field customer ID is mandatory.")
    Integer customerId,

    @NotNull(message = "Field Vehicle ID is mandatory.")
    Integer vehicleId,

    @NotNull(message = "Field Start Date is mandatory.")
    @FutureOrPresent(message = "Start Future must be a Future or Present date.")
    LocalDateTime startDate,

    LocalDateTime endDate
) {
    public Rental toEntity() {
        Rental rental = new Rental();
        rental.setStartDate(this.startDate);
        rental.setEndDate(this.endDate);
        return rental;
    }
}
