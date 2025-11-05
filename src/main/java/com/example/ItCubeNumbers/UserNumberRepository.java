package com.example.ItCubeNumbers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNumberRepository extends JpaRepository<UserNumber, Long> {
    List<UserNumber> findByNumberAndName(String number, String name);
    List<UserNumber> findAllByNumber(String number);
    List<UserNumber> findAllByName(String name);
}
