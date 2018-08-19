package cn.lifehouse.config.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "cn.lifehouse.config.repository")
@EntityScan(basePackages = "cn.lifehouse.config.models.tables")
public class JpaConfig {

}
