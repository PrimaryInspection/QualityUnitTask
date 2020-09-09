package ua.mishko.training.webhosting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mishko.training.webhosting.domain.Variation;
import ua.mishko.training.webhosting.repository.VariationRepository;
import ua.mishko.training.webhosting.service.VariationService;

import java.util.List;

@Service
public class VariationServiceImplementation implements VariationService {

    private final VariationRepository variationRepository;

    @Autowired
    public VariationServiceImplementation(VariationRepository variationRepository) {
        this.variationRepository = variationRepository;
    }

    @Override
    public List<Variation> getVariations() {
        return variationRepository.findAll();
    }
}
