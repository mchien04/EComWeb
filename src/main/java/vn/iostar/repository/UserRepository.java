package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer>{

}
