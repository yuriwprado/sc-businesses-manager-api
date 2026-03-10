package com.yprado.businesses.manager.service;

import com.yprado.businesses.manager.dto.BusinessCreateDTO;
import com.yprado.businesses.manager.dto.BusinessDTO;
import com.yprado.businesses.manager.dto.BusinessUpdateDTO;
import com.yprado.businesses.manager.mapper.BusinessMapper;
import com.yprado.businesses.manager.persistence.model.Business;
import com.yprado.businesses.manager.persistence.model.BusinessStatus;
import com.yprado.businesses.manager.persistence.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;

    public BusinessDTO create(BusinessCreateDTO dto) {
        Business businessToBePersisted = businessMapper.toBusiness(dto);
        Business business = businessRepository.save(businessToBePersisted);
        return businessMapper.toBusinessDTO(business);
    }

    public BusinessDTO findByIdOrThrow(String id) {
        Business business = findOrThrow(id);
        return businessMapper.toBusinessDTO(business);
    }

    private Business findOrThrow(String id) {
        return businessRepository.findById(id)
                .orElseThrow(getBusinessNotFoundRuntimeExceptionSupplier(id));
    }

    public void update(BusinessUpdateDTO businessUpdateDTO) {
        Business businessToBeUpdated = businessMapper.toBusiness(businessUpdateDTO);
        businessRepository.save(businessToBeUpdated);
    }

    public void changeStatus(String id, BusinessStatus status) {
        Business business = findOrThrow(id);
        business.setStatus(status);
        businessRepository.save(business);
    }

    // TODO: paginar
    public List<BusinessDTO> listAll() {
        List<Business> businesses = businessRepository.findAll();
        return businesses.stream().map(businessMapper::toBusinessDTO).toList();
    }

    public void delete(String id) {
        if (!businessRepository.existsById(id)) {
            getBusinessNotFoundRuntimeExceptionSupplier(id).get();
        }
        businessRepository.deleteById(id);
    }

    public BusinessService(BusinessRepository businessRepository, BusinessMapper businessMapper) {
        this.businessRepository = businessRepository;
        this.businessMapper = businessMapper;
    }

    private static Supplier<RuntimeException> getBusinessNotFoundRuntimeExceptionSupplier(String id) {
        return () -> new RuntimeException("Bussiness not found: " + id);
    }

}
