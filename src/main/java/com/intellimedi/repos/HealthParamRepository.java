package com.intellimedi.repos;

import com.intellimedi.entity.HealthParameters;
import com.intellimedi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Set;

@Repository
public interface HealthParamRepository extends JpaRepository<HealthParameters, BigInteger> {
    public Set<HealthParameters> findByUser(User user);
}
