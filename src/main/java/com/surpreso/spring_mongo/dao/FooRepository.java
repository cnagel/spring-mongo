package com.surpreso.spring_mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.surpreso.spring_mongo.beans.Foo;

/**
 * The MongoDB repository for the {@link Foo} bean.
 * 
 * @author Christoph Nagel.
 */
@Repository
public interface FooRepository extends MongoRepository<Foo, Long> {

}