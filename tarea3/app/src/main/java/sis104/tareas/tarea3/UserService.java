package sis104.tareas.tarea3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sis104.tareas.tarea3.entities.User;
import sis104.tareas.tarea3.entities.Editorial;

public interface UserService {
    @GET("users")
    Call<List<User>> listUsers();

    @GET("geteditoriales/")
    Call<List<Editorial>> listEditoriales();
}