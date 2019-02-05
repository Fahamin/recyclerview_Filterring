package app.cave.recyclerview_filterring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   SearchView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv= findViewById(R.id.mSearch);
        RecyclerView recyclerView = findViewById(R.id.rechyerViewID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final MyAdapter adapter=new MyAdapter(this,getPlayers());
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

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Player> getPlayers()
    {
        ArrayList<Player> players=new ArrayList<>();
        Player p=new Player();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setImg(R.drawable.login);
        players.add(p);

        p=new Player();
        p.setName("David De Geaa");
        p.setPos("Goalkeeper");
        p.setImg(R.drawable.login);
        players.add(p);

        p=new Player();
        p.setName("Michael Carrick");
        p.setPos("Midfielder");
        p.setImg(R.drawable.login);
        players.add(p);

        p=new Player();
        p.setName("Juan Mata");
        p.setPos("Playmaker");
        p.setImg(R.drawable.login);
        players.add(p);

        p=new Player();
        p.setName("Diego Costa");
        p.setPos("Striker");
        p.setImg(R.drawable.login);
        players.add(p);

        p=new Player();
        p.setName("Oscar");
        p.setPos("Playmaker");
        p.setImg(R.drawable.login);
        players.add(p);

        return players;
    }

}