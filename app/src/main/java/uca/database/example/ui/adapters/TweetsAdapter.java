package uca.database.example.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmList;
import io.realm.RealmResults;
import uca.database.example.R;
import uca.database.example.models.TweetModel;


public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
    private RealmResults<TweetModel> tweetModels;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView user;
        public TextView tweet;
        public ViewHolder(View view) {
            super(view);
            user = (TextView) view.findViewById(R.id.user);
            tweet = (TextView) view.findViewById(R.id.tweet);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TweetsAdapter(RealmResults<TweetModel> tweetModels) {
        this.tweetModels = tweetModels;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TweetsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweet_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TweetModel tweetModel = this.tweetModels.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        // holder.user.setText(tweetModel.getUserModel().getName());
        holder.tweet.setText(tweetModel.getText());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.tweetModels.size();
    }
}

