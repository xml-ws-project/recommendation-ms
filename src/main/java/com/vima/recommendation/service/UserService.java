package com.vima.recommendation.service;

import com.vima.recommendation.model.Accommodation;
import com.vima.recommendation.model.User;
import com.vima.recommendation.model.props.Rate;
import com.vima.recommendation.repository.AccommodationRepository;
import com.vima.recommendation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AccommodationRepository accommodationRepository;

    public void create(String userId){
       try{
           var newUser = User.builder().userId(userId).build();
           userRepository.save(newUser);
       }catch (Exception e){
           throw e;
       }
    }

    public void createRelationship(String userId, String accomId, int value){
        var user = userRepository.findByUserId(userId).orElseThrow();
        var accom = accommodationRepository.findByAccomId(accomId).orElseThrow();
        if(value == -1) createReserveRel(user,accom);
        else createRateRel(user,accom,value);
    }

    private void createReserveRel(User user, Accommodation accom) {
        user.getAccomodations().add(accom);
        userRepository.save(user);
    }

    private void createRateRel(User user, Accommodation accom, int value) {
        user.getRates().add(Rate.builder().accommodation(accom).value(value).build());
        userRepository.save(user);
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }

}
