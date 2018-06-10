package api.repository;

import api.entity.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinRepository extends JpaRepository<Bin, Long> {

    List<Bin> findAllByCity(String city);

    Bin findBinByLatitudeAndLongitude(Long latitude, Long longitude);
}


