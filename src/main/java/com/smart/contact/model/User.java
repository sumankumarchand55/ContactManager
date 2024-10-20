package com.smart.contact.model;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="USERR")
public class User implements UserDetails{

   /**
	 *
	 */
	private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @NotBlank(message="Name is required!!!")
    @Size(min=2,max=20,message="min 2 and max 20 characters are allowed!!!")
	private String name;
	@Column(unique = true)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message="invalid email address")
	private String email;

	/*
	 * @Size(min=8,max=20,message="length should between 8 to 20 characters!!!")
	 *
	 * @Pattern(regexp=
	 * "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
	 * message=" At least one special character, Upper case and a digit(example:Rajes@123)"
	 * )
	 */
	@Size(min=8,message="length should min 8 characters!!!")
	@Column(nullable = false)
	private String password;
	private boolean enabled=false;
	private String imageUrl;
	@Column(length = 500)
	@NotBlank(message="description is required!!!")
    @Size(min=10,message="description contain minimum 10 characters!!!")
	private String about;
	private Date dob;
	@AssertTrue(message="(please accept terms and conditions!!!!!)")
	private boolean agreed;
	@Pattern(regexp="^[0-9]{10}$", message="Phone number must be 10 digits long, Ex-1234567890")
	@NotBlank(message="Phone number is required!!!")
	private String phoneNumber;
	private boolean phoneVeryfied=false;
	private boolean emailVeryfied=false;
	private UUID generatedUserId;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime creatAt;
	@UpdateTimestamp
	private LocalDateTime updateAt;
	private String cloudinaryImagePublicId;
	private String passwordResetToken;

	public String getPasswordResetToken() {
		return passwordResetToken;
	}


	public void setPasswordResetToken(String passwordResetToken) {
		this.passwordResetToken = passwordResetToken;
	}
	/*
	 * PROVIDERS
	 */
	@Enumerated(value=EnumType.STRING)
	private Providers provider=Providers.SELF;
	private String providerUserId;

	@Override
	public String toString() {
	    return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password +
	           ", enabled=" + enabled + ", imageUrl=" + imageUrl +
	           ", about=" + about + ", dob=" + dob + ", agreed=" + agreed +
	           ", phoneNumber=" + phoneNumber + ", phoneVeryfied=" + phoneVeryfied +
	           ", emailVeryfied=" + emailVeryfied + ", provider=" + provider +
	           ", providerUserId=" + providerUserId + "]";
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public boolean isPhoneVeryfied() {
		return phoneVeryfied;
	}


	public void setPhoneVeryfied(boolean phoneVeryfied) {
		this.phoneVeryfied = phoneVeryfied;
	}


	public boolean isEmailVeryfied() {
		return emailVeryfied;
	}


	public void setEmailVeryfied(boolean emailVeryfied) {
		this.emailVeryfied = emailVeryfied;
	}


	public Providers getProvider() {
		return provider;
	}


	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	public UUID getGeneratedUserId() {
		return generatedUserId;
	}


	public void setGeneratedUserId(UUID generatedUserId) {
		this.generatedUserId = generatedUserId;
	}


	public String getProviderUserId() {
		return providerUserId;
	}


	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}


	public boolean isAgreed() {
		return agreed;
	}


	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Contact> contacts= new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String emailToken;

	
	public String getEmailToken() {
		return emailToken;
	}


	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public LocalDateTime getCreatAt() {
		return creatAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}



	 public String getCloudinaryImagePublicId() {
		return cloudinaryImagePublicId;
	}


	public void setCloudinaryImagePublicId(String cloudinaryImagePublicId) {
		this.cloudinaryImagePublicId = cloudinaryImagePublicId;
	}


	public String getFormattedCreatedAt() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm:ss a");
	        return creatAt != null ? creatAt.format(formatter) : "";
	    }

	    // New method for formatted updatedAt
	    public String getFormattedUpdatedAt() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm:ss a");
	        return updateAt != null ? updateAt.format(formatter) : "";
	    }

	                         //unimplement methods override section

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roleList =new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	Collection<SimpleGrantedAuthority> roles=roleList
			.stream()
			.map(role-> new SimpleGrantedAuthority(role))
			.collect(Collectors.toList());
		    return roles;
	}
	public List<String> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
}
