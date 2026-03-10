package com.yprado.businesses.manager.dto;


import com.yprado.businesses.manager.persistence.model.BusinessSegment;
import com.yprado.businesses.manager.persistence.model.BusinessStatus;

public record BusinessDTO(
        String id,
        String name,
        String ownerName,
        String city,
        BusinessSegment segment,
        String contact,
        BusinessStatus status
) {

}
