package cn.csbit.visualsec.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.csbit.visualsec.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public <T> void save(T entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public <T> void delete(Long id, Class<T> clazz) {
		getCurrentSession().createQuery("DELETE FROM " + clazz.getSimpleName() + " WHERE id = ?").setParameter(0, id)
				.executeUpdate();
	}

	@Override
	public <T> void update(T entity) {
		getCurrentSession().update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getById(Long id, Class<T> clazz) {
		return (T) getCurrentSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id = ?")
				.setParameter(0, id).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> getByIds(Long[] ids, Class<T> clazz) {
		if (ids == null || ids.length == 0) {
			return Collections.emptyList();
		}

		return getCurrentSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN (?)")
				.setParameter(0, ids).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz) {
		return getCurrentSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}
}
