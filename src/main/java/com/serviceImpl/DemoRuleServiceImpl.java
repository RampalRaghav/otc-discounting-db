package com.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DemoRuleDao;
import com.form.DemoForm;
import com.model.Account;
import com.model.Discount;
import com.model.Offer;
import com.model.OrderLine;
import com.model.Product;
import com.model.RuleSetup;
import com.model.StandardRuleSetup;
import com.service.DemoRuleService;

@Service
public class DemoRuleServiceImpl implements DemoRuleService{
	
	@Autowired
	DemoRuleDao demoRuleDao;
	
	@Override
	public void addRule(DemoForm demoForm) {
		//HashMap<Integer, Integer> map = new HashMap();
		RuleSetup ruleSetup = new RuleSetup();
		ruleSetup.setRuleNumber(demoForm.getRuleNumber());
		ruleSetup.setRuleName(demoForm.getRuleName());
		Account account = new Account();
		account.setAccountNumber(demoForm.getAccountNumber());
		if(demoForm.getAccountType().equals("")) {
			account.setAccountType(null);
		}else {
			account.setAccountType(demoForm.getAccountType());
		}
		ruleSetup.setAccount(account);
		Product product = new Product();
		if(demoForm.getFc().equals("")) {
			product.setFamilyCode(null);
		}else {
			product.setFamilyCode(demoForm.getFc());
		}
		product.setIsbn(demoForm.getIsbn());
		if(demoForm.getDgp().equals("")) {
			product.setProductGroupCode(null);
		}else {
			product.setProductGroupCode(demoForm.getDgp());
		}
		ruleSetup.setProduct(product);
		Discount discount = new Discount();
		discount.setPercentage(demoForm.getDiscount());
		ruleSetup.setDiscount(discount);
		Offer offer =new Offer();
		offer.setComboField(demoForm.getCombo());
		offer.setHardcode(demoForm.isHardcode());
		offer.setPriority(demoForm.getPriority());
		offer.setOverridenExplicitly(demoForm.isOverridenExplicitly());

		offer.setDays(demoForm.getTerms());
		offer.setFrieghtCharge(demoForm.getFrieghtCharge());

		ruleSetup.setOffer(offer);

		ruleSetup.setDiscountRange1(demoForm.getDiscountRange1());
		ruleSetup.setDiscountRange2(demoForm.getDiscountRange2());
		ruleSetup.setQuantityRange1(demoForm.getQuantityRange1());
		ruleSetup.setQuantityRange2(demoForm.getQuantityRange2());

		/*if(demoForm.getQuantityRange1()!=null && demoForm.getDiscountRange1()!=null) {
			map.put(demoForm.getQuantityRange1(), demoForm.getDiscountRange1());
		}
		if(demoForm.getQuantityRange2()!=null && demoForm.getDiscountRange2()!=null) {
			map.put(demoForm.getQuantityRange2(), demoForm.getDiscountRange2());
		}*/
		//ruleSetup.setMap(map);
		demoRuleDao.addRuleSetUp(ruleSetup);
	}

	@Override
	public List<RuleSetup> getRuleSetupList() {
		// TODO Auto-generated method stub
		return demoRuleDao.getAllRuleSetup();
	}

	@Override
	public void addStandardRule(DemoForm demoForm) {
		//HashMap<Integer, Integer> map = new HashMap();
				StandardRuleSetup standardRuleSetup = new StandardRuleSetup();
				standardRuleSetup.setRuleNumber(demoForm.getRuleNumber());
				standardRuleSetup.setRuleName(demoForm.getRuleName());
				Account account = new Account();
				account.setAccountNumber(demoForm.getAccountNumber());
				if("".equals(demoForm.getAccountType())) {
					account.setAccountType(null);
				}else {
					account.setAccountType(demoForm.getAccountType());
				}
				standardRuleSetup.setAccount(account);
				Product product = new Product();
				if("".equals(demoForm.getFc())) {
					product.setFamilyCode(null);
				}else {
					product.setFamilyCode(demoForm.getFc());
				}
				product.setIsbn(demoForm.getIsbn());
				if("".equals(demoForm.getDgp())) {
					product.setProductGroupCode(null);
				}else {
					product.setProductGroupCode(demoForm.getDgp());
				}
				standardRuleSetup.setProduct(product);
				Discount discount = new Discount();
				discount.setPercentage(demoForm.getDiscount());
				standardRuleSetup.setDiscount(discount);
				standardRuleSetup.setDiscountRange1(demoForm.getDiscountRange1());
				standardRuleSetup.setDiscountRange2(demoForm.getDiscountRange2());
				standardRuleSetup.setQuantityRange1(demoForm.getQuantityRange1());
				standardRuleSetup.setQuantityRange2(demoForm.getQuantityRange2());
				standardRuleSetup.setQuantityRange3(demoForm.getQuantityRange3());
				standardRuleSetup.setDiscountRange3(demoForm.getDiscountRange3());

				/*if(demoForm.getQuantityRange1()!=null && demoForm.getDiscountRange1()!=null) {
					map.put(demoForm.getQuantityRange1(), demoForm.getDiscountRange1());
				}
				if(demoForm.getQuantityRange2()!=null && demoForm.getDiscountRange2()!=null) {
					map.put(demoForm.getQuantityRange2(), demoForm.getDiscountRange2());
				}*/
				//ruleSetup.setMap(map);
				demoRuleDao.addStandradRuleSetUp(standardRuleSetup);
		
	}

	@Override
	public List<StandardRuleSetup> getStandardRuleSetupList() {
		return demoRuleDao.getAllStandardRuleSetup();
		
	}

	@Override
	public List<OrderLine> getOrderSetupList() {
		return demoRuleDao.getAllOrderLineSetup();
	}

	@Override
	public void addOrder(DemoForm demoForm) {
			OrderLine orderLine = new OrderLine();
			orderLine.setOrderLineId(demoForm.getOrderLineNumber());
			Account account = new Account();
			account.setAccountNumber(demoForm.getAccountNumber());
			account.setAccountType(demoForm.getAccountType());
			orderLine.setAccount(account);
			Product product = new Product();
			product.setFamilyCode(demoForm.getFc());
			product.setIsbn(demoForm.getIsbn());
			product.setProductGroupCode(demoForm.getDgp());
			orderLine.setProduct(product);
			orderLine.setQuantity(demoForm.getQuantity());
			demoRuleDao.addOrderLineSetUp(orderLine);

		}
		
	}
	
	
	
   

