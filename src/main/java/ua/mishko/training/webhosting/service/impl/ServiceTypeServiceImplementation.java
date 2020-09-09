package ua.mishko.training.webhosting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.mishko.training.webhosting.domain.Service;
import ua.mishko.training.webhosting.repository.ServiceRepository;
import ua.mishko.training.webhosting.service.ServiceTypeService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceTypeServiceImplementation implements ServiceTypeService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceTypeServiceImplementation(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }
}
