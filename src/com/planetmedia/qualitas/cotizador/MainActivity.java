package com.planetmedia.qualitas.cotizador;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.SumPathEffect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private float primaNeta=0;
	private float sumaTotal=0;
	TextView tvPrimDanosMat;
	TextView tvPrimRobo;
	TextView tvPrimRespCivil;
	TextView tvPrimComPersonas;
	TextView tvPrimOcupantes;
	TextView tvPrimGastosMedOc;
	TextView tvPrimMuerteCond;
	TextView tvPrimGasLeg;
	TextView tvPrimAsisVial;
	TextView tvPrimExtCob;
	TextView tvPrimGasTrans;
	TextView tvPrimRoboParcial;
	TextView tvPrimDanosMatNeu;
	TextView tvPrimEquipoEspecial;
	TextView tvPrimaNeta;
	
	ArrayList<Integer> imagenes = new ArrayList<Integer>();
	
	ArrayList<String> marcas = new ArrayList<String>();
	ArrayList<String> versiones = new ArrayList<String>();
	ArrayList<String> anos = new ArrayList<String>();
	ArrayList<String> tipos = new ArrayList<String>();
	
	Spinner spMarca;
	Spinner spVersion;
	Spinner spAno;
	Spinner spTipo;
	
	ImageView logoMarca;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	     // METODO PARA ESCONDER EL TECLADO
	     getWindow().setSoftInputMode(
	        	      WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	        
		setContentView(R.layout.activity_main);
      //  getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		
		
		
		
		
		
		// EXAMPLE SPINNER
		llenarSpinners();
		
		logoMarca= (ImageView)findViewById(R.id.imgLogo);
		
		spMarca=(Spinner)findViewById(R.id.spMarca);
		spVersion=(Spinner)findViewById(R.id.spVersion);
		spAno=(Spinner)findViewById(R.id.spAno);
		spTipo=(Spinner)findViewById(R.id.spTipo);
		tvPrimDanosMat=(TextView)findViewById(R.id.tvPrimDanosMat);
		tvPrimRobo=(TextView)findViewById(R.id.tvPrimRobo);
		tvPrimRespCivil=(TextView)findViewById(R.id.tvPrimRespCivil);
		tvPrimComPersonas=(TextView)findViewById(R.id.tvPrimCompPersonas);
		tvPrimOcupantes=(TextView)findViewById(R.id.tvPrimOcupantes);
		tvPrimGastosMedOc=(TextView)findViewById(R.id.tvPrimGastosMedicos);
		tvPrimMuerteCond=(TextView)findViewById(R.id.tvPrimMuerteCond);
		tvPrimGasLeg=(TextView)findViewById(R.id.tvPrimGasLeg);
		tvPrimAsisVial=(TextView)findViewById(R.id.tvPrimAsisVial);
		tvPrimExtCob=(TextView)findViewById(R.id.tvPrimExtCob);
		tvPrimGasTrans=(TextView)findViewById(R.id.tvPrimGasTrans);
		tvPrimRoboParcial=(TextView)findViewById(R.id.tvPrimRoboParcial);
		tvPrimDanosMatNeu=(TextView)findViewById(R.id.tvPrimDanosMat);
		tvPrimEquipoEspecial=(TextView)findViewById(R.id.tvPrimEquipoEsc);
		tvPrimaNeta=(TextView)findViewById(R.id.tvPrimaNeta);
						
        ArrayAdapter<String> adMarcas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, marcas);      
        ArrayAdapter<String> adVersiones = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, versiones);      
        ArrayAdapter<String> adAno = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, anos);      
        ArrayAdapter<String> adTipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipos);      
       
        spMarca.setAdapter(adMarcas);
        spVersion.setAdapter(adVersiones);
        spAno.setAdapter(adAno);
        spTipo.setAdapter(adTipo);
        
        
        spMarca.setOnItemSelectedListener(new OnItemSelectedListener() {         
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
        //Toast.makeText(parentView.getContext(), "Has seleccionado " + parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            	logoMarca.setImageResource(imagenes.get(position));
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {            	
            }
        });       	
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu:
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	private void llenarSpinners() {
				
		marcas.add("ACURA");
		marcas.add("ALFA ROMEO");
		marcas.add("AUDI");
		
		versiones.add("VERSION1");
		versiones.add("VERSION2");
		versiones.add("VERSION3");
		versiones.add("VERSION4");
		
		anos.add("1990");
		anos.add("1991");
		anos.add("1992");
		anos.add("1993");
		
		tipos.add("TIPO1");
		tipos.add("TIPO2");
		tipos.add("TIPO3");
		tipos.add("TIPO4");
		tipos.add("TIPO5");
				
		imagenes.add(R.drawable.logo_auto_chevrolet);
		imagenes.add(R.drawable.logo_auto_crhysler);
		imagenes.add(R.drawable.logo_auto_vw);
				
	}
	
	private void calculaPrima(){
		primaNeta=0;
		
		primaNeta=primaNeta+Float.parseFloat(tvPrimDanosMat.getText().toString());
		primaNeta=primaNeta+Float.parseFloat(tvPrimRobo.getText().toString());
		primaNeta=primaNeta+Float.parseFloat(tvPrimRespCivil.getText().toString());
		if(tvPrimComPersonas.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimComPersonas.getText().toString());
		if(tvPrimOcupantes.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimOcupantes.getText().toString());
		primaNeta=primaNeta+Float.parseFloat(tvPrimGastosMedOc.getText().toString());
		primaNeta=primaNeta+Float.parseFloat(tvPrimMuerteCond.getText().toString());
		primaNeta=primaNeta+Float.parseFloat(tvPrimGasLeg.getText().toString());
		if(tvPrimAsisVial.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimAsisVial.getText().toString());
		if(tvPrimExtCob.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimExtCob.getText().toString());
		if(tvPrimGasTrans.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimGasTrans.getText().toString());
		if(tvPrimRoboParcial.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimRoboParcial.getText().toString());
		if(tvPrimDanosMatNeu.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimDanosMatNeu.getText().toString());
		if(tvPrimEquipoEspecial.getVisibility()==View.VISIBLE)
			primaNeta=primaNeta+Float.parseFloat(tvPrimEquipoEspecial.getText().toString());
			
		tvPrimaNeta.setText(String.valueOf(primaNeta));
		
		calculaTotal();
		
	}

	private void calculaTotal() {

		sumaTotal=0;
		
	}
		
}