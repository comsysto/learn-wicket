package com.comsysto.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private double cashBalance;
	private String name;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public String getIdFrontend() {
        return id == null ? "" : String.valueOf(id);
    }

    public String getCashBalanceFrontend() {
        return String.valueOf(cashBalance);
    }

	@Override
	public String toString() {
		return  "id: " + id + ", balance: " + cashBalance + ", name: " + name;

	}

}