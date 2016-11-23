package pl.droidsonroids.czatexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    public final TextView textView;

    public MessageViewHolder(final View itemView, final OnMessageClickListener listener) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                listener.onMessageClick(getAdapterPosition());
            }
        });
    }


}
