package service;

import entity.Person;

public interface PersonService {
    Person selectById(String id);
}
