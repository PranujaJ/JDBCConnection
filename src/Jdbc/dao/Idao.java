package Jdbc.dao;

import java.util.Collection;

public interface Idao<T,K>{
	
	Collection<T> getAll();
	T getOne(K key);
	void create(T t);
}
