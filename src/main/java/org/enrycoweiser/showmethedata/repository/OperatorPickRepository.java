package org.enrycoweiser.showmethedata.repository;

import org.enrycoweiser.showmethedata.domain.OperatorPick;
import org.enrycoweiser.showmethedata.repository.custom.MyOperatorPickRepository;
import org.enrycoweiser.showmethedata.standard.StandardRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorPickRepository extends StandardRepository<OperatorPick>, MyOperatorPickRepository {
}
