package com.nokia.library.nokiainnovativeproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rental implements Serializable {

	public Rental() {
		this.isCurrent = true;
		this.returnDate = LocalDateTime.now().plusMonths(1);
	}

	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Setter(AccessLevel.NONE)
	private Date rentalDate;

	protected Boolean isCurrent = true;
	protected Boolean wasProlonged = false;

	protected LocalDateTime returnDate;
	protected LocalDateTime handOverDate;

	@ManyToOne(cascade = {CascadeType.MERGE,
			CascadeType.PERSIST})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id")
	protected User user;

	@ManyToOne(cascade = {CascadeType.MERGE,
			CascadeType.PERSIST})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "book_catalog_number")
	protected Book book;
}
