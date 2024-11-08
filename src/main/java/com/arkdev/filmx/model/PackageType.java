package com.arkdev.filmx.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "package_type")
public class PackageType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7552258378638888028L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer packageId;

    @Column(name = "package_name")
    String packageName;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.FLOAT)
    Double price;

    @Column(name = "description")
    String description;

    @Column(name = "duration")
    @JdbcTypeCode(SqlTypes.INTEGER)
    Integer duration;

    @OneToOne(mappedBy = "packageType")
    Episode episode;
}
