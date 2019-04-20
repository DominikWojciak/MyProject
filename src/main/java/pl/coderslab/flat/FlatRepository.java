package pl.coderslab.flat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long>, FlatDao {

    List<Flat> findByProposition(boolean proposition);

    List<Flat> findByPrice(String price);

    @Query("select b from Flat b where b.price = ?1")
    List<Flat> findByPriceQuery(String price);

    @Query(value = "select * from flats where myprice = ?1", nativeQuery = true)
    List<Flat> findByPriceNativeQuery(String price);

    List<Flat> findByCategoryId(Long id);

    @Query("select b from Flat b where b.category.id = :categoryId")
    List<Flat> findByCategoryIdQuery(@Param("categoryId") Long id);

    List<Flat> findByOwners(Long id);

    List<Flat> findByDistrictId(Long id);

    List<Flat> findByYear(int year);

    Flat findFirstByCategoryIdOrderByPrice(Long id);

    @Query("select b from Flat b where b.year between ?1 and ?2")
    List<Flat> findByYearBetweenQuery(int min, int max);

    @Query("select b from Flat b where b.district.id = :districtId")
    List<Flat> findByDistrictQuery(@Param("districtId") Long id);

    @Query(value = "select * from flats where category_id = ?1 order by myprice asc limit 1", nativeQuery = true)
    Flat findFirstByCategoryIdOrderByPriceQuery(Long id);

}
