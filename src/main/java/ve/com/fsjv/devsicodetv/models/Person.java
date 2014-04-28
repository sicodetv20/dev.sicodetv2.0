package ve.com.fsjv.devsicodetv.models;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class Person {
    private long id;
    private int status;
    private java.sql.Timestamp createDate;
    private java.sql.Timestamp lastUpdated;
    private java.sql.Timestamp lastSelected;
    private String ic;
    private String firstName;
    private String lastName;
    private String sex;
    private String nationality;
    private String maritalStatus;
    private java.sql.Date birthDate;
    private String birthLocation;
    private String type;
    private String passportNumber;
    
    public Person(){
    }
    
    public Person(long id, int status, java.sql.Timestamp createDate, java.sql.Timestamp lastUpdated, 
            java.sql.Timestamp lastSelected, String ic, String firstName, String lastName, String sex,
            String nationality, String maritalStatus, java.sql.Date birthDate, String birthLocation, 
            String type, String passportNumber){
        this.id = id;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdated = lastUpdated;
        this.lastSelected = lastSelected;
        this.ic = ic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.birthDate = birthDate;
        this.birthLocation = birthLocation;
        this.type = type;
        this.passportNumber = passportNumber;
    }

    @Id
    @GeneratedValue(strategy= IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    @NotNull
    @NotEmpty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    @Column(name="status", nullable=false)
    @NotNull
    @NotEmpty
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name="createDate", nullable=false)
    @NotNull
    @NotEmpty
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Column(name="lastUpdated", nullable=false)
    @NotNull
    @NotEmpty
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Column(name="lastSelected", nullable=false)
    @NotNull
    @NotEmpty
    public Timestamp getLastSelected() {
        return lastSelected;
    }

    public void setLastSelected(Timestamp lastSelected) {
        this.lastSelected = lastSelected;
    }

    @Column(name="ic", nullable=true)
    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    @Column(name="firstName", nullable=true)
    @Min(value=2)
    @Max(value=100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastName", nullable=true)
    @Min(value=2)
    @Max(value=100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="sex", nullable=true)
    @Min(value=1)
    @Max(value=1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name="nationality", nullable=true)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name="maritalStatus", nullable=true)
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Column(name="birthDate", nullable=true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name="birthLocation", nullable=true)
    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    @Column(name="type", nullable=false)
    @NotNull
    @NotEmpty
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="passportNumber", nullable=true)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    
}