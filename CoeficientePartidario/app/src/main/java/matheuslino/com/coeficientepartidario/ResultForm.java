package matheuslino.com.coeficientepartidario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultForm extends AppCompatActivity {

    private Eleicao eleicao;

    TextView txt_totalVotantes;
    TextView txt_totalBrancos;
    TextView txt_totalNulos;
    TextView txt_totalVotosP1;
    TextView txt_totalVotosP2;
    TextView txt_totalVotosP3;
    TextView txt_qEleitoral;
    TextView txt_vagasP1;
    TextView txt_vagasP2;
    TextView txt_vagasP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_form);

        txt_totalVotantes = (TextView) findViewById(R.id.txt_totalVotantes);
        txt_totalBrancos = (TextView) findViewById(R.id.txt_totalBrancos);
        txt_totalNulos = (TextView) findViewById(R.id.txt_totalNulos);
        txt_totalVotosP1 = (TextView) findViewById(R.id.txt_totalVotosP1);
        txt_totalVotosP2 = (TextView) findViewById(R.id.txt_totalVotosP2);
        txt_totalVotosP3 = (TextView) findViewById(R.id.txt_totalVotosP3);
        txt_qEleitoral = (TextView) findViewById(R.id.txt_qEleitoral);
        txt_vagasP1 = (TextView) findViewById(R.id.txt_vagasP1);
        txt_vagasP2 = (TextView) findViewById(R.id.txt_vagasP2);
        txt_vagasP3 = (TextView) findViewById(R.id.txt_vagasP3);

        Votacao votacao = getIntent().getExtras().getParcelable("votacao");
        eleicao = new Eleicao(votacao);
        definirEleicao();
        atualizarCampos();


    }

    private void definirEleicao() {
        eleicao.calcular();
    }

    private void atualizarCampos() {
        txt_totalVotantes.setText(""+eleicao.getVotacao().getVotantes());
        txt_totalBrancos.setText(""+eleicao.getVotacao().getBrancos());
        txt_totalNulos.setText(""+eleicao.getVotacao().getNulos());
        txt_totalVotosP1.setText(""+eleicao.getVotacao().getVotosP1());
        txt_totalVotosP2.setText(""+eleicao.getVotacao().getVotosP2());
        txt_totalVotosP3.setText(""+eleicao.getVotacao().getVotosP3());
        txt_qEleitoral.setText(""+eleicao.getQuocienteEleitoral());
        txt_vagasP1.setText(""+eleicao.getVagasP1());
        txt_vagasP2.setText(""+eleicao.getVagasP2());
        txt_vagasP3.setText(""+eleicao.getVagasP3());

    }

    public Eleicao getEleicao() {
        return eleicao;
    }

    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }
}
