package com.arkdev.filmx.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1556023293553118324L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    Long movieId;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.LONGNVARCHAR)
    String description;

    @Column(name = "release_date")
    @JdbcTypeCode(SqlTypes.DATE)
    @Temporal(TemporalType.DATE)
    Date releaseDate;

    @Column(name = "duration")
    Integer duration;

    @Column(name = "trailer")
    String trailer;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    Genre genre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
    Set<Episode> episodes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
    Set<Review> reviews;
}
