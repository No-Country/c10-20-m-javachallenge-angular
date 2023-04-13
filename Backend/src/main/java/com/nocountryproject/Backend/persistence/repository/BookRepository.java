package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);

    /*@Modifying
    @Query(value = "UPDATE Book SET AVAILABILITY=false WHERE ID=:id") // libro NO DISPONIBLE
    public void changeAvailabilityFalse(@Param("id")Long id);

    @Modifying
    @Query(value = "UPDATE Book SET AVAILABILITY=true WHERE ID=:id") //libro DISPONIBLE
    public void changeAvailabilityTrue(Long idBook);*/

    List<Book> findByAlta(Boolean availability);
}
