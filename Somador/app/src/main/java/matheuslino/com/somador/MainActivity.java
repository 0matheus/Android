package matheuslino.com.somador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularComanda(View view){
        display(1);
    }

    private void display(int number){
        TextView quantidade_tv = (TextView) findViewById(R.id.quantidade_tv);
        quantidade_tv.setText("" + number);
    }
}
