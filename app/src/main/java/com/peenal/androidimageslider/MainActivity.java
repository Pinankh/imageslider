package com.peenal.androidimageslider;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.peenal.slider.IndicatorAnimations;
import com.peenal.slider.IndicatorView.draw.controller.DrawController;
import com.peenal.slider.SliderAnimations;
import com.peenal.slider.SliderView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private Spinner spineer_indicatore;
	private Spinner spineer_animation;
	private List<String> list_indicatore = new ArrayList<>();
	private List<String> list_animation = new ArrayList<>();
	private SliderView sliderView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		spineer_indicatore = (Spinner) findViewById(R.id.spineer_indicatore);
		spineer_animation = (Spinner) findViewById(R.id.spineer_animation);

		list_indicatore.add("WORM");
		list_indicatore.add("THIN_WORM");
		list_indicatore.add("COLOR");
		list_indicatore.add("DROP");
		list_indicatore.add("FILL");
		list_indicatore.add("NONE");
		list_indicatore.add("SCALE");
		list_indicatore.add("SCALE_DOWN");
		list_indicatore.add("SLIDE");
		list_indicatore.add("SWAP");


		list_animation.add("ANTICLOCKSPINTRANSFORMATION");
		list_animation.add("CLOCK_SPINTRANSFORMATION");
		list_animation.add("CUBEINDEPTHTRANSFORMATION");
		list_animation.add("CUBEINROTATIONTRANSFORMATION");
		list_animation.add("CUBEINSCALINGTRANSFORMATION");
		list_animation.add("CUBEOUTDEPTHTRANSFORMATION");
		list_animation.add("CUBEOUTROTATIONTRANSFORMATION");
		list_animation.add("CUBEOUTSCALINGTRANSFORMATION");
		list_animation.add("DEPTHTRANSFORMATION");
		list_animation.add("FADETRANSFORMATION");
		list_animation.add("FANTRANSFORMATION");
		list_animation.add("FIDGETSPINTRANSFORMATION");
		list_animation.add("GATETRANSFORMATION");
		list_animation.add("HINGETRANSFORMATION");
		list_animation.add("HORIZONTALFLIPTRANSFORMATION");
		list_animation.add("POPTRANSFORMATION");
		list_animation.add("POPTRANSFORMATION");
		list_animation.add("SIMPLETRANSFORMATION");
		list_animation.add("SPINNERTRANSFORMATION");
		list_animation.add("TOSSTRANSFORMATION");
		list_animation.add("VERTICALFLIPTRANSFORMATION");
		list_animation.add("VERTICALSHUTTRANSFORMATION");
		list_animation.add("ZOOMOUTTRANSFORMATION");

		//Creating the ArrayAdapter instance having the country list
		ArrayAdapter<String> adapter_indicatore = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_indicatore);
		adapter_indicatore.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Setting the ArrayAdapter data on the Spinner
		spineer_indicatore.setAdapter(adapter_indicatore);

		//Creating the ArrayAdapter instance having the country list
		ArrayAdapter<String> adapter_animation = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_animation);
		adapter_animation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Setting the ArrayAdapter data on the Spinner
		spineer_animation.setAdapter(adapter_animation);

		sliderView = (SliderView)findViewById(R.id.imageSlider);

		final SliderAdapter adapter = new SliderAdapter(this);
		adapter.setCount(4);

		sliderView.setSliderAdapter(adapter);

		sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
		sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
		sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
		sliderView.setIndicatorSelectedColor(Color.WHITE);
		sliderView.setIndicatorUnselectedColor(Color.GRAY);
		sliderView.startAutoCycle();
		// CUBEINDEPTHTRANSFORMATION
		// SIMPLETRANSFORMATION

		spineer_indicatore.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

				final SliderAdapter adapter = new SliderAdapter(MainActivity.this);
				adapter.setCount(4);

				sliderView.setSliderAdapter(adapter);
				sliderView.setIndicatorAnimation(IndicatorAnimations.values()[i]);

				//sliderView.setIndicatorAnimation(IndicatorAnimations.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
				sliderView.setSliderTransformAnimation(SliderAnimations.values()[spineer_animation.getSelectedItemPosition()]);
				sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
				sliderView.setIndicatorSelectedColor(Color.WHITE);
				sliderView.setIndicatorUnselectedColor(Color.GRAY);
				sliderView.startAutoCycle();

			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {

			}
		});

		spineer_animation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

				final SliderAdapter adapter = new SliderAdapter(MainActivity.this);
				adapter.setCount(5);

				sliderView.setSliderAdapter(adapter);
				sliderView.setIndicatorAnimation(IndicatorAnimations.values()[spineer_indicatore.getSelectedItemPosition()]);

				//sliderView.setIndicatorAnimation(IndicatorAnimations.DROP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
				sliderView.setSliderTransformAnimation(SliderAnimations.values()[i]);
				sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
				sliderView.setIndicatorSelectedColor(Color.WHITE);
				sliderView.setIndicatorUnselectedColor(Color.GRAY);
				sliderView.startAutoCycle();

			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
