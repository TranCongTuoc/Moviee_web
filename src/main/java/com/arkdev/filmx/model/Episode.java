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
@Table(name = "episode")
public class  Episode implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8969376660518595526L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    Long episodeId;

    @Column(name = "episode")
    String episode;

    @Column(name = "title")
    String title;

    @Column(name = "duration")
    Integer duration;

    @Column(name = "video_url")
    String videoUrl;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    @JdbcTypeCode(SqlTypes.DATE)
    Date releaseDate;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "episode", cascade = CascadeType.ALL)
    Set<WatchHistory> watchHistories;

    @OneToOne
    @JoinColumn(name = "package_id")
    PackageType packageType;
}
