package com.surpreso.spring_mongo.dao;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.surpreso.spring_mongo.beans.Foo;
import com.surpreso.spring_mongo.config.DefaultConfig;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DefaultConfig.class }, loader = SpringApplicationContextLoader.class)
public class FooRepositoryTests {

	@Inject
	FooRepository repo;

	@Test
	public void test_basicOperations() throws Exception {
		// check if collection is empty
		assertEquals(0, repo.count());
		// create new document
		Foo foo = new Foo();
		foo.setId(1l);
		foo.setName("Foo 1");
		repo.save(foo);
		// store new document
		repo.save(foo);
		// check if document stored
		assertEquals(1, repo.count());
		// check stored document
		assertEquals(foo, repo.findOne(1l));
	}

}
