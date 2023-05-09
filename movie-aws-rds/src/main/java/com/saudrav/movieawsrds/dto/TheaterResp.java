package com.saudrav.movieawsrds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterResp {
	
    private String theaterName;
    private int availableSeat;
    private String ticketStatus;
}
