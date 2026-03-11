package com.yprado.businesses.manager.mapper;

import com.yprado.businesses.manager.dto.BusinessCreateDTO;
import com.yprado.businesses.manager.dto.BusinessDTO;
import com.yprado.businesses.manager.dto.BusinessUpdateDTO;
import com.yprado.businesses.manager.persistence.model.Business;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BusinessMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "ACTIVE")
    Business toBusiness(BusinessCreateDTO dto);

    BusinessDTO toBusinessDTO(Business domain);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateBusinessFromDTO(BusinessUpdateDTO dto, @MappingTarget Business business);
}
