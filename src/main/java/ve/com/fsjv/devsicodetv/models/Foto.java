/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "foto", catalog = "sicodetdev")
public class Foto implements java.io.Serializable {

    private Long idfoto;
    private FichaDetenido fichaDetenido;
    private String filename;
    private String url;
    private Integer isDefault;
    private Integer status;

    public Foto() {
    }

    public Foto(FichaDetenido fichaDetenido, String filename, String url,
            Integer isDefault, Integer status) {
        this.fichaDetenido = fichaDetenido;
        this.filename = filename;
        this.url = url;
        this.isDefault = isDefault;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idfoto", unique = true, nullable = false)
    public Long getIdfoto() {
        return this.idfoto;
    }

    public void setIdfoto(Long idfoto) {
        this.idfoto = idfoto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_detenido_idficha_detenido")
    public FichaDetenido getFichaDetenido() {
        return this.fichaDetenido;
    }

    public void setFichaDetenido(FichaDetenido fichaDetenido) {
        this.fichaDetenido = fichaDetenido;
    }

    @Column(name = "filename")
    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column(name = "url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "is_default")
    public Integer getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
