package matheuslino.com.somador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int quantidade = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularComanda(View view) {
        int preco = quantidade * 5;
        String precoMessage = "Total: $" + preco;
        precoMessage += "\nObrigado!";
        displayMessage(precoMessage);
    }

    private void display(int number) {
        TextView quantidade = (TextView) findViewById(R.id.quantidade_tv);
        quantidade.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.preco_tv);
        priceTextView.setText(message);
    }

    public void incrementar(View view) {
        quantidade++;
        display(quantidade);
    }

    public void decrementar(View view) {
        if (quantidade > 0) {
            quantidade--;
            display(quantidade);
        }
    }
}
