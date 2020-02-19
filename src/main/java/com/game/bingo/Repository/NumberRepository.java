package com.game.bingo.Repository;

import com.game.bingo.Models.Number;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends CrudRepository<Number, Long> {
}
