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
@Table(name="cell")
public class Cell {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="title", nullable=false)
    private String title;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @Column(name="amountAllowed", nullable=false)
    private int amountAllowed;
    
    @Column(name="status", nullable=false)
    private int status;
    
    @Column(name="createDate", nullable=false)
    private java.sql.Timestamp createDate;
    
    @Column(name="lastUpdated", nullable=false)
    private java.sql.Timestamp lastUpdated;
    
    @Column(name="lastSelected", nullable=false)
    private java.sql.Timestamp lastSelected;
    
    @ManyToOne
    @JoinColumn(name="blockid")
    private Block block;

    public Cell() {
    }

    public Cell(long id, String title, String description, int amountAllowed, int status, Timestamp createDate, Timestamp lastUpdated, Timestamp lastSelected) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amountAllowed = amountAllowed;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
    }

    public Cell(long id, String title, String description, int amountAllowed, int status, Timestamp createDate, Timestamp lastUpdated, Timestamp lastSelected, Block block) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amountAllowed = amountAllowed;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
        this.block = block;
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

    public int getAmountAllowed() {
        return amountAllowed;
    }

    public void setAmountAllowed(int amountAllowed) {
        this.amountAllowed = amountAllowed;
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

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
    
    
    
}
