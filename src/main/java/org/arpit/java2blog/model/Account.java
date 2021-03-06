/**
 * 
 */
package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author raghav.rampal
 *
 */

@Entity
@Audited
@Table(name="Account")
public class Account {
	
	 @Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;   
	
	@Column(name="accountNumber") 
	private Integer accountNumber;
	
	@Column(name="accountType")
	private String accountType;
	
	@Column(name="accountGroup")
	private String accountGroup;
	
	@Column(name="org")
	private String org;
	
	@Column(name="distributionChannel")
	private String distributionChannel;
	
	@Column(name="accountTypeGroupCode")
	private String accountTypeGroupCode;
	
	@Column(name="distributionCenter")
	private String distributionCenter;
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountGroup() {
		return accountGroup;
	}
	
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	
	public String getOrg() {
		return org;
	}
	
	public void setOrg(String org) {
		this.org = org;
	}
	
	public String getDistributionChannel() {
		return distributionChannel;
	}
	
	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}
	
	public String getAccountTypeGroupCode() {
		return accountTypeGroupCode;
	}
	
	public void setAccountTypeGroupCode(String accountTypeGroupCode) {
		this.accountTypeGroupCode = accountTypeGroupCode;
	}
	
	public String getDistributionCenter() {
		return distributionCenter;
	}
	
	public void setDistributionCenter(String distributionCenter) {
		this.distributionCenter = distributionCenter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
