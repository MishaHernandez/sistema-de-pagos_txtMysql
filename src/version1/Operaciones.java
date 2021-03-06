package version1;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Aqui van los metodos que utilizan consultas sql
 * 
 */

/**
 * @author Mijail J. Hernandez
 */
public class Operaciones {
    Conector con;
    
    public Operaciones(){
        con = new Conector();
    }
    
    public void insertar(ArrayList arraytxt){
        PreparedStatement pst;
        
        //convertir datos del array
        int idestud = Integer.parseInt((String) arraytxt.get(0));
        String nombre = (String) arraytxt.get(1);
        String apellidop = (String) arraytxt.get(2);
        String apellidom = (String) arraytxt.get(3);
        int idpago = Integer.parseInt((String) arraytxt.get(4));
        int monto = Integer.parseInt((String) arraytxt.get(5));
        
        String sql="insert into reporte (idestud, nombre, apellidop, apellidom, idpago, monto) values (?,?,?,?,?,?)";
        
        con.conectar();
        
        try {
            pst = con.conexion.prepareStatement(sql);
            //asignar valores a insertar
            pst.setInt(1, idestud);
            pst.setString(2, nombre);
            pst.setString(3, apellidop);
            pst.setString(4, apellidom);
            pst.setInt(5, idpago);
            pst.setInt(6, monto);
            pst.execute(); //ejecutar consulta
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        con.cerrar();
    }
}
