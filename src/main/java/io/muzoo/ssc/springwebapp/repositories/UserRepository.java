package io.muzoo.ssc.springwebapp.repositories;

import io.muzoo.ssc.springwebapp.dto.UserDTO;
import io.muzoo.ssc.springwebapp.models.User;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    List<User>findUsersByDislikesAndPreferences(Set<String> dislikes, Set<String> preferences);
    Boolean existsByEmail(String email);
//    @Query("SELECT u FROM User u WHERE u.id <> :userId AND u.id IN " +
//            "(SELECT u2.id FROM User u2 JOIN u2.dislikes d WHERE d IN :dislikes)")
//    List<User> findMatchesByDislikes(@Param("userId") Long userId, @Param("dislikes") Set<String> dislikes);

}
