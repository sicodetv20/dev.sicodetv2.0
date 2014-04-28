package ve.com.fsjv.devsicodetv.models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TecnoSoluciones-NS
 */
@Entity
@Table(name="outputtopic")
public class OutputTopic {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="title", nullable=false)
    private String title;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @Column(name="status", nullable=false)
    private int status;
    
    @Column(name="createDate", nullable=false)
    private java.sql.Timestamp createDate;
    
    @Column(name="lastUpdated", nullable=false)
    private java.sql.Timestamp lastUpdated;
    
    @Column(name="lastSelected", nullable=false)
    private java.sql.Timestamp lastSelected;
    
    @ManyToOne
    @JoinColumn(name="outputtypeid")
    private OutputType outputType;
    
    public OutputTopic() {
    }

    public OutputTopic(long id, String title, String description, int status, Timestamp createDate, Timestamp lastUpdated, Timestamp lastSelected) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Timestamp getLastSelected() {
        return lastSelected;
    }

    public void setLastSelected(Timestamp lastSelected) {
        this.lastSelected = lastSelected;
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }
    
}
