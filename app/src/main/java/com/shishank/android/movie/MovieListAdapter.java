package com.shishank.android.movie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.shishank.android.Constants;
import com.shishank.android.R;
import com.shishank.android.models.response.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

/**
 * @author shishank
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private Context context;
    @Getter
    private List<Result> movieList;
    private LayoutInflater layoutInflater;
    private Contracts.View movieView;

    public MovieListAdapter(Context context, Contracts.View movieView) {
        this.context = context;
        movieList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.movieView = movieView;
    }

    public void addAll(List<Result> results) {
        movieList.addAll(results);
        notifyDataSetChanged();
    }

    public List<Result> getList() {
        return movieList;
    }

    public void clear() {
        if (movieList != null) {
            movieList.clear();
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(layoutInflater.inflate(R.layout.view_movie_item, parent,
                false));
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bindViews(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_movie_poster)
        ImageView ivMoviePoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("CheckResult")
        void bindViews(Result result) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_placeholder);
            requestOptions.error(R.drawable.ic_placeholder);
            requestOptions.fitCenter();
            Glide.with(context)
                    .asDrawable()
                    .apply(requestOptions)
                    .load(Constants.IMAGE_URL_BASE + result.getPosterPath())
                    .into(ivMoviePoster);
            itemView.setOnClickListener(v -> movieView.onMovieItemSelected(result));
        }
    }
}
