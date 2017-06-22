package com.example.locadora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		Button btnInserir = (Button) findViewById(R.id.btnInserir);
		Button btnListar = (Button) findViewById(R.id.btnListar);
		btnInserir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText edtNome = (EditText) findViewById(R.id.edtNome);
				EditText edtAno = (EditText) findViewById(R.id.edtAno);
				EditText edtGenero = (EditText) findViewById(R.id.edtGenero);
				EditText edtPais = (EditText) findViewById(R.id.edtPais);

				Filme filme = new Filme();
				FilmeDAO filmeDAO = new FilmeDAO(getBaseContext());

				int ano = Integer.parseInt(edtAno.getText().toString());
				filme.setNome(edtNome.getText().toString());
				filme.setAno(ano);
				filme.setGenero(edtGenero.getText().toString());
				filme.setPais(edtPais.getText().toString());

				String resultado = filmeDAO.inserir(filme);
				Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_SHORT).show();
			}
		});

		btnListar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, ListaFilmes.class);
				startActivity(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
