package ru.jaju.financemanagerserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jaju.financemanagerserver.data.user.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByLogin(@NotNull @Size(min = 5, max = 20) String login);
}
