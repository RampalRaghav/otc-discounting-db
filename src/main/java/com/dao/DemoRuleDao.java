package com.dao;

import java.util.List;

import com.model.OrderLine;
import com.model.RuleSetup;
import com.model.StandardRuleSetup;;

public interface DemoRuleDao {
	
	public void addRuleSetUp(RuleSetup ruleSetUp);
	public List<RuleSetup> getAllRuleSetup();
	public void addStandradRuleSetUp(StandardRuleSetup standardRuleSetUp);
	public List<StandardRuleSetup> getAllStandardRuleSetup();
	public List<OrderLine> getAllOrderLineSetup();
	public void addOrderLineSetUp(OrderLine orderLine);
	public void deleteRuleSetUp(int id) ;
	public void updateRuleSetUp(RuleSetup ruleSetUp);

}
