package dev.emmaguy.holotestapp;

import java.lang.reflect.Field;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.widget.ArrayAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewConfiguration;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends Activity implements OnNavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	try {
	    ViewConfiguration config = ViewConfiguration.get(this);
	    Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	    if (menuKeyField != null) {
		menuKeyField.setAccessible(true);
		menuKeyField.setBoolean(config, false);
	    }
	} catch (Exception ex) {
	}
	// }

	setContentView(R.layout.activity_main);

	Context context = getSupportActionBar().getThemedContext();
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.action_list, R.layout.sherlock_spinner_item);
	adapter.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);

	getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	getSupportActionBar().setListNavigationCallbacks(adapter, this);
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
	MenuInflater inflater = getSupportMenuInflater();
	inflater.inflate(R.menu.main, menu);
	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
	if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
	    if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_MENU) {
		openOptionsMenu();
		return true;
	    }
	}
	return super.onKeyUp(keyCode, event);
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
