package com.aat.advancedandroidarchitecturedemo.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aat.advancedandroidarchitecturedemo.R;
import com.aat.advancedandroidarchitecturedemo.model.Repo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private final RepoClickedListener listener;
    private final List<Repo> data = new ArrayList<>();

    RepoAdapter(RepoClickedListener listener) {
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repo_list_item, parent, false);
        return new RepoViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void setData(List<Repo> repos) {
        if (repos != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new RepoDiffCallback(data, repos));
            data.clear();
            data.addAll(repos);
            diffResult.dispatchUpdatesTo(this);
        } else {
            data.clear();
            notifyDataSetChanged();
        }
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView repoNameText;
        @BindView(R.id.tv_repo_description)
        TextView repoDescriptionText;
        @BindView(R.id.tv_fork_count)
        TextView forkCountText;
        @BindView(R.id.tv_star_count)
        TextView starCountText;

        private Repo repo;

        RepoViewHolder(View itemView, RepoClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (repo != null) {
                    listener.onRepoClicked(repo);
                }
            });
        }

        void bind(Repo repo) {
            this.repo = repo;
            repoNameText.setText(repo.name());
            repoDescriptionText.setText(repo.description());
            forkCountText.setText(NumberFormat.getInstance().format(repo.forksCount()));
            starCountText.setText(NumberFormat.getInstance().format(repo.stargazersCount()));
        }
    }

    interface RepoClickedListener {

        void onRepoClicked(Repo repo);
    }
}