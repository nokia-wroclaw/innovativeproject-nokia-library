package com.nokia.library.nokiainnovativeproject.repositories;

import com.nokia.library.nokiainnovativeproject.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT email FROM \"user\" u INNER JOIN user_roles ur ON u.id = ur.user_id " +
            "INNER JOIN role r ON ur.roles_id = r.id WHERE r.role = 'ROLE_ADMIN'",
            nativeQuery = true)
    List<String> getAdminsEmail();

    @Query(value = "SELECT * FROM \"user\" u INNER JOIN user_roles ur ON u.id = ur.user_id " +
            "INNER JOIN role r ON ur.roles_id = r.id WHERE r.role = 'ROLE_ADMIN'",
            nativeQuery = true)
    List<User> getAllAdmins();

    @Query(value = "SELECT password FROM \"user\" u where u.id = ?1",
    nativeQuery = true)
    String getPasswordByUserId(Long id);

    User findUserByEmail(String email);

    @Query(value = "select count(*) from user_roles ur inner join role r ON ur.roles_id = r.id WHERE r.role = ?1",
            nativeQuery = true)
    Long countUserByRole(String role);

    @Query(value = "select * from user_roles ur inner join role r ON ur.roles_id = r.id WHERE r.role = ?1",
            nativeQuery = true)
    List<User> findAllUsersByRole(String role);

    Long countUserByEmail(String email);
}
