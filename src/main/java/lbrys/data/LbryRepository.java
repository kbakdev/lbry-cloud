package lbrys.data;

import org.springframework.data.repository.CrudRepository;

import lbrys.Lbry;

public interface LbryRepository
        extends CrudRepository<Lbry, Long> {

}