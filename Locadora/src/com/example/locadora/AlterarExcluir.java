package com.example.locadora;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AlterarExcluir extends Activity {
	private EditText edtId;
	private EditText edtNomeAlterar;
	private EditText edtAnoAlterar;
	private EditText edtGeneroAlterar;
	private EditText edtPaisAlterar;
	private FilmeDAO dao;
	private Cursor cursor;
	private Button btnAlterar;
	private Button btnExcluir;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alterar_excluir);
		
		edtId = (EditText) findViewById(R.id.edtIdAlterar);
		edtNomeAlterar = (EditText) findViewById(R.id.edtNomeAlterar);
		edtAnoAlterar = (EditText) findViewById(R.id.edtAnoAlterar);
		edtGeneroAlterar = (EditText) findViewById(R.id.edtGeneroAlterar);
		edtPaisAlterar = (EditText) findViewById(R.id.edtPaisAlterar);
		btnAlterar = (Button) findViewById(R.id.btnAlterar);
		btnExcluir = (Button) findViewById(R.id.btnExcluir);
		Long id = getIntent().getExtras().getLong("ID");
		
		//Buscar a disciplina pelo id
		dao = new FilmeDAO(getBaseContext());
		cursor = dao.consultarPeloId(id);
		cursor.moveToFirst();
		
		//Passando os valores para os widgets
		edtId.setText(id.toString());
		String nome = cursor.getString(cursor.getColumnIndexOrThrow(LocadoraHelper.NOME));
		edtNomeAlterar.setText(nome);
		Long ano = cursor.getLong(cursor.getColumnIndexOrThrow(LocadoraHelper.ANO));
		edtAnoAlterar.setText(ano.toString());
		String genero = cursor.getString(cursor.getColumnIndexOrThrow(LocadoraHelper.GENERO));
		edtGeneroAlterar.setText(genero);
		String pais = cursor.getString(cursor.getColumnIndexOrThrow(LocadoraHelper.PAIS));
		edtPaisAlterar.setText(pais);
		
		btnAlterar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Filme f = new Filme();
				f.setId(Integer.parseInt(edtId.getText().toString()));
				f.setNome(edtNomeAlterar.getText().toString());
				f.setAno(Integer.parseInt(edtAnoAlterar.getText().toString()));
				f.setGenero(edtGeneroAlterar.getText().toString());
				f.setPais(edtPaisAlterar.getText().toString());
				
				//Chamando o método alterar da classe dao
				dao.alterar(f);
				Intent intent = new Intent(AlterarExcluir.this, ListaFilmes.class);
				startActivity(intent);
				finish();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alterar_excluir, menu);
		return true;
	}

}
