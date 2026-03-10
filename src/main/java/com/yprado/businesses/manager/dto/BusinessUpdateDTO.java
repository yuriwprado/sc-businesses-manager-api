package com.yprado.businesses.manager.dto;

import com.yprado.businesses.manager.persistence.model.BusinessSegment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BusinessUpdateDTO(

        @NotBlank(message = "Id is required")
        String id,

        @NotBlank(message = "Business name is required")
        @Size(max = 255, message = "Business name must not exceed 255 characters")
        String name,

        @NotBlank(message = "Owner name is required")
        @Size(max = 255, message = "Owner name must not exceed 255 characters")
        String ownerName,

        @NotBlank(message = "City is required")
        @Size(max = 100, message = "City must not exceed 100 characters")
        String city,

        @NotNull(message = "Segment is required")
        BusinessSegment segment,

        @NotBlank(message = "Contact is required")
        @Size(max = 255, message = "Contact must not exceed 255 characters")
        String contact
) {}
