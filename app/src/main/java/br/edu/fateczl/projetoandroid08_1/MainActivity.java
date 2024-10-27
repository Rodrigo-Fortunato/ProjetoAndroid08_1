package br.edu.fateczl.projetoandroid08_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Rodrigo Fortunato Martins Neves>
     */
    private Button btnComprar;
    private RadioButton rbIngressoComum;
    private RadioButton rbIngressoVip;
    private Spinner spQuantIngresso;
    private Spinner spFilmes;
    private RadioGroup rgTipoIngresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnComprar = findViewById(R.id.btnComprar);
        rbIngressoComum = findViewById(R.id.rbIngressoComum);
        rbIngressoVip = findViewById(R.id.rbIngressoVip);
        spQuantIngresso = findViewById(R.id.spQuantIngresso);
        spFilmes = findViewById(R.id.spFilmes);
        rgTipoIngresso = findViewById(R.id.rgTipoIngresso);

        rbIngressoComum.setChecked(true);

        preencherSpinnerFilme();
        preencherSpinnerIngresso();

        Bundle bundle = new Bundle();




        btnComprar.setOnClickListener(e ->{
            bundle.putString("Filme", spFilmes.getSelectedItem().toString());
            bundle.putInt("Quantidade", Integer.parseInt(spQuantIngresso.getSelectedItem().toString()));
            Log.i("QuantidadeSpinner",(spQuantIngresso.getSelectedItem().toString()));
            if (rbIngressoComum.isChecked()){
                bundle.putString("Ingresso",rbIngressoComum.getText().toString());
            }else {
                bundle.putString("Ingresso", rbIngressoVip.getText().toString());
            }
            comprar(bundle);
        });
    }

    private void comprar(Bundle bundle) {
        Intent intent = new Intent(this,DadosCompra.class);
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();

    }

    private void preencherSpinnerFilme() {
        List<String> lista = new ArrayList<>();
        lista.add("Shrek");
        lista.add("A fuga das galinhas");
        lista.add("Constantine");
        lista.add("O Poderoso Chefão");
        lista.add("Matrix");
        lista.add("Interestelar");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFilmes.setAdapter(adapter);

    }

    private void preencherSpinnerIngresso() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            lista.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuantIngresso.setAdapter(adapter);

    }


}