package com.arkdev.filmx.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "genre")
public class Genre implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4772231535227719501L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    Integer genreId;

    @Column(name = "genre_name")
    String genreName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "genre")
    Set<Movie> movies;
}
