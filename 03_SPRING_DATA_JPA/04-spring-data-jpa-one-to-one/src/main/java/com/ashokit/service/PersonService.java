package com.ashokit.service;

import com.ashokit.entity.Passport;
import com.ashokit.entity.Person;
import com.ashokit.repo.PassportRepository;
import com.ashokit.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    public void savePersonWithPassport(){
        Passport passport=new Passport();
        passport.setPassportNum("K876BJ");
        passport.setIssueDate(LocalDate.now());
        passport.setExpiryDate(LocalDate.now().plusYears(10));

        Person person=new Person();
        person.setName("Dilip");
        person.setGender("Male");

        // associate entity
        passport.setPerson(person);
        person.setPassport(passport);

        personRepository.save(person);

    }

}
