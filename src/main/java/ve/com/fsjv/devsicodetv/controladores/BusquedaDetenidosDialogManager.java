/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogEvents;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogMethods;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogValidates;
import ve.com.fsjv.devsicodetv.modelos.FichaDetenido;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogManager extends MouseAdapter implements ActionListener {

    private BusquedaDetenidosDialog formulario;
    private Procesos procesos;
    private BusquedaDetenidosDialogEvents eventos;
    private BusquedaDetenidosDialogValidates validaciones;
    private BusquedaDetenidosDialogMethods metodos;
    private List<FichaDetenido> listaBusqueda;
    private FichaDetenido fichaDetenidoSeleccionada;

    public BusquedaDetenidosDialogManager() throws ExcepcionCampoVacio {
        this.formulario = new BusquedaDetenidosDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.eventos = new BusquedaDetenidosDialogEvents(this.formulario, this.procesos);
        this.validaciones = new BusquedaDetenidosDialogValidates(this.formulario, this.procesos);
        this.metodos = new BusquedaDetenidosDialogMethods(this.formulario, this.procesos);
        this.formulario.setSize(440, 440);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_BUSQUEDA_DETENIDOS, "Administrador", ConstantesApp.TITULO_DOBLE));
        this.procesos.limpiarClipboard();
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.eventos.iniciarFormulario();

        this.formulario.getRadAlias().addActionListener(this);
        this.formulario.getRadApellidos().addActionListener(this);
        this.formulario.getRadCedulaIdentidad().addActionListener(this);
        this.formulario.getRadNombres().addActionListener(this);
        this.formulario.getRadNombresApellidos().addActionListener(this);
        this.formulario.getRadNroControl().addActionListener(this);
        this.formulario.getRadPasaporte().addActionListener(this);
        this.formulario.getRadRasgoFisico().addActionListener(this);
        this.formulario.getBtnReiniciar().addActionListener(this);
        this.formulario.getBtnBuscar().addActionListener(this);

        this.formulario.getTabResultados().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.formulario.getTabResultados().setColumnSelectionAllowed(false);
        this.formulario.getTabResultados().setRowSelectionAllowed(true);
        this.formulario.getTabResultados().addMouseListener(this);
        this.formulario.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.formulario.getRadAlias() || e.getSource() == this.formulario.getRadApellidos() || e.getSource() == this.formulario.getRadCedulaIdentidad()
                || e.getSource() == this.formulario.getRadNombres() || e.getSource() == this.formulario.getRadNombresApellidos() || e.getSource() == this.formulario.getRadNroControl()
                || e.getSource() == this.formulario.getRadPasaporte() || e.getSource() == this.formulario.getRadRasgoFisico()) {
            try {
                this.eventos.habilitarFormulario();
            } catch (ExcepcionComponenteNulo ex) {
            }
        } else if (e.getSource() == this.formulario.getBtnReiniciar()) {
            this.eventos.iniciarFormulario();
        } else if (e.getSource() == this.formulario.getBtnBuscar()) {
            ArrayList<String> listaErrores = this.validaciones.validarCampos();
            String mensaje = ConstantesApp.VALIDACION_EXITOSA;
            String tituloMensaje = ConstantesApp.TITULO_VALIDACION;
            int iconoMensaje = JOptionPane.INFORMATION_MESSAGE;
            if (listaErrores.size() > 0) {
                iconoMensaje = JOptionPane.ERROR_MESSAGE;
                mensaje = ConstantesApp.VALIDACION_ERROR + "\n";
                for (int i = 0; i < listaErrores.size(); i++) {
                    mensaje = mensaje + "     - " + listaErrores.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(this.formulario, mensaje, tituloMensaje, iconoMensaje);
            } else {
                JOptionPane.showMessageDialog(this.formulario, mensaje, tituloMensaje, iconoMensaje);
                int respuesta = JOptionPane.showConfirmDialog(this.formulario, "Desea Iniciar la busqueda?", tituloMensaje, iconoMensaje);
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.out.println(this.formulario.getRadAlias().isSelected());
                    String campoBusqueda = "";
                    if (this.formulario.getRadAlias().isSelected()) {
                        campoBusqueda = "alias";
                    } else if (this.formulario.getRadApellidos().isSelected()) {
                        campoBusqueda = "apellidos";
                    } else if (this.formulario.getRadCedulaIdentidad().isSelected()) {
                        campoBusqueda = "cedulaIdentidad";
                    } else if (this.formulario.getRadNombres().isSelected()) {
                        campoBusqueda = "nombres";
                    } else if (this.formulario.getRadNombresApellidos().isSelected()) {
                        campoBusqueda = "ambos";
                    } else if (this.formulario.getRadNroControl().isSelected()) {
                        campoBusqueda = "idPersona";
                    } else if (this.formulario.getRadPasaporte().isSelected()) {
                        campoBusqueda = "pasaporte";
                    } else if (this.formulario.getRadRasgoFisico().isSelected()) {
                        campoBusqueda = "rasgo";
                    }
                    listaBusqueda = this.metodos.buscar(campoBusqueda, this.formulario.getTxtvalor().getText().trim());
                    TableModel model = new FichaTableModel(listaBusqueda);
                    //System.out.println("ape "+listaBusqueda.get(0).getPersona().getApellidos());
                    this.formulario.getTabResultados().setModel(model);
                } else if (respuesta == JOptionPane.CANCEL_OPTION) {
                    this.eventos.iniciarFormulario();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            Point p = e.getPoint();
            int row = formulario.getTabResultados().rowAtPoint(p);
            obtenerSeleccion(row);
        }
    }

    public FichaDetenido getFichaDetenidoSeleccionada() {
        return fichaDetenidoSeleccionada;
    }

    private void obtenerSeleccion(int row) {
        FichaTableModel model = (FichaTableModel) this.formulario.getTabResultados().getModel();
        fichaDetenidoSeleccionada = model.get(row);
        this.formulario.setVisible(false);
    }

    public static void main(String args[]) throws ExcepcionCampoVacio, ExcepcionComponenteNulo, Exception {
        System.out.println("comienza");
        BusquedaDetenidosDialogManager busqueda = new BusquedaDetenidosDialogManager();
        System.out.println("termina " + busqueda.getFichaDetenidoSeleccionada().getAlias());
    }

    class FichaTableModel extends AbstractTableModel {

        List<FichaDetenido> values;

        public FichaTableModel(List<FichaDetenido> valuesInfo) {
            this.values = valuesInfo;
        }

        public int getColumnCount() {
            return 3;
        }

        public int getRowCount() {
            return (values != null) ? (values.size()) : (0);
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Cedula";
                case 1:
                    return "Nombre";
                case 2:
                    return "Apellido";

            }
            return "??";
        }

        public Object getValueAt(int row, int column) {
            FichaDetenido info = get(row);
            if (info != null) {
                switch (column) {
                    case 0:
                        return info.getPersona().getCedulaIdentidad();
                    case 1:
                        return info.getPersona().getNombres();
                    case 2:
                        return info.getPersona().getApellidos();
                }
            }
            return "col(" + column + ")??";
            //return valuesTables.get(row);
        }

        public FichaDetenido get(int row) {
            if (row >= 0 && row < values.size()) {
                return (FichaDetenido) values.get(row);
            } else {
                return null;
            }
        }
    }
}
