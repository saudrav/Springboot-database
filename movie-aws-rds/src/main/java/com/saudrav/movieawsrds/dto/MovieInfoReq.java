package com.saudrav.movieawsrds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfoReq {

    private String movieName;
    private boolean active;
    private List<TheaterListReq> theaters;
    
}
