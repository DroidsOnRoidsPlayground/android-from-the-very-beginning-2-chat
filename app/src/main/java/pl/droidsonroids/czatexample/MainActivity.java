package pl.droidsonroids.czatexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMessageClickListener {

    private List<String> messages = new ArrayList<>();
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editText);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MessageAdapter(messages, this);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                messages.add(editText.getText().toString());
                adapter.notifyItemInserted(messages.size() - 1);
            }
        });
    }

    @Override
    public void onMessageClick(final int position) {
        messages.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
