package br.edu.fateczl.projetoandroid08_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import br.edu.fateczl.projetoandroid08_1.model.Ingresso;
import br.edu.fateczl.projetoandroid08_1.model.IngressoVip;

public class DadosCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dados_compra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

       String ingresso = bundle.getString("Ingresso");
        Log.i("tipoIngresso", String.valueOf(ingresso));

        Ingresso ingressoComprado;
        if (Objects.equals(ingresso, "Ingresso Comum")){
            ingressoComprado = new Ingresso(15);

        }else {
            ingressoComprado = new IngressoVip(20);

        }


        StringBuilder builder = new StringBuilder();
        builder.append("Filme Comprado: ");
        builder.append(bundle.getString("Filme"));
        builder.append("\n");
        builder.append("Quantidade Ingressos: ");
        builder.append(bundle.getInt("Quantidade"));
        builder.append("\n");
        builder.append("Total: ");
        builder.append(bundle.getInt("Quantidade") * ingressoComprado.valorFinal(7) );

        Log.i("builder",builder.toString());
       tvResultado.setText(builder.toString());

        btnVoltar.setOnClickListener(e-> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this,MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}