package com.example.massages.repositories;

import com.example.massages.models.Publication;
import com.example.massages.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

    public List<Publication> findByIdAndAndUser(Long id, User user);
}
