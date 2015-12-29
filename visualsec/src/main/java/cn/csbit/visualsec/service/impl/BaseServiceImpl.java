package cn.csbit.visualsec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csbit.visualsec.dao.BaseDao;
import cn.csbit.visualsec.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl implements BaseService {
	@Autowired
	private BaseDao baseDao;

	@Override
	public <T> void add(T entity) {
		this.baseDao.save(entity);
	}

	@Override
	public <T> void delete(Long id, Class<T> clazz) {
		this.baseDao.delete(id, clazz);
	}

	@Override
	public <T> void update(T entity) {
		this.baseDao.update(entity);
	}

	@Override
	public <T> T getById(Long id, Class<T> clazz) {
		return this.baseDao.getById(id, clazz);
	}

	@Override
	public <T> List<T> getByIds(Long[] ids, Class<T> clazz) {
		return this.baseDao.getByIds(ids, clazz);
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return this.baseDao.findAll(clazz);
	}
}
