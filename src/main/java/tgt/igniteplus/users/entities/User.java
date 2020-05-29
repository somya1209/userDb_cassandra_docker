package tgt.igniteplus.users.entities;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.persistence.GeneratedValue;

@Table
public class User {

    @PrimaryKey
    private Long unique_id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String address;
    private int zip_code;

    public User() {
    }

    public User(Long unique_id, String first_name, String last_name, String email_id, String address, int zip_code) {
        this.unique_id = unique_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.address = address;
        this.zip_code = zip_code;
    }

    public Long getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(Long unique_id) {
        this.unique_id = unique_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
