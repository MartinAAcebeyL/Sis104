package sis104.tareas.tarea3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sis104.tareas.tarea3.entities.Editorial;
import sis104.tareas.tarea3.entities.User;

public class MainActivityWebService extends AppCompatActivity {
    private Button btnweb, btnLocalService, btnWsDb;
    private TextView x;
    private UserService userService;
    private UserService localService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_service);

        btnweb = findViewById(R.id.btnwebService);
        btnweb.setOnClickListener(v -> callServiceUser());

        btnLocalService = findViewById(R.id.btnLocalService);
        btnLocalService.setOnClickListener(v -> callLocalService());

        btnWsDb = findViewById(R.id.btnWSDB);
        btnWsDb.setOnClickListener(v -> callLocalServiceDB());
        x=findViewById(R.id.txtP);
    }

    private void callServiceUser() {
        userService = RestEngine.getRestEngine().create(UserService.class);
        Call<List<User>> call =userService.listUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){
                    List<User> list = response.body();

                    String email = list.get(0).getEmail();
                    Toast.makeText(MainActivityWebService.this,email, Toast.LENGTH_LONG).show();
                    Log.i("WebService","DATA: "+email);
                }else{
                    Toast.makeText(MainActivityWebService.this,"Datos NO accesibles",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivityWebService.this,"Error",Toast.LENGTH_LONG).show();
                //Log.i("WebService","DATA: ERROR de URL");
            }
        });
    }

    private void callLocalService() {
        localService = RestEngineLocal.getRestEngine().create(UserService.class);
        Call<List<Editorial>> call =localService.listEditoriales();

        call.enqueue(new Callback<List<Editorial>>() {
            @Override
            public void onResponse(Call<List<Editorial>> call, Response<List<Editorial>> response) {

                if(response.isSuccessful()){
                    List<Editorial> list = response.body();

                    String editorial = list.get(1).getEditorial();

                    /*for(int i =0;i<list.size();i++){
                        crear(list.get(i).getName(),list.get(i).getName());
                        String resultado = "";
                        resultado +="nombre "+list.get(i).getName()+"\n";
                        resultado +="username "+list.get(i).getUsername()+"\n";
                        resultado +="email "+list.get(i).getEmail()+"\n";
                        resultado +="telefono "+list.get(i).getPhone()+"\n";
                        resultado +="webSite "+list.get(i).getWebsite()+"\n\n";
                        r.append(resultado);
                    }*/

                    Toast.makeText(MainActivityWebService.this, editorial, Toast.LENGTH_LONG).show();
                    Log.i("WebService","DATA: "+editorial);
                }else{
                    Toast.makeText(MainActivityWebService.this,"Datos NO accesibles",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Editorial>> call, Throwable t) {
                Toast.makeText(MainActivityWebService.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void callLocalServiceDB() {
        userService = RestEngine.getRestEngine().create(UserService.class);
        Call<List<User>> call = userService.listUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> list = response.body();

                    for(int i =0;i<list.size();i++){
                        String lat = list.get(i).getAddress().getGeo().getLat().toString();
                        String log = list.get(i).getAddress().getGeo().getLng().toString();
                        x.append(lat+'\n');
                        crear(lat,log);
                    }
                }else{
                    Toast.makeText(MainActivityWebService.this,"Datos NO accesibles",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    //base de datos
    public void crear(String latitud, String longitud){
        AdminCrudServicioWeb  admin = new AdminCrudServicioWeb(this,"tareaws", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //se lee el nombre

        //Varialbles de registro
        ContentValues registro = new ContentValues();

        float lat = Float.parseFloat(latitud);
        float log = Float.parseFloat(longitud);

        registro.put("latitud ", lat);
        registro.put("longitud ", log);
        //se insertan en la Bd
        db.insert("tareaWsBd",null, registro);

        //se cierra la conexion
        //db.close();

        //se limpian los campos
        Toast.makeText(this, "registro echo", Toast.LENGTH_LONG).show();
    }
}