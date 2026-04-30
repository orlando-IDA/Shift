package br.com.fiap.Shift.dto;

import br.com.fiap.Shift.models.Rental;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalResponse(
    Integer id,
    String customerName,
    String customerCpf,
    String vehicleModel,
    String vehiclePlate,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal totalPrice
) {
    public static RentalResponse fromEntity(Rental rental) {
        return new RentalResponse(
            rental.getId(),
            rental.getCustomer().getName(),
            rental.getCustomer().getCpf(),
            rental.getVehicle().getModel(),
            rental.getVehicle().getLicensePlate(),
            rental.getStartDate(),
            rental.getEndDate(),
            rental.getTotalPrice()
        );
    }
}
