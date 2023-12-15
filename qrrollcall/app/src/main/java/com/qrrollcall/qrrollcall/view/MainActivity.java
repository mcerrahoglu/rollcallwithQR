package com.qrrollcall.qrrollcall.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qrrollcall.qrrollcall.R;
import com.qrrollcall.qrrollcall.adapter.ApiClient;
import com.qrrollcall.qrrollcall.service.ApiService;
import com.qrrollcall.qrrollcall.databinding.ActivityMainBinding;
import com.qrrollcall.qrrollcall.model.Akademisyen;
import com.qrrollcall.qrrollcall.model.atilAkademisyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String dbURL;

    private ApiService apiService; // ApiService'yi uygun şekilde oluşturmanız gerekiyor

    private Button getDataButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dbURL = "jdbc:postgresql://localhost:5432/qrrollcall"; // Define your database URL here


        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        getDataButton = findViewById(R.id.getDataButton);
        resultTextView = findViewById(R.id.resultTextView);

        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.akid.getText().toString();
                String password = binding.akpassword.getText().toString();

                getAkademisyenData();

            }
        });



        atilAkademisyen atilAkademisyen = new atilAkademisyen();








        }

    private void getAkademisyenData() {



        Call<List<Akademisyen>> call = apiService.getAkademisyenler();

        call.enqueue(new Callback<List<Akademisyen>>() {
            @Override
            public void onResponse(Call<List<Akademisyen>> call, Response<List<Akademisyen>> response) {
                if (response.isSuccessful() && response.body() != null) {
                   List<Akademisyen> akademisyenList = response.body();
                    for (Akademisyen akademisyen : akademisyenList) {
                        displayAkademisyenInfo(akademisyen);
                    }
                    Toast.makeText(MainActivity.this,"responsa gitdi",Toast.LENGTH_LONG).show();
                } else {
                    resultTextView.setText("Bir hata oluştu.");
                }
            }

            @Override
            public void onFailure(Call<List<Akademisyen>> call, Throwable t) {
                resultTextView.setText("Bağlantı hatası: " + t.getMessage());
            }
        });
    }

    private void displayAkademisyenInfo(Akademisyen akademisyen) {
        resultTextView.setText("Akademisyen Bilgileri\n\n" +
                "Ad: " + akademisyen.getAk_ad()+ "\n" +
                "Soyad: " + akademisyen.getAk_soyad() + "\n" +
                "TC: " + akademisyen.getAk_tc());
    }




    public void signInClicked(View view) {
        String userName = binding.akid.getText().toString();
        String password = binding.akpassword.getText().toString();























/*
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Akademisyen>> call = apiService.getAkademisyenler();

        call.enqueue(new Callback<List<Akademisyen>>() {
            @Override
            public void onResponse(Call<List<Akademisyen>> call, Response<List<Akademisyen>> response) {
                if (response.isSuccessful()) {
                    List<Akademisyen> akademisyenList = response.body();
                    // Elde edilen verileri kullanabilirsiniz
                } else {
                    // İstek başarısızsa burada işlem yapabilirsiniz
                }
            }

            @Override
            public void onFailure(Call<List<Akademisyen>> call, Throwable t) {
                // Hata durumunda burada işlem yapabilirsiniz
            }
        });









        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter email and password", Toast.LENGTH_LONG).show();
        } else {
            // Execute DatabaseConnector AsyncTask to establish the database connection
            new DatabaseConnector() {
                @Override
                protected void onPostExecute(Connection connection) {
                    if (connection != null) {
                        try {
                            String query = "SELECT * FROM akademisyen WHERE ak_no = "+email+"  AND ak_sifre ="+password+"";
                            PreparedStatement preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setString(1, email);
                            preparedStatement.setString(2, password);

                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {
                                // User authenticated successfully
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                                forgotPage();
                            } else {
                                // User not found or incorrect credentials
                                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_LONG).show();
                            }

                            // Close the connections
                            resultSet.close();
                            preparedStatement.close();
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            // Handle SQL exceptions
                        }
                    } else {
                        // Database connection failed
                        Toast.makeText(MainActivity.this, "Database connection failed", Toast.LENGTH_LONG).show();
                    }
                }
            }.execute();
        }
        */

    }


    protected void forgotPage() {
        Intent forgotintent = new Intent(this, forgot_password.class);
        startActivity(forgotintent);
    }




}