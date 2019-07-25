package com.stackroute.repository;
import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
}
//how the methods save,delete etc are working? these methods are in JPA
//why addRepository works?
//know the repository hierarchy
