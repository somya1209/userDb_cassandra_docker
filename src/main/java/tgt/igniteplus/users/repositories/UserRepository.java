package tgt.igniteplus.users.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import tgt.igniteplus.users.entities.User;

public interface UserRepository extends CassandraRepository<User,Long> {
}
