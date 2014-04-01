/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.DAO.FichaDetenidoDAO;
import ve.com.fsjv.devsicodetv.models.FichaDetenido;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogMethods {
    private BusquedaDetenidosDialog formulario;
    private Utils procesos;
    private FichaDetenidoDAO fichaDetenidoDAO = new FichaDetenidoDAO();
    
    public BusquedaDetenidosDialogMethods(BusquedaDetenidosDialog formulario, Utils procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public List<FichaDetenido> buscar(String campo, String valor){
        List<FichaDetenido> lista = new ArrayList<FichaDetenido>();
        List<Serializable> listaResultados;
        //JOptionPane.showMessageDialog(this.formulario, "Valor: " + valor, "test", JOptionPane.INFORMATION_MESSAGE);
        String condicion = "where ";
        if(campo.equals("nombres") || campo.equals("apellidos") || campo.equals("cedulaIdentidad")){
            condicion += "p."+campo+" like '%"+valor.toUpperCase()+"%'";
        }else if(campo.equals("ambos")){
            condicion += "p.nombres like '%"+valor.toUpperCase()+"%' or p.apellidos like '%"+valor.toUpperCase()+"%'";
        }else if(campo.equals("alias") || campo.equals("pasaporte")){
            condicion += "v."+campo+" like '%"+valor.toUpperCase()+"%'";
        }else if(campo.equals("rasgos")){
            condicion += "v."+campo+" like '%"+valor.toUpperCase()+"%'";
        }
        listaResultados = fichaDetenidoDAO.buscarPorJoinPersona(FichaDetenido.class, condicion);
        System.out.println(lista.size());
        if(listaResultados.size()>0){
            for(int i=0; i<listaResultados.size(); i++){
                Object[] o = (Object[]) listaResultados.get(0);
                FichaDetenido f = (FichaDetenido)o[0];
                System.out.println(f.getPersona().getApellidos());
                lista.add(f);
            }
        }else{
            JOptionPane.showMessageDialog(this.formulario, "No hay resultados", "Busqueda de Detenidos", JOptionPane.INFORMATION_MESSAGE);
        }
        return lista;
    }
    
    
}
