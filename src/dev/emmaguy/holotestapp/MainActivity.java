package dev.emmaguy.holotestapp;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.widget.ArrayAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SpinnerAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends Activity implements OnNavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	SpinnerAdapter actionListSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_list,
		android.R.layout.simple_spinner_dropdown_item);

	getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	getSupportActionBar().setListNavigationCallbacks(actionListSpinnerAdapter, this);
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
	MenuInflater inflater = getSupportMenuInflater();
	inflater.inflate(R.menu.main, menu);
	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
	return false;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
	switch (menuItem.getItemId()) {
	case R.id.action_item1:
	    Intent intent = new Intent(this, BackActivity.class);
	    startActivity(intent);
	    break;
	case R.id.action_item2:
	    break;
	default:
	    return false;
	}
	
	return true;
    }
}
