package ve.com.fsjv.devsicodetv.models;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author TecnoSoluciones-NS
 */
@Entity
@Table(name="block")
public class Block {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="title", nullable=false)
    @NotEmpty
    @NotNull
    private String title;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @Column(name="haveCells", nullable=false)
    @NotNull
    private boolean haveCells;
    
    @Column(name="createDate", nullable=false)
    @NotNull
    @Past
    private java.sql.Timestamp createDate;
    
    @Column(name="lastUpdated", nullable=false)
    @NotNull
    @Past
    private java.sql.Timestamp lastUpdated;
    
    @Column(name="lastSelected", nullable=false)
    @NotNull
    @Past
    private java.sql.Timestamp lastSelected;
    
    @OneToMany(mappedBy="block")
    private Set<Cell> cells;
    
    @Column(name="status", nullable=false)
    @NotNull
    @Digits(integer=1, fraction=0)
    private int status;

    public Block() {
    }

    public Block(long id, String title, String description, boolean haveCells, Timestamp createDate, Timestamp lastUpdated, Timestamp lastSelected) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.haveCells = haveCells;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
    }

    public Block(long id, String title, String description, boolean haveCells, Timestamp createDate, Timestamp lastUpdated, Timestamp lastSelected, Set<Cell> cells) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.haveCells = haveCells;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
        this.cells = cells;
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

    public boolean isHaveCells() {
        return haveCells;
    }

    public void setHaveCells(boolean haveCells) {
        this.haveCells = haveCells;
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

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
