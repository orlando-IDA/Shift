package br.com.fiap.Shift.dto;

import org.springframework.data.web.ProjectedPayload;

public interface VehicleSummary {
    String getManufacturer();
    String getModel();
    Integer getReleaseYear();
}
