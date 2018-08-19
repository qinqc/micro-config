package cn.lifehouse.config.service;

import java.util.List;

import cn.lifehouse.config.models.tables.AppProperties;

public interface IConfigService {
	public List<AppProperties> findEffectPropertiesByApplicationProfileLabel(String application, String profile,
			String label);
}
