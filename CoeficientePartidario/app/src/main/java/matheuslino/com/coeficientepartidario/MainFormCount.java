package matheuslino.com.coeficientepartidario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainFormCount extends AppCompatActivity {

    private Votacao votacao;

    TextView txt_nVagas;
    TextView txt_nVotantes;
    TextView txt_nBrancos;
    TextView txt_nNulos;
    TextView txt_votosP1;
    TextView txt_votosP2;
    TextView txt_votosP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_count);

        txt_nVagas = (TextView) findViewById(R.id.txt_nVagas);
        txt_nVotantes = (TextView) findViewById(R.id.txt_nVotantes);
        txt_nBrancos = (TextView) findViewById(R.id.txt_nBrancos);
        txt_nNulos = (TextView) findViewById(R.id.txt_nNulos);
        txt_votosP1 = (TextView) findViewById(R.id.txt_votosP1);
        txt_votosP2 = (TextView) findViewById(R.id.txt_votosP2);
        txt_votosP3 = (TextView) findViewById(R.id.txt_votosP3);



        Button btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votacao = new Votacao(
                        Integer.parseInt(txt_nVagas.getText().toString()),
                        Integer.parseInt(txt_nVotantes.getText().toString()),
                        Integer.parseInt(txt_nBrancos.getText().toString()),
                        Integer.parseInt(txt_nNulos.getText().toString()),
                        Integer.parseInt(txt_votosP1.getText().toString()),
                        Integer.parseInt(txt_votosP2.getText().toString()),
                        Integer.parseInt(txt_votosP3.getText().toString())
                );

                Intent i = new Intent(MainFormCount.this, ResultForm.class);
                i.putExtra("votacao", votacao);
                startActivity(i);
            }
        });
    }


    public Votacao getVotacao() {
        return votacao;
    }

    public void setVotacao(Votacao votacao) {
        this.votacao = votacao;
    }

}
