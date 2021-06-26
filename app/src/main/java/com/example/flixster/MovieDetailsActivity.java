package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.databinding.ActivityMovieDetailsBinding;
import com.example.flixster.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import okhttp3.Headers;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;
    String id;

    public static final String TAG = "MovieDetailsActivity";
    public static final String EXTRA_MESSAGE = "com.example.flixster.MESSAGE";

    //TextView tvTitle;
    //TextView tvOverview;
    //RatingBar rbVoteAverage;
    //ImageView ivPoster;

    ActivityMovieDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().hide();

        binding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //view.setVisibility(View.INVISIBLE);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));

        binding.tvTitle.setText(Html.fromHtml("<b>" + movie.getTitle() + "</b>", 1));
        binding.tvOverview.setText(Html.fromHtml("<b>Overview: </b>" + movie.getOverview(), 3));

        binding.tvReleaseDate.setText(Html.fromHtml("Release date: <i>" + movie.getReleaseDate() + "</i>", 2));

        float voteAverage = movie.getVoteAverage().floatValue();
        binding.rbVoteAverage.setRating(voteAverage / 2.0f);

        int image = R.drawable.flicks_movie_placeholder;
        int backdropImage = R.drawable.flicks_backdrop_placeholder;

        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        Glide.with(this).load(movie.getPosterPath()).placeholder(image).centerCrop().transform(new RoundedCornersTransformation(radius, margin)).into(binding.ivPoster);
        Glide.with(this).load(movie.getBackDropPath()).placeholder(backdropImage).centerCrop().transform(new RoundedCornersTransformation(radius, margin)).into(binding.ivPosterTrailer);
        Glide.with(this).load(R.drawable.video_play_btn).into(binding.imgPlayVideo);

        Log.d(TAG, String.format("Showing details for: '%s'", movie.getTitle()));

        binding.ivPosterTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient clientTrailer = new AsyncHttpClient();
                String urlVideos = "https://api.themoviedb.org/3/movie/" + movie.getId().toString() + "/videos?api_key=b23b944c432df7c71756746d621277ce";
                clientTrailer.get(urlVideos, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int i, Headers headers, JSON json) {
                        Log.d(TAG, "onSuccess");
                        JSONObject jsonObject = json.jsonObject;
                        try {
                            JSONArray results = jsonObject.getJSONArray("results");
                            Log.i(TAG, "Results: " + results.toString());
                            id = results.getJSONObject(0).getString("key");
                            //view.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(MovieDetailsActivity.this, MovieTrailerActivity.class);
                            // serialize the movie using parceler, use its short name as a key
                            intent.putExtra(EXTRA_MESSAGE, id);
                            // show the activity
                            startActivity(intent);
                            Log.i(TAG, "Id: " + id);
                        } catch (JSONException e) {
                            Log.e(TAG, "Hit json exception", e);
                        }
                    }

                    @Override
                    public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                        Log.d(TAG, "onFailure");
                    }

                });
            }
        });


    }

    //public void onClickTrailer(View view) {

    //    Intent intent = new Intent(this, MovieTrailerActivity.class);
        // serialize the movie using parceler, use its short name as a key
    //    intent.putExtra(EXTRA_MESSAGE, id);
        // show the activity
    //    startActivity(intent);

    //}
}