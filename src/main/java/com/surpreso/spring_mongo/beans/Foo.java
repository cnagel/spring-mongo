package com.surpreso.spring_mongo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

/**
 * A very simple JSON bean.
 * 
 * @author Christoph Nagel
 */
@Document
public class Foo {

	@Id
	private Long id;
	private String name;

	public Foo() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!getClass().isInstance(obj)) {
			return false;
		}
		Foo foo = (Foo) obj;
		return Objects.equal(getId(), foo.getId())
				&& Objects.equal(getName(), foo.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getName());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(getId())
				.addValue(getName()).toString();
	}

}