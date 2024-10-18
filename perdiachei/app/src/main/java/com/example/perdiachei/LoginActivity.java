package com.example.perdiachei;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private TextView textShowHidePassword, textGoToRegister, textGoToChangePassword;
    private Button btnLogin;
    private ImageButton btnBackToHome;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Inicializando os elementos
        btnBackToHome = findViewById(R.id.imgbtn_voltar);
        editTextEmail = findViewById(R.id.txtmail_email);
        editTextPassword = findViewById(R.id.txtpsw_password);
        textShowHidePassword = findViewById(R.id.txt_mostrar_ocultar);
        btnLogin = findViewById(R.id.bnt_entrar);
        textGoToRegister = findViewById(R.id.txt_cadastro);
        textGoToChangePassword = findViewById(R.id.txt_esqueceuSenha);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Voltar para a tela inicial
        btnBackToHome.setOnClickListener(v -> {
            // Voltar para MainActivity (página inicial)
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Alternar entre mostrar e ocultar senha
        textShowHidePassword.setOnClickListener(v -> {
            if (isPasswordVisible) {
                // Ocultar senha
                editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                textShowHidePassword.setText("Mostrar");
            } else {
                // Mostrar senha
                editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                textShowHidePassword.setText("Ocultar");
            }
            isPasswordVisible = !isPasswordVisible;
            // Coloca o cursor no final da senha
            editTextPassword.setSelection(editTextPassword.getText().length());
        });

        // Validação de login
        btnLogin.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Aqui você pode adicionar uma validação do email e senha e realizar o login
            if (email.isEmpty() || password.isEmpty()) {
                // Mostrar uma mensagem de erro, por exemplo
                editTextEmail.setError("Campo obrigatório");
                editTextPassword.setError("Campo obrigatório");
            }
        });

        // Ir para a tela de recuperar Senha
        btnBackToHome.setOnClickListener(v -> {
            // Voltar para MainActivity (página inicial)
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Ir para a tela de cadastro
        textGoToRegister.setOnClickListener(v -> {
            // Ir para RegisterActivity (tela de cadastro)
            Intent intent = new Intent(LoginActivity.this, EsqueceuSenha.class);
            startActivity(intent);
        });

    }
}