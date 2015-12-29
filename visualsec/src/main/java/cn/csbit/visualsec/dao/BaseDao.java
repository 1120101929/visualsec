package cn.csbit.visualsec.dao;

import java.util.List;

public interface BaseDao {

	/**
	 * 增
	 * 
	 * @param entity
	 */
	<T> void save(T entity);

	/**
	 * 删
	 * 
	 * @param id
	 * @param clazz
	 */
	<T> void delete(Long id, Class<T> clazz);

	/**
	 * 改
	 * 
	 * @param entity
	 */
	<T> void update(T entity);

	/**
	 * 查
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	<T> T getById(Long id, Class<T> clazz);

	/**
	 * 查
	 * 
	 * @param ids
	 * @param clazz
	 * @return
	 */
	<T> List<T> getByIds(Long[] ids, Class<T> clazz);

	/**
	 * 查
	 * 
	 * @param clazz
	 * @return
	 */
	<T> List<T> findAll(Class<T> clazz);

}