package com.example.recycleviewtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewtest.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ImageViewHolder>{

    onClickItem onClickItem1;

    private Context context;
    private int count;
    private String text;

    public RecycleViewAdapter(Context context, String text, int count ) {
        this.context = context;
        this.text=text;
        this.count=count;
    }

    public void SetonClickItem(onClickItem onClickItem1){
        this.onClickItem1=onClickItem1;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_list, parent, false);
        return new ImageViewHolder(view);
    }

    public interface onClickItem{
        public void OnClickitem(int position, View view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        // holder.imageView.setImageResource(image);
        holder.SubjectName.setText(text);

        holder.imageView.setImageResource(R.drawable.ic_launcher_foreground);

        holder.Carditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, "Clicked on position "+position, Toast.LENGTH_SHORT).show();
                // context.startActivity(new Intent(context, ChapterActivity.class));
                onClickItem1.OnClickitem(position,view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView Carditem;
        TextView SubjectName;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            Carditem = itemView.findViewById(R.id.image_card);
            imageView = itemView.findViewById(R.id.scheme_image);
            SubjectName = itemView.findViewById(R.id.subject_name);
        }
    }

}
