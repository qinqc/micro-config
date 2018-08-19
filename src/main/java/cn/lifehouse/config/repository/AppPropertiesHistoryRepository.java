package cn.lifehouse.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import cn.lifehouse.config.models.tables.AppPropertiesHistory;

public interface AppPropertiesHistoryRepository extends JpaRepository<AppPropertiesHistory, Integer>,
		JpaSpecificationExecutor<AppPropertiesHistory>, QueryDslPredicateExecutor<AppPropertiesHistory> {

	List<AppPropertiesHistory> findByOldId(Integer profileId);

	List<AppPropertiesHistory> findByOldIdOrderByUpdateTimeDesc(Integer profileId);

}
