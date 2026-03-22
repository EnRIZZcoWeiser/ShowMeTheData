package org.enrycoweiser.showmethedata.repository;

import org.enrycoweiser.showmethedata.domain.Round;
import org.enrycoweiser.showmethedata.repository.custom.MyRoundRepository;
import org.enrycoweiser.showmethedata.standard.StandardRepository;
import org.springframework.stereotype.Repository;

public interface RoundRepository extends StandardRepository<Round>, MyRoundRepository {
}
