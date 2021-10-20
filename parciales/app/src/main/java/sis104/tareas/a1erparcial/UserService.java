package sis104.tareas.a1erparcial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sis104.tareas.a1erparcial.entities.User;

public interface UserService {
    @GET("users")
    Call<List<User>> listUsers();
}
