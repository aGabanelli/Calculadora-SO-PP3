package com.example.calculadoraso;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        findViewById(R.id.calculateButton).setOnClickListener((view) -> {
            EditText numberField = findViewById(R.id.numberField);
            String text = numberField.getText().toString();

            /*Enunciado
            *Fazer uma aplicacao android que receba o valor de n em um EditText
            * (Validar para n > 0 e n < 20). Calcule e mostre o resultado da a
            * serie 1 - 2/4 + 3/9 - 4/16 + 5/25 + ... Em um TextView.
            * Obs.: O pleno entendimento da série é parte da atividade.
            */

            if (!text.isEmpty()) {
                try {
                    int number = Integer.parseInt(text);
                    if (number <= 0 || number >= 20) {
                        Toast.makeText(MainActivity.this, "O número deve estar entre 1 e 19", Toast.LENGTH_SHORT).show();
                        TextView textView = findViewById(R.id.valueText);
                        textView.setText(String.valueOf(""));
                    } else {
                        double result = 0;
                        for (int i = 1; i <= number; i++) {
                            if (i % 2 == 0) { // É par
                                result -= i / Math.pow(i, 2);
                            } else { // É impar
                                result += i / Math.pow(i, 2);
                            }
                        }

                        TextView textView = findViewById(R.id.valueText);
                        textView.setText(String.valueOf(result));
                    }
                } catch(NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Por favor, insira um número válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}