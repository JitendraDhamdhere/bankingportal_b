package com.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;

	@Column(unique = true)
	private String email;
	private String address;
	private String phone_number;
	private int otpRetryCount;
	private LocalDateTime lastOtpRequestTime;

	@JsonManagedReference // Prevents infinite recursion
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Account getAccount() {
		return account;
	}

	// Convenience method to set the user's account
	public void setAccount(Account account) {
		this.account = account;
		account.setUser(this);
	}

	public int getOtpRetryCount() {
		return otpRetryCount;
	}

	public void setOtpRetryCount(int otpRetryCount) {
		this.otpRetryCount = otpRetryCount;
	}

	public LocalDateTime getLastOtpRequestTime() {
		return lastOtpRequestTime;
	}

	public void setLastOtpRequestTime(LocalDateTime lastOtpRequestTime) {
		this.lastOtpRequestTime = lastOtpRequestTime;
	}

}
