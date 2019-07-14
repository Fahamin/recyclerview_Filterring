package app.cave.recyclerview_filterring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;

public class listacc extends AppCompatActivity {
    SearchView sv;
    ArrayList<Player> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listacc);
        sv = findViewById(R.id.mSearch);
        RecyclerView recyclerView = findViewById(R.id.rechyerViewID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();
        arrayList.add(new Player("HELLO", "THIS", R.drawable.login));
        arrayList.add(new Player("ff", "ff", R.drawable.login));
        arrayList.add(new Player("ggg", "fffff", R.drawable.login));
        arrayList.add(new Player("ttt", "bbb", R.drawable.login));


        final MyAdapter adapter = new MyAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }
}