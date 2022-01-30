public class Conexion{
    private String BD;
    private String USER;
    private String PASSWORD;
    private String URL;
    private static Conexion conexion = null; 


    private Conexion(String URL, String USER, String PASSWORD, String BD) {
        this.BD = BD;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.URL = URL;
    }

    /*public String conection(){
        int numero = (int) (Math.random() * 10 + 1);
        if(numero % 3 == 0)
            return "Conexion exitosa";
        else
            return "Conexion fracasada";
    }*/

    public static final Conexion create_conection() {
        if(conexion == null)
            conexion = new Conexion("Localhost", "root", "", "BD_SIS104"); 
        return conexion; 
    }

    public static final Conexion create_conection(String URL, String USER, String PASSWORD, String BD) {
        if(conexion == null)
            conexion = new Conexion(URL, USER, PASSWORD, BD); 
        return conexion; 
    }

    public static Conexion getConexion() { return conexion; }
    public String getBD() { return BD; }
    public String getUser() { return USER; }
    public String getPassword() { return PASSWORD; }
    public String getURL() { return URL; }
}