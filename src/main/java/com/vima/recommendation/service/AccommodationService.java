package com.vima.recommendation.service;

import com.vima.recommendation.model.Accommodation;
import com.vima.recommendation.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public void create(String accomId){
        try {
            var newAccom = Accommodation.builder().accomId(accomId).build();
            accommodationRepository.save(newAccom);
        }catch (Exception e){
            throw e;
        }
    }
}
