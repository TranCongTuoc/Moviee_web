package com.arkdev.filmx.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_package")
public class UserPackage implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_package_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    Integer userPackageId;

    @Column(name = "amount")
    Double amount;

    @Column(name = "price")
    Double price;

    @Column(name = "payment_method")
    String paymentMethod;

    @Column(name = "payment_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    Timestamp paymentAt;

    @Column(name = "expired_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    Timestamp expiredAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id")
    PackageType aPackageType;
}
