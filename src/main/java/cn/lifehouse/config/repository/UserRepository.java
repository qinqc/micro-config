package cn.lifehouse.config.repository;

import cn.lifehouse.config.models.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, QueryDslPredicateExecutor<User> {

    User findByAccount(String account);
}
