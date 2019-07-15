package app.cave.recyclerview_filterring;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
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
        arrayList.add(new Player("HEslldddddddddddddddkj","ffff", R.drawable.login));
        arrayList.add(new Player("fffffffffffffffffffff", "ff", R.drawable.login));
        arrayList.add(new Player("gggddddddddddddd", "fffff", R.drawable.login));
        arrayList.add(new Player("ttffffffffffffft", "bbb", R.drawable.login));


        recyclerView.addItemDecoration(new ItemDecorate(1, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
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




}