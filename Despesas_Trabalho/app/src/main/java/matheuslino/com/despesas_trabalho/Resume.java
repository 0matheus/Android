package matheuslino.com.despesas_trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resume extends AppCompatActivity {

    public Double desconto = 0.0;
    public Double valorLiquido = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Resume.this, MainForm.class);
                startActivity(i);

            }
        });

        Intent iResume = getIntent();
        Bundle bResume = iResume.getExtras();
        Double despesa = bResume.getDouble("DESPESA");
        calcularDesconto(despesa);
        String nome = bResume.getString("NOME");
        String cidade = bResume.getString("CIDADE");
        TextView txtNome = (TextView) findViewById(R.id.txt_ResumeCliente);
        txtNome.setText(nome);
        TextView txtCidade = (TextView) findViewById(R.id.txt_ResumeCidade);
        txtCidade.setText(cidade);
        TextView txtDespesa = (TextView) findViewById(R.id.txt_ResumeDespesa);
        txtDespesa.setText(despesa.toString());
        TextView txtDesconto = (TextView) findViewById(R.id.txt_ResumeDesconto);
        txtDesconto.setText(desconto.toString());
        TextView txtValorL = (TextView) findViewById(R.id.txt_ResumeValorLiquido);
        txtValorL.setText(valorLiquido.toString());


    }

    private void calcularDesconto(Double despesa) {
        if (despesa <= 500) {
            desconto = 0.05;
            valorLiquido = despesa - (despesa * desconto);
        } else if (despesa < 1000) {
            desconto = 0.10;
            valorLiquido = despesa - (despesa * desconto);
        } else {
            desconto = 0.15;
            valorLiquido = despesa - (despesa * desconto);
        }
    }

}
