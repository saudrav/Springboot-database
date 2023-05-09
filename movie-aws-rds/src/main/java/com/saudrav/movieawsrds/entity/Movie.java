package com.saudrav.movieawsrds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Movie {
	
//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}

	@Id
    private int mid;	
	
    private String moviename;
    private boolean active = true;
    
    @OneToMany(targetEntity = Theater.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "mid")
    private List<Theater> theaters;

    
}
