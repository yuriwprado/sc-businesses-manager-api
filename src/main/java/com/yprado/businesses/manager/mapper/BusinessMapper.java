package com.yprado.businesses.manager.mapper;

import com.yprado.businesses.manager.dto.BusinessCreateDTO;
import com.yprado.businesses.manager.dto.BusinessDTO;
import com.yprado.businesses.manager.dto.BusinessUpdateDTO;
import com.yprado.businesses.manager.persistence.model.Business;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {

    Business toBusiness(BusinessCreateDTO dto);
    Business toBusiness(BusinessUpdateDTO businessUpdateDTO);
    BusinessDTO toBusinessDTO(Business domain);
}
