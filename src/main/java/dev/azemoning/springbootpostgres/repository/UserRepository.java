package dev.azemoning.springbootpostgres.repository;

import dev.azemoning.springbootpostgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
