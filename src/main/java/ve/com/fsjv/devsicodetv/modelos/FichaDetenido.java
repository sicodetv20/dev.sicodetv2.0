/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ve.com.fsjv.devsicodetv.modelos.Persona;

/**
 *
 * @author FAMILIA-SJ
 */
@Entity
@Table(name="ficha_detenido", catalog="sicodetdev")
public class FichaDetenido implements Serializable {
    
    private int id;
    private String codigoInterno;
    private String codigoRelacional;
    private String alias;
    private int anioReservista;
    private String cicatriz;
    private String colorCabello;
    private String colorOjos;
    private String colorPiel;
    private String contextura;
    private String direccionActual;
    private String direccionAnterior;
    private String direccionEmergencia;
    private String documentoAnterior;
    private float estatura;
    private String estatusControl;
    private String gradoInstruccion;
    private String lentes;
    private String pasaporte;
    private String profesion;
    private String religion;
    private String reservista;
    private String seniasParticulares;
    private String telefonoCelular;
    private String telefonoHabitacion;
    private String telefonoEmergencia;
    private String tipoVivienda;
    private String tipoNariz;
    private String vivienda;
    private int estatus;
    private Persona persona;
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="idficha_detenido", unique=true, nullable=true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="codigo_interno", nullable=true)
    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    @Column(name="codigo_relacional", nullable=true)
    public String getCodigoRelacional() {
        return codigoRelacional;
    }

    public void setCodigoRelacional(String codigoRelacional) {
        this.codigoRelacional = codigoRelacional;
    }

    @Column(name="alias", nullable=false)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Column(name="anio_reservista", nullable=false)
    public int getAnioReservista() {
        return anioReservista;
    }

    public void setAnioReservista(int anioReservista) {
        this.anioReservista = anioReservista;
    }

    @Column(name="cicatriz", nullable=false)
    public String getCicatriz() {
        return cicatriz;
    }

    public void setCicatriz(String cicatriz) {
        this.cicatriz = cicatriz;
    }

    @Column(name="color_cabello", nullable=false)
    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    @Column(name="color_ojos", nullable=false)
    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    @Column(name="color_piel", nullable=false)
    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    @Column(name="contextura", nullable=false)
    public String getContextura() {
        return contextura;
    }

    public void setContextura(String contextura) {
        this.contextura = contextura;
    }

    @Column(name="direccion_actual", nullable=false)
    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

    @Column(name="direccion_anterior", nullable=false)
    public String getDireccionAnterior() {
        return direccionAnterior;
    }

    public void setDireccionAnterior(String direccionAnterior) {
        this.direccionAnterior = direccionAnterior;
    }

    @Column(name="direccion_emergencia", nullable=false)
    public String getDireccionEmergencia() {
        return direccionEmergencia;
    }

    public void setDireccionEmergencia(String direccionEmergencia) {
        this.direccionEmergencia = direccionEmergencia;
    }

    @Column(name="documento_anterior", nullable=false)
    public String getDocumentoAnterior() {
        return documentoAnterior;
    }

    public void setDocumentoAnterior(String documentoAnterior) {
        this.documentoAnterior = documentoAnterior;
    }

    @Column(name="estatura", nullable=false)
    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    @Column(name="estatus_control", nullable=false)
    public String getEstatusControl() {
        return estatusControl;
    }

    public void setEstatusControl(String estatusControl) {
        this.estatusControl = estatusControl;
    }

    @Column(name="grado_instruccion", nullable=false)
    public String getGradoInstruccion() {
        return gradoInstruccion;
    }

    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }

    @Column(name="lentes", nullable=false)
    public String getLentes() {
        return lentes;
    }

    public void setLentes(String lentes) {
        this.lentes = lentes;
    }

    @Column(name="pasaporte", nullable=false)
    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Column(name="profesion", nullable=false)
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Column(name="religion", nullable=false)
    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Column(name="reservista", nullable=false)
    public String getReservista() {
        return reservista;
    }

    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    @Column(name="senias_particulares", nullable=false)
    public String getSeniasParticulares() {
        return seniasParticulares;
    }

    public void setSeniasParticulares(String seniasParticulares) {
        this.seniasParticulares = seniasParticulares;
    }

    @Column(name="telefono_celular", nullable=false)
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    @Column(name="telefono_habitacion", nullable=false)
    public String getTelefonoHabitacion() {
        return telefonoHabitacion;
    }

    public void setTelefonoHabitacion(String telefonoHabitacion) {
        this.telefonoHabitacion = telefonoHabitacion;
    }

    @Column(name="telefono_emergencia", nullable=false)
    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    @Column(name="tipo_vivienda", nullable=false)
    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Column(name="tipo_nariz", nullable=false)
    public String getTipoNariz() {
        return tipoNariz;
    }

    public void setTipoNariz(String tipoNariz) {
        this.tipoNariz = tipoNariz;
    }

    @Column(name="vivienda", nullable=false)
    public String getVivienda() {
        return vivienda;
    }

    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    @Column(name="estatus", nullable=false)
    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ficha_detenido", cascade = CascadeType.ALL)
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
