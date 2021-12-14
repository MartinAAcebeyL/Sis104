package sis104.tareas.tarea3.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Editorial {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("editorial")
    @Expose
    private String editorial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}