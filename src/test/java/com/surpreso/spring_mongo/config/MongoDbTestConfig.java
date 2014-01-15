package com.surpreso.spring_mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.foursquare.fongo.Fongo;
import com.mongodb.Mongo;

/**
 * The MongoDB config for the test environment. Loads Fongo instead of Mongo,
 * which is an in-memory implementation developed by FourSquare.
 * 
 * @author Christoph Nagel
 */
@Profile("test")
@Configuration
public class MongoDbTestConfig extends MongoDbConfig {

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo("foo test server").getMongo();
	}

}
