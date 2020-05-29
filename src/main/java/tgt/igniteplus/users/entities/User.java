package tgt.igniteplus.users.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @PrimaryKey
    private Long unique_id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String address;
    private int zip_code;


}
