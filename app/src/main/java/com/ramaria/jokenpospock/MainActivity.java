package com.ramaria.jokenpospock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View v){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View v){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View v){
        this.opcaoSelecionada("tesoura");
    }

    public void selecionadoLagarto(View v){
        this.opcaoSelecionada("lagarto");
    }

    public void selecionadoSpock(View v){
        this.opcaoSelecionada("spock");
    }

    public void opcaoSelecionada(String opcaoUsuario) {

        ImageView imagemResutado = findViewById(R.id.imagemResultado);
        TextView resultado = findViewById(R.id.escolhaResultado);

        int numero = new Random().nextInt(5);
        String[] opcoes = {"pedra", "papel", "tesoura", "lagarto", "spock"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imagemResutado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResutado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResutado.setImageResource(R.drawable.tesoura);
                break;
            case "lagarto":
                imagemResutado.setImageResource(R.drawable.lagarto);
                break;
            case "spock":
                imagemResutado.setImageResource(R.drawable.spock);
            default:
                break;
        }

        //configuração do resultado

        if (
                (opcaoApp == "tesoura" && (opcaoUsuario == "papel" || opcaoUsuario == "lagarto")) ||
                        (opcaoApp == "papel" && (opcaoUsuario == "pedra" || opcaoUsuario == "spock")) ||
                        (opcaoApp == "pedra" && (opcaoUsuario == "tesoura" || opcaoUsuario == "lagarto")) ||
                        (opcaoApp == "lagarto" && (opcaoUsuario == "papel" || opcaoUsuario == "spock")) ||
                        (opcaoApp == "spock" && (opcaoUsuario == "tesoura" || opcaoUsuario == "pedra"))

        ) { //App ganhou:

            resultado.setText("O App ganhou!");

        }else if(
                (opcaoUsuario == "tesoura" && (opcaoApp == "papel" || opcaoApp == "lagarto")) ||
                        (opcaoUsuario == "papel" && (opcaoApp == "pedra" || opcaoApp == "spock")) ||
                        (opcaoUsuario == "pedra" && (opcaoApp == "tesoura" || opcaoApp == "lagarto")) ||
                        (opcaoUsuario == "lagarto" && (opcaoApp == "papel" || opcaoApp == "spock")) ||
                        (opcaoUsuario == "spock" && (opcaoApp == "tesoura" || opcaoApp == "pedra"))

        ){ //usuario ganhou

            resultado.setText("Você ganhou!");

        }else { //empate

            resultado.setText("Empatou!");

        }

    }
}
