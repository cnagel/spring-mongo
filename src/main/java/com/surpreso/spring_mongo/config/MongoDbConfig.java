package com.surpreso.spring_mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;

/**
 * The MongoDB configuration. Gets only loaded if there exists no profile.
 * 
 * @author Christoph Nagel
 */
@Profile("default")
@Configuration
@EnableMongoRepositories(basePackages = "com.surpreso.spring_mongo.dao")
public class MongoDbConfig extends AbstractMongoConfiguration {

	@Value("${mongo.url}")
	private String url;

	@Value("${mongo.db}")
	private String databaseName;

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Mongo(new MongoURI(url));
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.surpreso.spring_mongo.beans";
	}

}
