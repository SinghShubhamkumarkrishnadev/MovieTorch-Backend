package com.movieTorch.movieTorch.controller;

import com.movieTorch.movieTorch.service.*;
import com.movieTorch.movieTorch.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    
    @Autowired
    private TMDBService tmdbService;
    
    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieResponse> getPopularMovies() {
        return tmdbService.getPopularMovies();
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieDetail> getMovieDetails(@PathVariable int id) {
        return tmdbService.getMovieDetails(id);
    }
    
    @GetMapping(value = "/search")
    public Mono<MovieResponse> searchMovies(@RequestParam String query){
    	return tmdbService.searchMovies(query);
    }
    
    @GetMapping(value = "/top_rated", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieResponse> getTopRatedResponse(){
    	return tmdbService.getTopRatedResponse();
    }  
    
    @GetMapping(value = "/upcoming", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UpcomingMovieResponse> getupcomingResponse(){
    	return tmdbService.getupcomingResponse();
    }  
    
    @GetMapping(value = "/now_playing", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<NowPlayingMovieResponse> getnowPlayingResponse(){
    	return tmdbService.getnowPlayingResponse();
    }  
    
    @GetMapping(value = "/{id}/recommendations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieResponse> getRecommnedation(@PathVariable int id) {
    	return  tmdbService.getRecommnedation(id);
    }
    
    @GetMapping(value = "/{id}/credits", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CreditResponse> getCreditsResponse(@PathVariable int id){
    	return tmdbService.getCreditsResponse(id);
    }
    
    @GetMapping(value = "/{id}/images", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ImageResponse> getImageResponse(@PathVariable int id){
    	return tmdbService.getImageResponse(id);
    }
    
    @GetMapping(value = "/{id}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MovieResponse> getSimilarResponse(@PathVariable int id){
    	return tmdbService.getSimilarResponse(id);
    }
    
    @GetMapping(value = "/{id}/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ReviewResponse> getReviewResponse(@PathVariable int id){
    	return tmdbService.getReviewResponse(id);
    }
    
    @GetMapping(value = "/{id}/keywords", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<KeywordResponse> getKeywordResponse(@PathVariable int id){
    	return tmdbService.getKeywordResponse(id);
    } 
    
    @GetMapping(value = "/{id}/videos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<VideoResponse> getVideoResponse(@PathVariable int id){
        return tmdbService.getVideoResponse(id);
    }
}
