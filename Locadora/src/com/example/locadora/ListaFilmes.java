package com.example.locadora;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListaFilmes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_filmes);
		
		// Definindo os campos da tabela
				String[] campos = { LocadoraHelper.ID,LocadoraHelper.NOME,LocadoraHelper.ANO, LocadoraHelper.GENERO, LocadoraHelper.PAIS };

				// Capturando os ids das widgets do grid
				int[] idViews = { R.id.edtId, R.id.edtNome, R.id.edtAno, R.id.edtGenero, R.id.edtPais };

				FilmeDAO dao = new FilmeDAO(getBaseContext());
				Cursor cursor = dao.listarTodos();
				SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.grid_lista_filmes, cursor, campos, idViews, 0);
				ListView lstFilmes = (ListView) findViewById(R.id.lstFilmes);
				lstFilmes.setAdapter(adapter);

				lstFilmes.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
						Intent intent = new Intent(ListaFilmes.this, AlterarExcluir.class);
						intent.putExtra("ID", id);
						startActivity(intent);
						finish();
					}
				});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.lista_filmes, menu);
//		return true;
//	}

}
