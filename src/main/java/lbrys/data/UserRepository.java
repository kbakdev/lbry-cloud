package lbrys.data;
import org.springframework.data.repository.CrudRepository;
import lbrys.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}