package cs544.letmegiveexam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Arjun
 */
@Entity
        @Table(name = "User")
        @NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id= :id"),
        @NamedQuery(name = "User.findByRole_id", query = "SELECT u FROM User u WHERE u.role_id= :role_id"),
        @NamedQuery(name="User.findByEmail", query = "SELECT u FROM User u WHERE u.email= :email"),
        @NamedQuery(name="User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName= :firstName"),
        @NamedQuery(name="User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName= :lastName"),
        @NamedQuery(name="User.findByUsername", query = "SELECT u FROM User u WHERE u.username= :username"),
        @NamedQuery(name="User.findByPassword", query = "SELECT u FROM User u WHERE u.password= :assword"),
        @NamedQuery(name="User.findByLockCount", query = "SELECT u FROM User u WHERE u.lockCount= :lockCount"),
        @NamedQuery(name="User.findByLockTime", query = "SELECT u FROM User u WHERE u.lockTime= :ockTime"),
        @NamedQuery(name="User.findByEnabled", query = "SELECT u FROM User u WHERE u.enabled= :enabled"),
        @NamedQuery(name="User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole= :userRole"),
        @NamedQuery(name="User.findByUserExamList", query = "SELECT u FROM User u WHERE u.userExamList= :userExamList")
    })
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int role_id;

    @Column(nullable = false, name = "Email")
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false, name = "FirstName")
    @NotBlank
    private String firstName;

    @Column(nullable = false, name = "LastName")
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank
    @Pattern(regexp="^[a-zA-Z]\\w{3,14}$",message = "The password's first character must be a letter, it must contain at least 4 characters and no more than 15 characters and no characters other than letters, numbers and the underscore may be used")
    private String password;

    private int lockCount;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lockTime;

    private boolean enabled;

    @ManyToOne
    private Role userRole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserExam> userExamList = new ArrayList<UserExam>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLockCount() {
        return lockCount;
    }

    public void setLockCount(int lockCount) {
        this.lockCount = lockCount;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public List<UserExam> getUserExamList() {
        return userExamList;
    }

    public void setUserExamList(List<UserExam> userExamList) {
        this.userExamList = userExamList;
    }

    public User(int role_id, String email, String firstName, String lastName, Role userRole) {
        this.role_id = role_id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
