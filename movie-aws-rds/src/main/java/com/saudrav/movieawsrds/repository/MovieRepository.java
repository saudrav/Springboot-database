package com.saudrav.movieawsrds.repository;

import com.saudrav.movieawsrds.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

//   @Query("SELECT new com.saudrav.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
//    public List<OrderResponse> getJoinInformation();
	
}
