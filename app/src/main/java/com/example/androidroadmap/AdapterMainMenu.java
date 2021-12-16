package com.example.androidroadmap;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AdapterMainMenu extends RecyclerView.Adapter<AdapterMainMenu.ViewHolder> {

    private static final String TAG = "AdapterMainMenu";

    private ArrayList<ItemsMainMenu> itemsMainMenu = new ArrayList<>();
    private Context mContext;

    public AdapterMainMenu(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main_menu, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtTopic.setText(itemsMainMenu.get(position).getTopic());
        holder.imgItem.setImageResource(itemsMainMenu.get(position).getImagePath());
        holder.txtDesc.setText(itemsMainMenu.get(position).getDescription());


        if(itemsMainMenu.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.cardViewParent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
        } else {
            TransitionManager.beginDelayedTransition(holder.cardViewParent);
            holder.expandedRelLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return itemsMainMenu.size();
    }

    public void setItemsMainMenu(ArrayList<ItemsMainMenu> itemsMainMenu) {
        this.itemsMainMenu = itemsMainMenu;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialCardView cardViewParent;
        private ImageView imgItem;
        private TextView txtTopic, txtDesc;
        private RelativeLayout expandedRelLayout;
        private Button btnMoreDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewParent = itemView.findViewById(R.id.cardViewParent);
            imgItem = itemView.findViewById(R.id.imgItem);
            txtTopic = itemView.findViewById(R.id.txtTopic);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            btnMoreDetails = itemView.findViewById(R.id.btnMoreDetails);

            cardViewParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemsMainMenu itMM = itemsMainMenu.get(getAdapterPosition());
                    itMM.setExpanded(!itMM.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            btnMoreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent; //final ka use samajh nahi aaya
                    switch (getAdapterPosition()) {

                        case 0:
                            intent = new Intent(mContext, PickALanguage.class);
                            break;
                        case 1:
                            intent = new Intent(mContext, LearnTheFundamentals.class);
                            break;
                        case 2:
                            intent = new Intent(mContext, VersionControlSystems.class);
                            break;
                        case 3:
                            intent = new Intent(mContext, RepoHostingServices.class);
                            break;
                        case 4:
                            intent = new Intent(mContext, BuildAnApplication.class);
                            break;
                        case 5:
                            intent = new Intent(mContext, WritingRobustApps.class);
                            break;
                        case 6:
                            intent = new Intent(mContext, KeepLearning.class);
                            break;
                        case 7:
                            intent = new Intent(mContext, Books.class);
                            break;
                        default:
                            return;
                    }
                    mContext.startActivity(intent);


                }
            });

        }
    }

}
