package matheuslino.com.comanda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Button btnEfetivarPedido = (Button) findViewById(R.id.btnOk);
        btnEfetivarPedido.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        CheckBox cbxArroz = (CheckBox) findViewById(R.id.cbxArroz);
        CheckBox cbxFeijao = (CheckBox) findViewById(R.id.cbxFeijao);
        CheckBox cbxCarne = (CheckBox) findViewById(R.id.cbxCarne);
        CheckBox cbxFrango = (CheckBox) findViewById(R.id.cbxFrango);
        CheckBox cbxPeixe = (CheckBox) findViewById(R.id.cbxPeixe);
        CheckBox cbxSalada = (CheckBox) findViewById(R.id.cbxSalada);
        RadioGroup rdgCortesia = (RadioGroup) findViewById(R.id.rdgCortesia);
        TextView txtResultado = (TextView) findViewById(R.id.txtPedido);
        String resultado = "Itens Pedidos: ";


        if (cbxArroz.isChecked()) {
            resultado += cbxArroz.getText().toString() + ",";
        }
        if (cbxFeijao.isChecked()) {
            resultado += cbxFeijao.getText().toString() + ",";
        }
        if (cbxCarne.isChecked()) {
            resultado += cbxCarne.getText().toString() + ",";
        }
        if (cbxFrango.isChecked()) {
            resultado += cbxFrango.getText().toString() + ",";
        }
        if (cbxPeixe.isChecked()) {
            resultado += cbxPeixe.getText().toString() + ",";
        }
        if (cbxSalada.isChecked()) {
            resultado += cbxSalada.getText().toString() + ",";
        }
        if (rdgCortesia.getCheckedRadioButtonId() != -1){
            RadioButton rdbCortesia = (RadioButton) findViewById(rdgCortesia.getCheckedRadioButtonId());
            resultado += " \nCortesia: "+rdbCortesia.getText().toString()+".";
        }

        txtResultado.setText(resultado);

    }
}
