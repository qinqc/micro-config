package cn.lifehouse.config.repository;

import java.util.List;

import cn.lifehouse.config.enums.ProfileTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import cn.lifehouse.config.models.tables.App;

public interface AppRepository
		extends JpaRepository<App, Integer>, JpaSpecificationExecutor<App>, QueryDslPredicateExecutor<App> {

	List<App> findByAppNameAndProfileTypeAndAppLabel(String appName, ProfileTypeEnum profileType, String appLabel);
	List<App> findByAppNameAndProfileTypeAndAppLabelAndIdNot(String appName, ProfileTypeEnum profileType, String appLabel,Integer id);

}
