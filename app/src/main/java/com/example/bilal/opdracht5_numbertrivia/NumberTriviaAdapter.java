package com.example.bilal.opdracht5_numbertrivia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NumberTriviaAdapter extends RecyclerView.Adapter<NumberTriviaAdapter.TriviaViewholder> {

    private List<Trivia> mFacts;
    private static final String TAG = "NumberTriviaAdapter";

    public NumberTriviaAdapter(List<Trivia> mFacts) {
        this.mFacts = mFacts;
    }

    @NonNull
    @Override
    public TriviaViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view;
        if(viewType == 0) {
            view = inflater.inflate(R.layout.item1, parent, false);
        } else {
            view = inflater.inflate(R.layout.item2, parent, false);
        }
        return new NumberTriviaAdapter.TriviaViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaViewholder holder, int position) {
        Trivia trivia = mFacts.get(position);
        holder.vTextNumber.setText(String.valueOf(trivia.getNumber()));
        holder.vTextFact.setText(trivia.getText());
    }

    @Override
    public int getItemCount() {
        return mFacts.size();
    }

    //determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class TriviaViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView vTextNumber;
        private TextView vTextFact;
        private View view;

        public TriviaViewholder(View v) {
            super(v);
            this.view = v;
            vTextNumber = v.findViewById(R.id.numberTextView);
            vTextFact = v.findViewById(R.id.factTextView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
