package pl.coderslab.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByTelephone(String email);

    @Query("select a from Owner a where a.telephone like ?1%")
    Owner findByTelephoneQuery(String email);


}