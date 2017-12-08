package com.service;

import java.util.List;

import com.form.DemoForm;
import com.model.OrderLine;
import com.model.RuleSetup;
import com.model.StandardRuleSetup;


public interface DemoRuleService<T> {
    void addRule(DemoForm demoForm);
	public List<RuleSetup>getRuleSetupList();
	void addStandardRule(DemoForm demoForm);
	public List<StandardRuleSetup>getStandardRuleSetupList();
	public List<OrderLine>getOrderSetupList();
	void addOrder(DemoForm demoForm);
}
