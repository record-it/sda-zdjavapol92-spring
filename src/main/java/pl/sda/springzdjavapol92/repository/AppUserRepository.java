package pl.sda.springzdjavapol92.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springzdjavapol92.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
