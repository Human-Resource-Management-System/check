package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.Holiday;

@Repository
public class HolidayDAOImpl implements HolidayDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Holiday> findAllHolidays() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Holiday> cq = cb.createQuery(Holiday.class);
		Root<Holiday> root = cq.from(Holiday.class);
		cq.select(root);
		cq.orderBy(cb.asc(root.get("hday_date")));
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public Holiday findHolidayById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveHoliday(Holiday holiday) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHoliday(Holiday holiday) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHoliday(Holiday holiday) {
		// TODO Auto-generated method stub

	}

}
