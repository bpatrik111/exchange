package com.bpatrik.exchange.exchange.repositories;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class SymbolRepositoryImpl implements SymbolRepository {

    private static final String SQL_CREATE =
            "INSERT INTO SYMBOLS (SYMBOLS_ID, NAME VALUES(NEXTVAL('SYMBOLS_SEQ'), ?, ?)";

    private static final String SQL_GET_ALL = "SELECT * FROM SYMBOLS WHERE 1";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer Create(Integer symbol_id, String name) throws BadRequestException{
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, symbol_id);
                ps.setString(2, name);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("SYMBOL_ID");
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public List<Symbol> getAll() throws ResourceNotFoundException {
        return jdbcTemplate.query(SQL_GET_ALL, new Object[]{}, symbolRowMapper);
    }

    private RowMapper<Symbol> symbolRowMapper = ((rs, rowNum) -> {
        return new Symbol(rs.getInt("SYMBOL_ID"),
                rs.getString("NAME"));
    });
}
