package matheuslino.com.despesas_trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ResumeIntent = new Intent(MainForm.this, Resume.class);
                Bundle b = new Bundle();
                EditText nomeETxt = (EditText) findViewById(R.id.nCliente);
                EditText cidadeETxt = (EditText) findViewById(R.id.cCliente);
                EditText despesaETxt = (EditText) findViewById(R.id.vDespesa);

                b.putString("NOME", nomeETxt.getText().toString());
                b.putString("CIDADE", cidadeETxt.getText().toString());

                Double despesa = Double.parseDouble(despesaETxt.getText().toString());
                b.putDouble("DESPESA", despesa);

                ResumeIntent.putExtras(b);
                startActivity(ResumeIntent);
            }
        });
    }
}
