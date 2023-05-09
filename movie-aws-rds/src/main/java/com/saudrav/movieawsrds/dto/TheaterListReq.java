package com.saudrav.movieawsrds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterListReq {
	
    private String theaterName;
    private int availableSeat;
    private String ticketStatus;
}
