package com.zhu.sharding.config;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.zhu.sharding.algorithm.SingleKeyModuloDatabaseShardingAlgorithm;
import com.zhu.sharding.algorithm.SingleKeyModuloTableShardingAlgorithm;

@Configuration
public class ShardDataSourceConfig {

	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${ds1.url}")
	private String url1;
	@Value("${ds1.uname}")
	private String uname1;
	@Value("${ds1.pswd}")
	private String psd1;
	@Value("${ds2.url}")
	private String url2;
	@Value("${ds2.uname}")
	private String uname2;
	@Value("${ds2.pswd}")
	private String psd2;

	private DruidDataSource parentDs() throws SQLException {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUsername(uname1);
		ds.setUrl(url1);
		ds.setPassword(psd1);
		return ds;
	}

	private DataSource ds1() throws SQLException {
		DruidDataSource ds = parentDs();
		ds.setUsername(uname1);
		ds.setUrl(url1);
		ds.setPassword(psd1);
		return ds;
	}

	private DataSource ds2() throws SQLException {
		DruidDataSource ds = parentDs();
		ds.setUsername(uname2);
		ds.setUrl(url2);
		ds.setPassword(psd2);
		return ds;
	}

	private DataSourceRule dataSourceRule() throws SQLException {
		Map<String, DataSource> dataSourceMap = new HashMap<>(2);
		dataSourceMap.put("ds_1", ds1());
		dataSourceMap.put("ds_2", ds2());
		DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);
		return dataSourceRule;
	}

	private TableRule userTableRule() throws SQLException {
		TableRule userTableRule = TableRule.builder("user")
				.actualTables(Arrays.asList("user_1", "user_2","user_3"))
				.dataSourceRule(dataSourceRule()).build();
		return userTableRule;
	}
	private TableRule userInfoTableRule() throws SQLException {
		TableRule userInfoTableRule = TableRule.builder("user_info")
				.actualTables(Arrays.asList("user_info_1", "user_info_2","user_info_3"))
				.dataSourceRule(dataSourceRule()).build();
		return userInfoTableRule;
	}

	private ShardingRule shardingRule() throws SQLException {
		ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule())
				.tableRules(Arrays.asList(userTableRule(),userInfoTableRule()))
				.databaseShardingStrategy(
						new DatabaseShardingStrategy("user_id", new SingleKeyModuloDatabaseShardingAlgorithm()))
				.tableShardingStrategy(new TableShardingStrategy("ctime", new SingleKeyModuloTableShardingAlgorithm()))
				.build();
		return shardingRule;
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		return ShardingDataSourceFactory.createDataSource(shardingRule());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}
}
