package org.sekou.lisamhotel.repository;

import jakarta.persistence.*;
import org.sekou.lisamhotel.model.Role;
import org.sekou.lisamhotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Collection<Role> roles = new HashSet<>();

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    Optional<Object> findByEmail(String email);
}
