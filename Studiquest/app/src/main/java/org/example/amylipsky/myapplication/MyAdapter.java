package org.example.amylipsky.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import java.util.ArrayList;




//apart of MyclassActivity java file
//

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<MyClassesActivity.MyPair> courselist = new ArrayList<MyClassesActivity.MyPair>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CheckBox mCheckBox;

        public ViewHolder(CheckBox v) {
            super(v);
            mCheckBox = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyClassesActivity.MyPair> myDataset) {
        courselist = myDataset;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CheckBox v = (CheckBox) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_checkbox_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mCheckBox.setText(courselist.get(position).key());
        holder.mCheckBox.setOnCheckedChangeListener(null);
        holder.mCheckBox.setChecked(courselist.get(position).value());
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                 @Override
                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                     courselist.set(position, new MyClassesActivity.MyPair(courselist.get(position).key(), isChecked));
                 }

             }
        );
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return courselist.size();
    }
}
