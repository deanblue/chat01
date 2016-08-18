package com.example.ethan.share01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ethan on 16. 6. 16..
 */
public class ContentsListAdapter  extends RecyclerView.Adapter<ContentsListAdapter.ViewHolder> {
    private List<ContentsListObject> ContentsList;
    private Context mContext;
    static int picWidth = 470;

    public ContentsListAdapter(Context context, List<ContentsListObject> ContentItem) {
        this.mContext = context;
        this.ContentsList = ContentItem;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        picWidth = (int)((float)dm.widthPixels / 2.0 * 0.97);
    }

    @Override
    public void onBindViewHolder(ContentsListAdapter.ViewHolder holder, int position) {
        //Picasso.with(mContext).load(ContentsList.get(position).getPicUrl()).resize(476,0).into(holder.Pic);
        Picasso.with(mContext).load(ContentsList.get(position).getPicUrl()).resize(picWidth, 0).into(holder.Photo);
        Toast.makeText(mContext, ContentsList.get(position).getPicUrl(), 1);
        //Picasso.with(mContext).load(ContentsList.get(position).getPicUrl()).into(holder.Pic);
        holder.Time.setText(ContentsList.get(position).getTime());
        holder.User.setText(ContentsList.get(position).getUser());
        holder.Etc.setText(ContentsList.get(position).getEtc());
        holder.Msg.setText(ContentsList.get(position).getMsg());
        holder.ContentId = ContentsList.get(position).getId();
        holder.UserId = ContentsList.get(position).getUserId();
    }

    @Override
    public ContentsListAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {

        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.content_main, vGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return ContentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView Photo;
        private TextView Time;
        private TextView User;
        private TextView Etc;
        private TextView Msg;
        private int ContentId;
        private int UserId;

        public ViewHolder(View ContentView) {
            super(ContentView);

            ContentView.setOnClickListener(this);
            Photo = (ImageView) ContentView.findViewById(R.id.bbslist_photo);
            Time = (TextView) ContentView.findViewById(R.id.bbslist_time);
            User = (TextView) ContentView.findViewById(R.id.bbslist_user);
            Etc = (TextView) ContentView.findViewById(R.id.bbslist_etc);
            Msg = (TextView) ContentView.findViewById(R.id.bbslist_msg);
            ContentId = 0;
            UserId = 0;
        }

        @Override
        public void onClick(View ContentView)
        {
            /*Toast.makeText(ContentView.getContext(), "Clicked ContentId = " + ContentId + " " + UserId, Toast.LENGTH_SHORT).show();
            Context context = ContentView.getContext();
            Intent intent = new Intent(context, ContentDetailActivity.class);
            intent.putExtra("user_num", UserId);
            context.startActivity(intent);*/

            //ViewHolder.this.UserId
            //Toast.makeText(ContentView.getContext(), "Clicked ContentId = " + ContentId + " " + ViewHolder.this.UserId, Toast.LENGTH_SHORT).show();
            Context context = ContentView.getContext();
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("sender_id", ViewHolder.this.UserId);
            context.startActivity(intent);
            ((Activity)context).finish();
            Log.e("Adapter Context", context.toString());

        }
    }
}