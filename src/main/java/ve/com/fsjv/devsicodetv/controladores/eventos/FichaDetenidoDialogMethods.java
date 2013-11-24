package ve.com.fsjv.devsicodetv.controladores.eventos;

import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.vistas.FichaDetenidoDialog;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.modelos.FichaDetenido;
import ve.com.fsjv.devsicodetv.modelos.Persona;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.DAO.FichaDetenidoDAO;
import ve.com.fsjv.devsicodetv.DAO.PersonaDAO;
/**
 *
 * @author FAMILIA-SJ
 */
public class FichaDetenidoDialogMethods {
    private FichaDetenidoDialog formulario;
    private Procesos procesos;
    public FichaDetenidoDialogMethods(FichaDetenidoDialog formulario, Procesos procesos) {
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public boolean guardar(int codigo){
        Persona p = new Persona();
        FichaDetenido fd = new FichaDetenido();
        PersonaDAO pDAO = new PersonaDAO();
        FichaDetenidoDAO fdDAO = new FichaDetenidoDAO();
        if(this.formulario.getTxtCedulaIdentidad().getText().replaceAll(" ", "").length() == 0){
            p.setCedulaIdentidad(codigo);
        }else{
            p.setCedulaIdentidad(Integer.valueOf(this.formulario.getTxtCedulaIdentidad().getText().trim()));
        }
        p.setNombres(this.formulario.getTxtNombres().getText().trim().toUpperCase());
        p.setApellidos(this.formulario.getTxtApellidos().getText().trim().toUpperCase());
        p.setEstadoCivil(this.formulario.getCmbEstadoCivil().getSelectedItem().toString());
        java.util.Date jud = this.procesos.convertirStringDateFecha(
                this.formulario.getCmbDia().getSelectedItem().toString() + "/" + this.formulario.getCmbMes().getSelectedItem().toString() + "/" + this.formulario.getCmbAnio().getSelectedItem().toString()
                , ConstantesApp.TIPO_VALIDACION_FECHA);
        p.setFechaNacimiento(this.procesos.convertirUtilDateSQLDateFecha(jud));
        p.setLugarNacimiento(this.formulario.getTxtLugarNacimiento().getText().trim().toUpperCase());
        p.setNacionalidad(this.formulario.getCmbNacionalidad().getSelectedItem().toString());
        p.setSexo(this.formulario.getCmbSexo().getSelectedItem().toString());
        p.setEstatus(ConstantesApp.ESTATUS_PERSONA_ACTIVO_VALUE);
        fd.setAlias(this.formulario.getTxtAlias().getText());
        fd.setAnioReservista(Integer.valueOf(this.formulario.getTxtAnio().getText()));
        fd.setCicatriz(this.formulario.getTxtCicatriz().getText().trim().toUpperCase());
        fd.setCodigoInterno(codigo);
        fd.setColorCabello(this.formulario.getCmbColorCabello().getSelectedItem().toString());
        fd.setColorOjos(this.formulario.getCmbColorOjos().getSelectedItem().toString());
        fd.setColorPiel(this.formulario.getCmbColorPiel().getSelectedItem().toString());
        fd.setContextura(this.formulario.getCmbContextura().getSelectedItem().toString());
        fd.setDireccionActual(this.formulario.getTxtDireccionActual().getText().toUpperCase().trim());
        fd.setDireccionAnterior(this.formulario.getTxtDireccionAnterior().getText().toUpperCase().trim());
        fd.setDireccionEmergencia(this.formulario.getTxtDireccionEmergencia().getText().toUpperCase().trim());
        fd.setDocumentoAnterior(this.formulario.getTxtDocumentoAnterior().getText().toUpperCase().trim());
        fd.setEstatura(Float.valueOf(this.formulario.getTxtEstatura().getText().trim()));
        fd.setEstatus(ConstantesApp.ESTATUS_PERSONA_ACTIVO_VALUE);
        fd.setEstatusControl(ConstantesApp.ESTATUS_DETENIDO_SIN_ASIGNAR);
        fd.setGradoInstruccion(this.formulario.getCmbGradoInstruccion().getSelectedItem().toString());
        fd.setLentes(this.formulario.getCmbLentes().getSelectedItem().toString());
        fd.setPasaporte(this.formulario.getTxtPasaporte().getText().trim().toUpperCase());
        fd.setProfesion(this.formulario.getTxtProfesion().getText().trim().toUpperCase());
        fd.setReligion(this.formulario.getTxtReligion().getText().trim().toUpperCase());
        fd.setReservista(this.formulario.getCmbReservista().getSelectedItem().toString());
        fd.setSeniasParticulares(this.formulario.getTxtSeniasParticulares().getText().trim().toUpperCase());
        fd.setTelefonoCelular(this.formulario.getTxtTelefonoCelular().getText().trim().toUpperCase());
        fd.setTelefonoEmergencia(this.formulario.getTxtTelefonoEmergencia().getText().trim().toUpperCase());
        fd.setTelefonoHabitacion(this.formulario.getTxtTelefonoHabitacion().getText().trim().toUpperCase());
        fd.setTipoNariz(this.formulario.getCmbTipoNariz().getSelectedItem().toString());
        fd.setTipoVivienda(this.formulario.getCmbTipoVivienda().getSelectedItem().toString());
        fd.setVivienda(this.formulario.getCmbVivienda().getSelectedItem().toString());
        fd.setPersona(p);
        Object obj = pDAO.insert(p);
        Object obj2 = fdDAO.insert(fd);
        if(obj.toString().replaceAll(" ", "").trim().length() > 0 && obj2.toString().replaceAll(" ", "").trim().length() > 0){
            return true;
        }
        return false;
    }
    
}
