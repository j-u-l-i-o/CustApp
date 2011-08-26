/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julio
 */
@Entity
@Table(name = "DISCOUNT_CODE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "DiscountCode.findAll",
	query = "SELECT d FROM DiscountCode d"),
	@NamedQuery(name = "DiscountCode.findByDiscountCode",
	query = "SELECT d FROM DiscountCode d WHERE d.discountCode = :discountCode"),
	@NamedQuery(name = "DiscountCode.findByRate",
	query = "SELECT d FROM DiscountCode d WHERE d.rate = :rate")})
public class DiscountCode implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNT_CODE")
	private Character discountCode;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "RATE")
	private BigDecimal rate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "discountCode")
	private List<Customer> customerList;

	public DiscountCode() {
	}

	public DiscountCode(Character discountCode) {
		this.discountCode = discountCode;
	}

	public Character getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(Character discountCode) {
		this.discountCode = discountCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@XmlTransient
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (discountCode != null ? discountCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof DiscountCode)) {
			return false;
		}
		DiscountCode other = (DiscountCode) object;
		if ((this.discountCode == null && other.discountCode != null) || (this.discountCode != null && !this.discountCode.equals(other.discountCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.customerapp.entity.DiscountCode[ discountCode=" + discountCode + " ]";
	}
	
}
