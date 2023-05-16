package com.intellimedi.service;

import com.intellimedi.entity.HealthParameters;
import com.intellimedi.entity.User;
import com.intellimedi.exception.EmptyRequestException;
import com.intellimedi.exception.UserDoesNotExistException;
import com.intellimedi.repos.HealthParamRepository;
import com.intellimedi.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HealthParameterService {
     private final HealthParamRepository healthParamRepo;
    private final UserRepository userRepo;

    public HealthParameterService(HealthParamRepository healthParamRepo, UserRepository userRepo) {
        this.healthParamRepo = healthParamRepo;
        this.userRepo = userRepo;
    }

    public HealthParameters addHealthParam(HealthParameters healthParam) throws EmptyRequestException {
        if(healthParam !=null){
            return healthParamRepo.save(healthParam);
        }
        throw new EmptyRequestException("Health Parameter details passed is empty.Please share proper details.");
    }

    public void deleteById(BigInteger id) {
        healthParamRepo.deleteById(id);
    }

    public HealthParameters getHealthParamById(BigInteger id) {
       java.util.Optional<HealthParameters> paramOpt = healthParamRepo.findById(id);
       if(paramOpt.isPresent()){
           return paramOpt.get();
       }else{
           return null;
       }
    }

    public Set<HealthParameters> getHealthParamsByUser(BigInteger userId) throws UserDoesNotExistException {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()) {
            return healthParamRepo.findByUser(user.get());
        }
        throw new UserDoesNotExistException("User does not exist.Please request for a valid user");
    }

    public HealthParameters getLatestHealthParamsByUser(BigInteger userId) throws UserDoesNotExistException {

            Set<HealthParameters> paramList= getHealthParamsByUser(userId);
        LinkedHashSet<HealthParameters> sortedParamList=paramList.stream().sorted(Comparator.comparing(HealthParameters::getDateOfMeasurement, (s1, s2) -> {
                return s2.compareTo(s1);
            })).collect(Collectors.toCollection(LinkedHashSet::new));
        return sortedParamList.iterator().next();
    }
}
