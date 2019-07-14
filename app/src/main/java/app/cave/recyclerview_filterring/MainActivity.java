package app.cave.recyclerview_filterring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    SearchView sv;
    ArrayList<Player> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = findViewById(R.id.mSearch);
        RecyclerView recyclerView = findViewById(R.id.rechyerViewID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();
        arrayList.add(new Player("HEsllkj","ffff", R.drawable.login));
        arrayList.add(new Player("ff", "ff", R.drawable.login));
        arrayList.add(new Player("ggg", "fffff", R.drawable.login));
        arrayList.add(new Player("ttt", "bbb", R.drawable.login));


       /* final MyAdapter adapter = new MyAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);*/

       final RecycleAdapter adapter = new RecycleAdapter(this,arrayList,recyclerView,this);
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

    public void nextActivity(View view) {
        startActivity(new Intent(this,listacc.class));
    }

    @Override
    public void onItemClick(View v, int pos) {

        if(pos ==0)
        {
            Toast.makeText(this, "Number 1", Toast.LENGTH_SHORT).show();
        }
        if(pos ==1)
        {
            Toast.makeText(this, "Number 2", Toast.LENGTH_SHORT).show();
        }
    }


    //ADD PLAYERS TO ARRAYLIST
  /*  private ArrayList<Player> getPlayers()
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
    }*/

}