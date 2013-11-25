/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author FAMILIA-SJ
 */
@Entity
@Table(name="ficha_detenido", catalog="sicodetdev")
public class FichaDetenido implements Serializable {

    private Integer id;
    private Integer codigoInterno;
    private Integer codigoRelacional;
    private String alias;
    private Integer anioReservista;
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
    
    public FichaDetenido() {
    }

    public FichaDetenido(Integer id, Integer codigoInterno, Integer codigoRelacional, String alias, Integer anioReservista, String cicatriz, String colorCabello, String colorOjos, String colorPiel, String contextura, String direccionActual, String direccionAnterior, String direccionEmergencia, String documentoAnterior, float estatura, String estatusControl, String gradoInstruccion, String lentes, String pasaporte, String profesion, String religion, String reservista, String seniasParticulares, String telefonoCelular, String telefonoHabitacion, String telefonoEmergencia, String tipoVivienda, String tipoNariz, String vivienda, int estatus, Persona persona) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.codigoRelacional = codigoRelacional;
        this.alias = alias;
        this.anioReservista = anioReservista;
        this.cicatriz = cicatriz;
        this.colorCabello = colorCabello;
        this.colorOjos = colorOjos;
        this.colorPiel = colorPiel;
        this.contextura = contextura;
        this.direccionActual = direccionActual;
        this.direccionAnterior = direccionAnterior;
        this.direccionEmergencia = direccionEmergencia;
        this.documentoAnterior = documentoAnterior;
        this.estatura = estatura;
        this.estatusControl = estatusControl;
        this.gradoInstruccion = gradoInstruccion;
        this.lentes = lentes;
        this.pasaporte = pasaporte;
        this.profesion = profesion;
        this.religion = religion;
        this.reservista = reservista;
        this.seniasParticulares = seniasParticulares;
        this.telefonoCelular = telefonoCelular;
        this.telefonoHabitacion = telefonoHabitacion;
        this.telefonoEmergencia = telefonoEmergencia;
        this.tipoVivienda = tipoVivienda;
        this.tipoNariz = tipoNariz;
        this.vivienda = vivienda;
        this.estatus = estatus;
        this.persona = persona;
    }
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="idficha_detenido", unique=true, nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="codigo_detenido", nullable=false)
    public Integer getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(Integer codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    @Column(name="codigo_relacional", nullable=true)
    public Integer getCodigoRelacional() {
        return codigoRelacional;
    }

    public void setCodigoRelacional(Integer codigoRelacional) {
        this.codigoRelacional = codigoRelacional;
    }

    @Column(name="alias", nullable=true)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Column(name="anio_reservista", nullable=true)
    public Integer getAnioReservista() {
        return anioReservista;
    }

    public void setAnioReservista(Integer anioReservista) {
        this.anioReservista = anioReservista;
    }

    @Column(name="cicatriz", nullable=true)
    public String getCicatriz() {
        return cicatriz;
    }

    public void setCicatriz(String cicatriz) {
        this.cicatriz = cicatriz;
    }

    @Column(name="color_cabello", nullable=true)
    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    @Column(name="color_ojos", nullable=true)
    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    @Column(name="color_piel", nullable=true)
    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    @Column(name="contextura", nullable=true)
    public String getContextura() {
        return contextura;
    }

    public void setContextura(String contextura) {
        this.contextura = contextura;
    }

    @Column(name="direccion_actual", nullable=true)
    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

    @Column(name="direccion_anterior", nullable=true)
    public String getDireccionAnterior() {
        return direccionAnterior;
    }

    public void setDireccionAnterior(String direccionAnterior) {
        this.direccionAnterior = direccionAnterior;
    }

    @Column(name="direccion_emergencia", nullable=true)
    public String getDireccionEmergencia() {
        return direccionEmergencia;
    }

    public void setDireccionEmergencia(String direccionEmergencia) {
        this.direccionEmergencia = direccionEmergencia;
    }

    @Column(name="documento_anterior", nullable=true)
    public String getDocumentoAnterior() {
        return documentoAnterior;
    }

    public void setDocumentoAnterior(String documentoAnterior) {
        this.documentoAnterior = documentoAnterior;
    }

    @Column(name="estatura", nullable=true)
    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    @Column(name="estatus_control", nullable=true)
    public String getEstatusControl() {
        return estatusControl;
    }

    public void setEstatusControl(String estatusControl) {
        this.estatusControl = estatusControl;
    }

    @Column(name="grado_instruccion", nullable=true)
    public String getGradoInstruccion() {
        return gradoInstruccion;
    }

    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }

    @Column(name="lentes", nullable=true)
    public String getLentes() {
        return lentes;
    }

    public void setLentes(String lentes) {
        this.lentes = lentes;
    }

    @Column(name="pasaporte", nullable=true)
    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Column(name="profesion", nullable=true)
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Column(name="religion", nullable=true)
    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Column(name="reservista", nullable=true)
    public String getReservista() {
        return reservista;
    }

    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    @Column(name="senias_particulares", nullable=true)
    public String getSeniasParticulares() {
        return seniasParticulares;
    }

    public void setSeniasParticulares(String seniasParticulares) {
        this.seniasParticulares = seniasParticulares;
    }

    @Column(name="telefono_celular", nullable=true)
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    @Column(name="telefono_habitacion", nullable=true)
    public String getTelefonoHabitacion() {
        return telefonoHabitacion;
    }

    public void setTelefonoHabitacion(String telefonoHabitacion) {
        this.telefonoHabitacion = telefonoHabitacion;
    }

    @Column(name="telefono_emergencia", nullable=true)
    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    @Column(name="tipo_vivienda", nullable=true)
    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Column(name="tipo_nariz", nullable=true)
    public String getTipoNariz() {
        return tipoNariz;
    }

    public void setTipoNariz(String tipoNariz) {
        this.tipoNariz = tipoNariz;
    }

    @Column(name="vivienda", nullable=true)
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_idpersona", nullable = false)
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
