package matheuslino.com.calculadora_t2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {

    String nAtual = "0";
    String nAnterior;
    char charOP = ' ';

    public TextView getTxt_resultado() {
        return txt_resultado;
    }

    public void setTxt_resultado(TextView txt_resultado) {
        this.txt_resultado = txt_resultado;
    }

    TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        txt_resultado = (TextView) findViewById(R.id.txt_resultado);

        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Button btn_dec = (Button) findViewById(R.id.btn_dec);
        Button btn_equ = (Button) findViewById(R.id.btn_equ);
        Button btn_limpar = (Button) findViewById(R.id.btn_limpar);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_dec.setOnClickListener(this);
        btn_equ.setOnClickListener(this);
        btn_limpar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_0:
                concatenaNumeroAtual("0");
                break;
            case R.id.btn_1:
                concatenaNumeroAtual("1");
                break;
            case R.id.btn_2:
                concatenaNumeroAtual("2");
                break;
            case R.id.btn_3:
                concatenaNumeroAtual("3");
                break;
            case R.id.btn_4:
                concatenaNumeroAtual("4");
                break;
            case R.id.btn_5:
                concatenaNumeroAtual("5");
                break;
            case R.id.btn_6:
                concatenaNumeroAtual("6");
                break;
            case R.id.btn_7:
                concatenaNumeroAtual("7");
                break;
            case R.id.btn_8:
                concatenaNumeroAtual("8");
                break;
            case R.id.btn_9:
                concatenaNumeroAtual("9");
                break;
            case R.id.btn_add:
                setCharOP('+');
                mudaAtual();
                break;
            case R.id.btn_sub:
                setCharOP('-');
                mudaAtual();
                break;
            case R.id.btn_mul:
                setCharOP('x');
                mudaAtual();
                break;
            case R.id.btn_div:
                setCharOP('÷');
                mudaAtual();
                break;
            case R.id.btn_equ:
                calcular();
                break;
            case R.id.btn_dec:
                break;
            case R.id.btn_limpar:
                limpar();
                break;
        }

        atualizaResultado();

    }

    private void mudaAtual() {
        setNAnterior(getNAtual());
        setNAtual("");
    }

    private void atualizaResultado() {
        if (getNAnterior() == null)
            txt_resultado.setText("" + getNAtual());
        else
            txt_resultado.setText("" + getNAnterior() + getCharOP() + getNAtual() );
    }

    private void calcular() {
        Double resultado = Double.valueOf(0);

        if (getNAnterior() != null) {

            switch (getCharOP()) {
                case '+':
                    resultado = Double.parseDouble(getNAnterior()) + Double.parseDouble(getNAtual());
                    break;
                case '-':
                    resultado = Double.parseDouble(getNAnterior()) - Double.parseDouble(getNAtual());
                    break;
                case 'x':
                    resultado = Double.parseDouble(getNAnterior()) * Double.parseDouble(getNAtual());
                    break;
                case '÷':
                    resultado = Double.parseDouble(getNAnterior()) / Double.parseDouble(getNAtual());
                    break;
            }
        }
        setNAnterior(null);
        setNAtual(resultado.toString());

    }

    private void concatenaNumeroAtual(String numeroAConcatenar) {
        if (getNAtual() == "0") setNAtual(numeroAConcatenar);
        else setNAtual("" + getNAtual() + numeroAConcatenar);
    }

    private void limpar() {
        setNAtual("0");
        setNAnterior(null);
        setCharOP(' ');

    }

    public String getNAtual() {
        return nAtual;
    }

    public void setNAtual(String nAtual) {
        this.nAtual = nAtual;
    }

    public String getNAnterior() {
        return nAnterior;
    }

    public void setNAnterior(String nAnterior) {
        this.nAnterior = nAnterior;
    }

    public char getCharOP() {
        return charOP;
    }

    public void setCharOP(char charOP) {
        this.charOP = charOP;
    }
}
