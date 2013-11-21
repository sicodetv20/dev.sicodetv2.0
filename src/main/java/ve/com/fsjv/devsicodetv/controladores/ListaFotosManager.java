/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import net.coobird.thumbnailator.Thumbnails;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ImagenUtils;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.ListaFotosDialog;

/**
 *
 * @author Juan
 */
public class ListaFotosManager implements ActionListener {

    private final Procesos procesos;
    private ListaFotosDialog listaFotosDialog;
    private List<BufferedImage> imagenesTomadas;

    public ListaFotosManager(List<BufferedImage> imagenes) throws Exception {
        this.procesos = new Procesos();
        this.listaFotosDialog = new ListaFotosDialog(null, true);

        this.listaFotosDialog.getBtnGuardar().addActionListener(this);
        this.imagenesTomadas = imagenes;
        configurarTabla();
        this.listaFotosDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.listaFotosDialog.setVisible(true);
    }

    private void configurarTabla() {
        TableModel model = new ImagenTableModel(getListaTabla());
        this.listaFotosDialog.getTableImagenes().setModel(model);
        this.listaFotosDialog.getTableImagenes().setRowHeight(100);
    }

    private List<TableInfo> getListaTabla() {
        List<TableInfo> listaInfo = new ArrayList<TableInfo>();
        for (int i = 0; i < imagenesTomadas.size(); i++) {
            TableInfo info = new TableInfo();
            if (i == 0) {
                info.setDefecto(true);
            } else {
                info.setDefecto(false);
            }
            info.setSeleccionada(true);
            info.setImagen(new ImageIcon(ImagenUtils.redimensionarImagen(imagenesTomadas.get(i),100,100)));
            listaInfo.add(info);
        }
        return listaInfo;
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String args[]) throws ExcepcionCampoVacio, ExcepcionComponenteNulo, Exception {
        List<BufferedImage> bf = new ArrayList<BufferedImage>();
        bf.add(Thumbnails.of("C:\\Users\\Juan\\Documents\\NetBeansProjects\\pruebacam\\ori-1383867956177.jpg")
                .size(100, 100)
                .asBufferedImage());
        bf.add(Thumbnails.of("C:\\Users\\Juan\\Documents\\NetBeansProjects\\pruebacam\\ori-1383867956177.jpg")
                .size(100, 100)
                .asBufferedImage());
        bf.add(Thumbnails.of("C:\\Users\\Juan\\Documents\\NetBeansProjects\\pruebacam\\ori-1383867956177.jpg")
                .size(100, 100)
                .asBufferedImage());
        bf.add(Thumbnails.of("C:\\Users\\Juan\\Documents\\NetBeansProjects\\pruebacam\\ori-1383867956177.jpg")
                .size(100, 100)
                .asBufferedImage());
        new ListaFotosManager(bf);
    }

    class ImagenTableModel extends AbstractTableModel {

        List values;

        public ImagenTableModel(List<TableInfo> valuesInfo) {
            this.values = valuesInfo;
        }

        public int getColumnCount() {
            return 3;
        }

        public int getRowCount() {
            return (values != null) ? (values.size()) : (0);
        }

        TableInfo get(int row) {
            if (row >= 0 && row < values.size()) {
                return (TableInfo) values.get(row);
            } else {
                return null;
            }
        }

        public boolean isCellEditable(int row, int col) {
            if (col == 1 || col == 0) {
                return true;
            } else {
                return false;
            }
        }

        public void setValueAt(Object value, int row, int col) {
            TableInfo info = get(row);
            List<TableInfo> newValuesTables = new ArrayList<TableInfo>();
            if (col == 0) {
                info.setDefecto((Boolean) value);
            } else if (col == 1) {
                info.setSeleccionada((Boolean) value);
            }
            /*for (int i = 0; i < this.getRowCount(); i++) {
                TableInfo info1 = this.get(i);
                if (i == row) {
                    newValuesTables.add(info);
                } else {
                    if(col==0){
                        info1.setDefecto(false);
                    }
                    newValuesTables.add(info1);
                }
            }
            this.values = newValuesTables;*/
            fireTableCellUpdated(row, col);
        }

        public Object getValueAt(int row, int column) {
            TableInfo info = get(row);
            if (info != null) {
                switch (column) {
                    case 0:
                        return info.isDefecto();
                    case 1:
                        return info.isSeleccionada();
                    case 2:
                        return info.getImagen();
                }
            }
            return "col(" + column + ")??";
            //return valuesTables.get(row);
        }

        public Class<?> getColumnClass(int column) {
            return (getValueAt(0, column).getClass());
        }

        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Defecto";
                case 1:
                    return "Selecciona";
                case 2:
                    return "Thumb";

            }
            return "??";
        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("sample.png"));

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            lbl.setText((String) value);
            lbl.setIcon(icon);
            return lbl;
        }
    }

    class TableInfo {

        private boolean defecto;
        private boolean seleccionada;
        private ImageIcon imagen;

        public boolean isDefecto() {
            return defecto;
        }

        public void setDefecto(boolean defecto) {
            this.defecto = defecto;
        }

        public boolean isSeleccionada() {
            return seleccionada;
        }

        public void setSeleccionada(boolean seleccionada) {
            this.seleccionada = seleccionada;
        }

        public ImageIcon getImagen() {
            return imagen;
        }

        public void setImagen(ImageIcon imagen) {
            this.imagen = imagen;
        }
    }
}
