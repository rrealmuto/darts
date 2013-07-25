package com.realdelsi.dartsscoreboard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CricketActivity extends Activity {
	
	private SparseIntArray p1Clicks;
	private SparseIntArray p2Clicks;
	private int p1Points;
	private int p2Points;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cricket);
		// Show the Up button in the action bar.
		setupActionBar();
		p1Clicks = new SparseIntArray(7);
		p2Clicks = new SparseIntArray(7);
		p1Points = 0;
		p2Points = 0;
		
		p1Clicks.append(15, 0);
		p1Clicks.append(16, 0);
		p1Clicks.append(17, 0);
		p1Clicks.append(18, 0);
		p1Clicks.append(19, 0);
		p1Clicks.append(20, 0);
		p1Clicks.append(25, 0);
		
		p2Clicks.append(15, 0);
		p2Clicks.append(16, 0);
		p2Clicks.append(17, 0);
		p2Clicks.append(18, 0);
		p2Clicks.append(19, 0);
		p2Clicks.append(20, 0);
		p2Clicks.append(25, 0);
		
		CricketView tempView;
		tempView = (CricketView)findViewById(R.id.p1_15);
		tempView.setPlayer(1);
		tempView.setValue(15);

		tempView = (CricketView)findViewById(R.id.p1_16);
		tempView.setPlayer(1);
		tempView.setValue(16);

		tempView = (CricketView)findViewById(R.id.p1_17);
		tempView.setPlayer(1);
		tempView.setValue(17);

		tempView = (CricketView)findViewById(R.id.p1_18);
		tempView.setPlayer(1);
		tempView.setValue(18);

		tempView = (CricketView)findViewById(R.id.p1_19);
		tempView.setPlayer(1);
		tempView.setValue(19);

		tempView = (CricketView)findViewById(R.id.p1_20);
		tempView.setPlayer(1);
		tempView.setValue(20);

		tempView = (CricketView)findViewById(R.id.p1_Bull);
		tempView.setPlayer(1);
		tempView.setValue(25);
		//////////////
		tempView = (CricketView)findViewById(R.id.p2_15);
		tempView.setPlayer(2);
		tempView.setValue(15);

		tempView = (CricketView)findViewById(R.id.p2_16);
		tempView.setPlayer(2);
		tempView.setValue(16);

		tempView = (CricketView)findViewById(R.id.p2_17);
		tempView.setPlayer(2);
		tempView.setValue(17);

		tempView = (CricketView)findViewById(R.id.p2_18);
		tempView.setPlayer(2);
		tempView.setValue(18);

		tempView = (CricketView)findViewById(R.id.p2_19);
		tempView.setPlayer(2);
		tempView.setValue(19);

		tempView = (CricketView)findViewById(R.id.p2_20);
		tempView.setPlayer(2);
		tempView.setValue(20);

		tempView = (CricketView)findViewById(R.id.p2_Bull);
		tempView.setPlayer(2);
		tempView.setValue(25);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cricket, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void cricketClick(View v)
	{
		CricketView view = (CricketView)v;
		int thisPlayer = view.getPlayer();
		int thisVal = view.getValue();
		int oldClicks;
		int newClicks;
		SparseIntArray thisClicks;
		SparseIntArray otherClicks;
		TextView thisPointsView;
		if(thisPlayer == 1)
		{
			thisClicks = p1Clicks;
			otherClicks = p2Clicks;
			thisPointsView = (TextView)findViewById(R.id.p1Points);
		}
		else
		{
			thisClicks = p2Clicks;
			otherClicks = p1Clicks;
			thisPointsView = (TextView)findViewById(R.id.p2Points);
		}
		oldClicks = thisClicks.get(thisVal);
		//thisPointsView.setText("it worked");
		
		newClicks = oldClicks + 1;
		view.setClicks(newClicks);
		thisClicks.put(thisVal, newClicks);
		
		//update points
		if(newClicks > 3 && otherClicks.get(thisVal) < 3)
		{
			if(thisPlayer == 1)
			{
				p1Points+=thisVal;
				thisPointsView.setText(Integer.toString(p1Points));
			}
			else if(thisPlayer == 2)
			{
				p2Points +=thisVal;
				thisPointsView.setText(Integer.toString(p2Points));
			}
		}
		
	}
}
