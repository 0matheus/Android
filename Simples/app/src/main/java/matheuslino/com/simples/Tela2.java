package matheuslino.com.simples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String s1 = b.getString("VALOR1");
        String s2 = b.getString("VALOR2");
        TextView txtFrase = (TextView) findViewById(R.id.resultado);
        txtFrase.setText(s1 + " + " + s2 + " = " + s1+s2);
    }


}
