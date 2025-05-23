package com.example.sen4farming.repository;


import com.example.sen4farming.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarPassword(String email, String password);

    Usuario findUsuarioByNombreUsuarioIs(String name);
    Usuario findByEmailAndActiveTrue(String name);

    Usuario findByNombreUsuarioAndActiveTrue(String name);



    Optional<Usuario> findUsuarioByEmailAndActiveTrue(String email);
    Optional<Usuario> findUsuarioByEmailAndTokenAndActiveTrue(String email,String token);
    Usuario findUsuarioByEmailAndPassword(String email, String password);
    //Definir metodo aparte
}
