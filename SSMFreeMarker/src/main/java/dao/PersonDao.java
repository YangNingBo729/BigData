package dao;

import entity.Person;

public interface PersonDao {
    Person selectById(String id);
}
