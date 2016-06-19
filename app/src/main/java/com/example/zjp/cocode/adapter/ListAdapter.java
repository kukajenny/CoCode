package com.example.zjp.cocode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zjp.cocode.R;
import com.example.zjp.cocode.model.ItemModel;

import java.util.List;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_FINISHED = 0;
    public static final int TYPE_RUNNING = 1;

    private List<ItemModel> list;




    public ListAdapter(List<ItemModel> list) {
        this.list = list;
    }

    /**
     * create ViewHolder by type
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_,parent,false);
        return new FinishedViewHolder(view);

    }

    /**
     * Bind View & Data
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemModel model = getItem(position);

        /*if (holder instanceof FinishedViewHolder){
            FinishedViewHolder viewHolder = (FinishedViewHolder) holder;
            if(TextUtil.isNull(model.getImageUri()) == false){
                viewHolder.imageView.setImageURI(Uri.parse(model.getImageUri()));
            }

            viewHolder.title.setText(model.getActivityTitle());
            viewHolder.currentState.setText(model.getCurrentDateState());
            viewHolder.winner.setText(model.getWinner());
            viewHolder.finishedTime.setText(model.getFinishedTime());
        }else {

            RunningViewHolder viewHolder = (RunningViewHolder) holder;
            if(TextUtil.isNull(model.getImageUri()) == false){
                viewHolder.imageView.setImageURI(Uri.parse(model.getImageUri()));
            }

            viewHolder.title.setText(model.getActivityTitle());
            viewHolder.currentState.setText(model.getCurrentDateState());
            viewHolder.progressBar.setProgress(model.getParticipantCount()*5);
            viewHolder.count.setText(Integer.toString(model.getParticipantCount()));
        }*/
    }

    private ItemModel getItem(int position){
        return list.get(position);
    }
    @Override
    public int getItemCount() {
        if(list==null)return 0;
        return list.size();
    }

    /**
     * Two kinds of type:
     * TYPE_FINISHED for layout item_raiders_finished , TYPE_RUNNING for layout item_raiders_running
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //return list.get(position).isFinished() ? TYPE_FINISHED:TYPE_RUNNING;
        return 1;
    }


    /***
     * We'd better　declare it to static
     * tips:A static nested class does not have a reference to a nesting instance -- By MummyDing
     */


    /***
     * We'd better　declare it to static
     * tips:A static nested class does not have a reference to a nesting instance -- By MummyDing
     */
    static class FinishedViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView currentState;
        TextView winner;
        TextView finishedTime;
        public FinishedViewHolder(View itemView) {
            super(itemView);
            /*imageView = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            currentState = (TextView) itemView.findViewById(R.id.tv_current_state);
            winner = (TextView) itemView.findViewById(R.id.winner);
            finishedTime = (TextView) itemView.findViewById(R.id.tv_finished_time);*/
        }
    }
}
