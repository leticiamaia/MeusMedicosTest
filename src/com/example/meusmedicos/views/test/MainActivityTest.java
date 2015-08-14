package com.example.meusmedicos.views.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.meusmedicos.R;
import com.example.meusmedicos.views.MainActivity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mainActivity;
	private TextView mainView;
	
	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	/*public void testPreconditions() {
	    assertNotNull(“Main is nulll”, mainActivity);
	    assertNotNull(“View is n”, mainView);
	}*/
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
       mainActivity = getActivity();
       mainView = (TextView) mainActivity.findViewById(R.layout.activity_main);
    }
}
