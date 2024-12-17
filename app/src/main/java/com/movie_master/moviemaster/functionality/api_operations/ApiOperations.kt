package com.movie_master.moviemaster.functionality.api_operations

import com.movie_master.moviemaster.data.api_data.list_item_status_data.ListItemStatusResponse
import com.movie_master.moviemaster.data.api_data.api_key.ApiKey
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.CelebrityList
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_details.CelebrityDetails
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_images.CelebrityImages
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCredits
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCredits
import com.movie_master.moviemaster.data.api_data.profile.session.RequestToken
import com.movie_master.moviemaster.data.api_data.profile.user_details.UserDetails
import com.movie_master.moviemaster.data.api_data.movie._movie.MovieList
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCredits
import com.movie_master.moviemaster.data.api_data.movie.movie_details.MovieDetails
import com.movie_master.moviemaster.data.api_data.movie.movie_images.MovieImages
import com.movie_master.moviemaster.data.api_data.movie.movie_release_date.MoviesReleaseDates
import com.movie_master.moviemaster.data.api_data.movie.movie_reviews.MovieReviews
import com.movie_master.moviemaster.data.api_data.profile.session.SessionDeletion
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeriesList
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCredits
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_content_rating.TvContentRating
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_details.TvSeriesDetails
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_images.TvSeriesImages
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews.TvSeriesReviews
import com.movie_master.moviemaster.data.api_data.profile.session.SessionId
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiOperations {

    // FETCH ---------------------------------------------------------------------------------------

    // Movie
    @GET("movie/now_playing?api_key=${ApiKey.apiKey}")
    suspend fun getMoviesNowPlaying(): Response<MovieList>

    @GET("movie/top_rated?api_key=${ApiKey.apiKey}")
    suspend fun getPopularMovies(): Response<MovieList>

    @GET("trending/movie/{time_window}?api_key=${ApiKey.apiKey}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String
    ): Response<MovieList>

    @GET("movie/{movie_id}?api_key=${ApiKey.apiKey}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Response<MovieDetails>

    @GET("movie/{movie_id}/release_dates?api_key=${ApiKey.apiKey}")
    suspend fun getMovieReleaseDates(
        @Path("movie_id") movieId: Int
    ): Response<MoviesReleaseDates>

    @GET("movie/{movie_id}/credits?api_key=${ApiKey.apiKey}")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int
    ): Response<MovieCredits>

    @GET("movie/{movie_id}/images?api_key=${ApiKey.apiKey}")
    suspend fun getMovieImages(
        @Path("movie_id") movieId: Int
    ): Response<MovieImages>

    @GET("movie/{movie_id}/reviews?api_key=${ApiKey.apiKey}")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int
    ): Response<MovieReviews>

    @GET("movie/{movie_id}/similar?api_key=${ApiKey.apiKey}")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ): Response<MovieList>

    // TV Series
    @GET("tv/on_the_air?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesOnAir(): Response<TvSeriesList>

    @GET("tv/top_rated?api_key=${ApiKey.apiKey}")
    suspend fun geTopRatedTvSeries(): Response<TvSeriesList>

    @GET("trending/tv/{time_window}?api_key=${ApiKey.apiKey}")
    suspend fun getTrendingTvSeries(
        @Path("time_window") timeWindow: String
    ): Response<TvSeriesList>

    @GET("tv/{series_id}?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesDetails(
        @Path("series_id") seriesId: Int
    ): Response<TvSeriesDetails>

    @GET("tv/{series_id}/content_ratings?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesContentRatings(
        @Path("series_id") seriesId: Int
    ): Response<TvContentRating>

    @GET("tv/{series_id}/credits?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesCredits(
        @Path("series_id") seriesId: Int
    ): Response<TvSeriesCredits>

    @GET("tv/{series_id}/images?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesImages(
        @Path("series_id") seriesId: Int
    ): Response<TvSeriesImages>

    @GET("tv/{series_id}/reviews?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesReviews(
        @Path("series_id") seriesId: Int
    ): Response<TvSeriesReviews>

    @GET("tv/{series_id}/similar?api_key=${ApiKey.apiKey}")
    suspend fun getSimilarTvSeries(
        @Path("series_id") seriesId: Int
    ): Response<TvSeriesList>

    // Celebrity
    @GET("trending/person/{time_window}?api_key=${ApiKey.apiKey}")
    suspend fun getTrendingCelebrities(
        @Path("time_window") timeWindow: String
    ): Response<CelebrityList>

    @GET("person/{person_id}?api_key=${ApiKey.apiKey}")
    suspend fun getCelebrityDetails(
        @Path("person_id") personId: Int
    ) : Response<CelebrityDetails>

    @GET("person/{person_id}/movie_credits?api_key=${ApiKey.apiKey}")
    suspend fun getCelebrityMovieCredits(
        @Path("person_id") personId: Int
    ) : Response<CelebrityMovieCredits>

    @GET("person/{person_id}/tv_credits?api_key=${ApiKey.apiKey}")
    suspend fun getCelebrityTvCredits(
        @Path("person_id") personId: Int
    ) : Response<CelebrityTvCredits>

    @GET("person/{person_id}/images?api_key=${ApiKey.apiKey}")
    suspend fun getCelebrityImages(
        @Path("person_id") personId: Int
    ) : Response<CelebrityImages>
    // ---------------------------------------------------------------------------------------------

    // SEARCH --------------------------------------------------------------------------------------
    @GET("search/movie?api_key=${ApiKey.apiKey}")
    suspend fun searchMovie(
        @Query("query") query: String
    ): Response<MovieList>

    @GET("search/tv?api_key=${ApiKey.apiKey}")
    suspend fun searchTVSeries(
        @Query("query") query: String
    ): Response<TvSeriesList>

    @GET("search/person?api_key=${ApiKey.apiKey}")
    suspend fun searchCelebrity(
        @Query("query") query: String
    ): Response<CelebrityList>
    // ---------------------------------------------------------------------------------------------

    // PROFILE --------------------------------------------------------------------------------
    @GET("authentication/token/new?api_key=${ApiKey.apiKey}")
    suspend fun getRequestToken(): Response<RequestToken>

    @POST("authentication/session/new?api_key=${ApiKey.apiKey}")
    suspend fun createSession(
        @Body requestBody: RequestBody
    ): Response<SessionId>

    @HTTP(method = "DELETE", path = "authentication/session?api_key=${ApiKey.apiKey}", hasBody = true)
    //@DELETE("authentication/session?api_key=${ApiKey.apiKey}")
    suspend fun deleteSession(
        @Body body: RequestBody
    ): Response<SessionDeletion>

    @GET("account?api_key=${ApiKey.apiKey}")
    suspend fun getUserDetails(
        @Query("session_id") sessionId: String
    ): Response<UserDetails>

    // Favorite
    @GET("account/{account_id}/favorite/movies?api_key=${ApiKey.apiKey}")
    suspend fun getFavoriteMovies(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<MovieList>

    @GET("account/{account_id}/favorite/tv?api_key=${ApiKey.apiKey}")
    suspend fun getFavoriteTvSeries(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<TvSeriesList>

    // Watchlist
    @GET("account/{account_id}/watchlist/movies?api_key=${ApiKey.apiKey}")
    suspend fun getMoviesOnWatchList(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<MovieList>

    @GET("account/{account_id}/watchlist/tv?api_key=${ApiKey.apiKey}")
    suspend fun getTvSeriesOnWatchList(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<TvSeriesList>

    // Add Or Remove From List
    @POST("account/{account_id}/watchlist?api_key=${ApiKey.apiKey}")
    suspend fun addOrRemoveFromWatchList(
        @Body body: RequestBody,
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<ListItemStatusResponse>

    @POST("account/{account_id}/favorite?api_key=${ApiKey.apiKey}")
    suspend fun addOrRemoveFromFavoriteList(
        @Body body: RequestBody,
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String
    ): Response<ListItemStatusResponse>

}

object RetrofitInstance {

    // CREATE AN INSTANCE OF RETROFIT THAT CONTAINS THE BASE URL
    val api: ApiOperations by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiOperations::class.java)
    }}

interface NewApiOperations {
    @GET("authentication/token/new?api_key=${ApiKey.apiKey}")
    suspend fun getRequestToken(): Response<RequestToken>
}

object NewRetrofitInstance {

    // CREATE AN INSTANCE OF RETROFIT THAT CONTAINS THE BASE URL
    val api: ApiOperations by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiOperations::class.java)
    }}