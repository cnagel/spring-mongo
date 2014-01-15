package com.surpreso.spring_mongo;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import com.surpreso.spring_mongo.beans.Foo;
import com.surpreso.spring_mongo.config.DefaultConfig;
import com.surpreso.spring_mongo.dao.FooRepository;

/**
 * A simple "Hello world" application using the MongoDB repository to save a
 * document and output all documents in the collection. Needs a running MongoDB
 * environment.
 * 
 * @author Christoph Nagel
 */
@Import(DefaultConfig.class)
public class HelloWorldApplication implements CommandLineRunner {

	@Inject
	private FooRepository repo;

	public static void main(String... args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// get size of the collection
		long count = repo.count();
		// create new document
		Foo foo = new Foo();
		foo.setId(count + 1);
		foo.setName("Foo " + foo.getId());
		// add new document to collection
		repo.save(foo);
		// output collection info
		System.out.println("= Found " + repo.count()
				+ " documents in Foo collection");
		for (Foo f : repo.findAll()) {
			System.out.println("+ " + f);
		}
	}

}