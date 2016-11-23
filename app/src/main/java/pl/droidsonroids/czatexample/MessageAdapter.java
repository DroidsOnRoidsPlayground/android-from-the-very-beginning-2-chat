package pl.droidsonroids.czatexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private static final int MESSAGE_LEFT = 0;
    private static final int MESSAGE_RIGHT = 1;

    private final List<Message> messages;
    private OnMessageClickListener listener;

    public MessageAdapter(final List<Message> messages, final OnMessageClickListener listener) {
        this.messages = messages;
        this.listener = listener;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView;
        if (viewType == MESSAGE_LEFT) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_right, parent, false);
        }
        return new MessageViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder holder, final int position) {
        String message = messages.get(position).getMessage();
        holder.getMessageTextView().setText(message);
    }

    @Override
    public int getItemViewType(final int position) {
        boolean isLeftMessage = messages.get(position).isLeft();
        if (isLeftMessage) {
            return MESSAGE_LEFT;
        } else {
            return MESSAGE_RIGHT;
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
