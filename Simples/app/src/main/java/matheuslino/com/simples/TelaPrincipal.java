package matheuslino.com.simples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Button btnSomar = (Button) findViewById(R.id.btn_somar);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPrincipal.this, Tela2.class);
                Bundle b = new Bundle();
                EditText valor1 = (EditText) findViewById(R.id.valor1);
                EditText valor2 = (EditText) findViewById(R.id.valor2);
                b.putString("VALOR1", valor1.getText().toString());
                b.putString("VALOR2", valor2.getText().toString());
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

}
