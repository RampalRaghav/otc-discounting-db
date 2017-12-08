package com.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.DemoRuleDao;
import com.model.OrderLine;
import com.model.RuleSetup;
import com.model.StandardRuleSetup;;

@Repository
public class DemoRuleDaoImpl implements DemoRuleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@PersistenceContext
	private EntityManager entityManager;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	@Transactional
	public void addRuleSetUp(RuleSetup ruleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(ruleSetUp);
	}
	@Override
	@Transactional
	public List<RuleSetup> getAllRuleSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RuleSetup>  ruleSetUpList = session.createQuery("from RuleSetup").list();
		return ruleSetUpList;
	}
	@Override
	@Transactional
	public void updateRuleSetUp(RuleSetup ruleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(ruleSetUp);
		session.update(ruleSetUp);
	}
	@Override
	@Transactional
	public void deleteRuleSetUp(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		RuleSetup p = (RuleSetup) session.load(RuleSetup.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
	@Override
	@Transactional
	public void addStandradRuleSetUp(StandardRuleSetup standardRuleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(standardRuleSetUp);
		
	}
	@Override
	@Transactional
	public List<StandardRuleSetup> getAllStandardRuleSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StandardRuleSetup>  standardRuleSetUpList = session.createQuery("from StandardRuleSetup").list();
		return standardRuleSetUpList;
	}
	@Override
	@Transactional
	public List<OrderLine> getAllOrderLineSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderLine>  orderLineSetUpList = session.createQuery("from OrderLine").list();
		return orderLineSetUpList;
	}
	@Override
	@Transactional
	public void addOrderLineSetUp(OrderLine orderLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orderLine);
		
	}

}
