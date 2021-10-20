package sis104.tareas.a1erparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sis104.tareas.a1erparcial.entities.User;

public class MainActivityWebService extends AppCompatActivity {
    private Button btnweb;
    private TextView r;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_service);

        btnweb = findViewById(R.id.btnwebService);
        r = findViewById(R.id.txtResult);
        r.setMovementMethod(new ScrollingMovementMethod());
        btnweb.setOnClickListener(v -> callServiceUser());
    }

    private void callServiceUser() {
        userService = RestEngine.getRestEngine().create(UserService.class);
        Call<List<User>> call = userService.listUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){
                    List<User> list = response.body();

                    String email = list.get(0).getEmail();
                    //Toast.makeText(MainActivityWebService.this,email, Toast.LENGTH_LONG).show();
                    for(int i =0;i<list.size();i++){
                        String resultado = "";
                        resultado +="nombre "+list.get(i).getName()+"\n";
                        resultado +="username "+list.get(i).getUsername()+"\n";
                        resultado +="email "+list.get(i).getEmail()+"\n";
                        resultado +="telefono "+list.get(i).getPhone()+"\n";
                        resultado +="webSite "+list.get(i).getWebsite()+"\n\n";
                        r.append(resultado);
                    }
                    Log.i("WebService","DATA: "+email);
                }else{
                    Toast.makeText(MainActivityWebService.this,"Datos NO accesibles",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivityWebService.this,"Error",Toast.LENGTH_LONG).show();
                Log.i("WebService","DATA: ERROR de URL");
            }
        });
    }
}