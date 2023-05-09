package com.saudrav.movieawsrds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String theatername;
    private int availableseat;
    private String ticketstatus;    

    @ManyToOne
    @JoinColumn(name = "cp_fk")
    private Movie movie;
    
}
