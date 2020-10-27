package lbrys.data;

import lbrys.Order;
import lbrys.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

    // tag::findByUser_paged[]
    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);
    // end::findByUser_paged[]

  /*
  // tag::findByUser[]
  List<Order> findByUserOrderByPlacedAtDesc(User user);
  // end::findByUser[]
   */

}