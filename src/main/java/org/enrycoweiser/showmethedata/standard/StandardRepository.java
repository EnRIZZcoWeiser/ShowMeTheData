package org.enrycoweiser.showmethedata.standard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface StandardRepository<E extends StandardEntity> extends JpaRepository<E, Long> {
    default List<E> retrieveAll() {
        return findAll();
    }

    default E retrieveById(Long id) {
        return getReferenceById(id);
    }

    default E saveEntity(E entity) {
        return save(entity);
    }
}
