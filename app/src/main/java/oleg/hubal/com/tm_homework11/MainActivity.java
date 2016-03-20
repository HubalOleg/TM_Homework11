package oleg.hubal.com.tm_homework11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private PaintFragment paintFragment;
    private DragFragment dragFragment;
    private boolean setFrag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setFragment();
        return true;
    }

    private void setFragment() {
        if(setFrag) {
            dragFragment = new DragFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgm_container_AM, dragFragment)
                    .commit();
        } else {
            paintFragment = new PaintFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgm_container_AM, paintFragment)
                    .commit();
        }
        setFrag = !setFrag;
    }
}
