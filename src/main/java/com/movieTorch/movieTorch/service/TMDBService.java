package com.movieTorch.movieTorch.service;

import com.movieTorch.movieTorch.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.net.ConnectException;
import java.net.SocketException;

@Service
public class TMDBService {

	@Autowired
	private WebClient webClient;

	@Value("${tmdb.api.key}")
	private String apiKey;

	public Mono<MovieResponse> getPopularMovies() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/movie/popular").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(MovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error searching movies: " + e.getMessage(), e));

	}

	public Mono<MovieResponse> searchMovies(String query) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/search/movie").queryParam("api_key", apiKey).queryParam("query", query).build())
				.retrieve().bodyToMono(MovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error searching movies: " + e.getMessage(), e));
	}

	public Mono<MovieDetail> getMovieDetails(int movieId) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + movieId).queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(MovieDetail.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));
	}

	public Mono<MovieResponse> getRecommnedation(int movieId) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/movie/" + movieId + "/recommendations").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(MovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));
	}

	public Mono<CreditResponse> getCreditsResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/credits").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(CreditResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));
	}

	public Mono<VideoResponse> getVideoResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/videos").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(VideoResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));
	}

	public Mono<ImageResponse> getImageResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/images").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(ImageResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<MovieResponse> getSimilarResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/similar").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(MovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<ReviewResponse> getReviewResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/reviews").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(ReviewResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<KeywordResponse> getKeywordResponse(int id) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/" + id + "/keywords").queryParam("api_key", apiKey).build())
				.retrieve().bodyToMono(KeywordResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<MovieResponse> getTopRatedResponse() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/top_rated").queryParam("api_key", apiKey).build()).retrieve()
				.bodyToMono(MovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<UpcomingMovieResponse> getupcomingResponse() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/upcoming").queryParam("api_key", apiKey).build()).retrieve()
				.bodyToMono(UpcomingMovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

	public Mono<NowPlayingMovieResponse> getnowPlayingResponse() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/movie/now_playing").queryParam("api_key", apiKey).build()).retrieve()
				.bodyToMono(NowPlayingMovieResponse.class)
				.retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(
						throwable -> throwable instanceof ConnectException || throwable instanceof SocketException))
				.onErrorMap(WebClientResponseException.class,
						e -> new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
								"Error from TMDB API: " + e.getMessage(), e))
				.onErrorMap(e -> !(e instanceof ResponseStatusException),
						e -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"Error fetching movie details: " + e.getMessage(), e));

	}

}
