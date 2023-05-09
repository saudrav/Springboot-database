package com.saudrav.movieawsrds.controller;

import com.saudrav.movieawsrds.dto.MovieInfoReq;
import com.saudrav.movieawsrds.dto.MovieListResponse;
import com.saudrav.movieawsrds.dto.TheaterListReq;
import com.saudrav.movieawsrds.dto.TheaterResp;
import com.saudrav.movieawsrds.entity.Movie;
import com.saudrav.movieawsrds.entity.Theater;
import com.saudrav.movieawsrds.repository.MovieRepository;
import com.saudrav.movieawsrds.util.RandomIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieAppController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/addMovie")
    public Movie addnewMovie(@RequestBody MovieInfoReq request){

        List<TheaterListReq> thr = request.getTheaters();

        List<Theater> tMain = new ArrayList<>();

        for(TheaterListReq tt : thr) {
            Theater t = new Theater();
            t.setTid(RandomIdGenerator.generateId());
            t.setTheatername(tt.getTheaterName());
            t.setAvailableseat(tt.getAvailableSeat());
            t.setTicketstatus(tt.getTicketStatus());

            tMain.add(t);
        }

        Movie mv = new Movie();
        mv.setMid(RandomIdGenerator.generateId());
        mv.setMoviename(request.getMovieName());
        mv.setTheaters(tMain);

        return movieRepository.save(mv);
    }

    @GetMapping("/movielist")
    public List<MovieListResponse> showAllMovie(){
        List<Movie> movies = movieRepository.findAll();

        List<MovieListResponse> mlrMain = new ArrayList<>();

        for(Movie mm : movies) {

            List<TheaterResp> trpMain = new ArrayList<>();
            MovieListResponse mlrsp = new MovieListResponse();

            for(Theater tt : mm.getTheaters()) {
                TheaterResp trp = new TheaterResp(tt.getTheatername(), tt.getAvailableseat(), tt.getTicketstatus());
                trpMain.add(trp);
            }
            mlrsp.setMovieName(mm.getMoviename());
            mlrsp.setActive(mm.isActive());
            mlrsp.setTheaters(trpMain);
            mlrMain.add(mlrsp);
        }

        return mlrMain;

    }
}
