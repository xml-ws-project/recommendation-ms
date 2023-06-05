package com.vima.recommendation.service;

import com.vima.recommendation.model.Accommodation;
import com.vima.recommendation.model.User;
import com.vima.recommendation.repository.AccommodationRepository;
import com.vima.recommendation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final AccommodationRepository accommodationRepository;

    public List<String> recommend(String userId){
        var similarUsers = userRepository.getSimilarUsers(userId);
        var highRatedAccoms = accommodationRepository.getHighlyRatedAccommodations(getUserIds(similarUsers));
        var filteredAccoms = accommodationRepository.filterOutPoorlyRated(getAccomIds(highRatedAccoms));
        return getAccomIds(accommodationRepository.sortAccommodationsByAverageGrade(getAccomIds(filteredAccoms)));
    }

    private List<String> getUserIds(List<User> list){
        List<String> retList = new ArrayList<>();
        list.forEach(item ->{
            retList.add(item.getUserId());
        });

        return  retList;
    }

    private List<String> getAccomIds(List<Accommodation> list){
        List<String> retList = new ArrayList<>();
        list.forEach(item ->{
            retList.add(item.getAccomId());
        });

        return  retList;
    }
}
