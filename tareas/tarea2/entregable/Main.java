public class Main {
    public static void main(String[] args){
        Conexion instacia_conexion = Conexion.create_conection();
        
        System.out.println(instacia_conexion.getBD());
        System.out.println(instacia_conexion.getPassword());
        System.out.println(instacia_conexion.getURL());
        System.out.println(instacia_conexion.getUser());

        instacia_conexion = Conexion.create_conection("1", "2", "3", "4");

        System.out.println(instacia_conexion.getBD());
        System.out.println(instacia_conexion.getPassword());
        System.out.println(instacia_conexion.getURL());
        System.out.println(instacia_conexion.getUser());

    }   
}