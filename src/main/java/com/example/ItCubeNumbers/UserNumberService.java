package com.example.ItCubeNumbers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNumberService {

    private final UserNumberRepository userNumberRepository;

    public UserNumberService(UserNumberRepository userNumberRepository) {
        this.userNumberRepository = userNumberRepository;
    }

    public List<UserNumber> findAllUserNumbers() {
        return userNumberRepository.findAll();
    }

    public void deleteUserNumber(Long id) {
        userNumberRepository.delete(userNumberRepository.findById(id).get());
    }

    public UserNumber findUserNumberById(Long id) {
        return userNumberRepository.findById(id).get();
    }

    public void addUserNumber(UserNumber userNumber) {
        userNumberRepository.save(userNumber);
    }

    public List<UserNumber> findUserNumbersSort(UserNumber userNumber) {
        if (!userNumber.getNumber().equals("") && !userNumber.getName().equals("")) {
            return userNumberRepository.findByNumberAndName(userNumber.getNumber(), userNumber.getName());
        } else if (!userNumber.getNumber().equals("")) {
            return userNumberRepository.findAllByNumber(userNumber.getNumber());
        } else if (!userNumber.getName().equals("")) {
            return userNumberRepository.findAllByName(userNumber.getName());
        }
        return userNumberRepository.findAll();
    }
}
