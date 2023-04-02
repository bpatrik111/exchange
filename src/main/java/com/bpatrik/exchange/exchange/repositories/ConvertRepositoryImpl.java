package com.bpatrik.exchange.exchange.repositories;

import com.bpatrik.exchange.exchange.exceptions.BadRequestException;
import com.bpatrik.exchange.exchange.exceptions.ResourceNotFoundException;
import com.bpatrik.exchange.exchange.models.Convert;
import com.bpatrik.exchange.exchange.models.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class ConvertRepositoryImpl implements ConvertRepository{

    private static final String SQL_CREATE =
            "INSERT INTO CONVERTS (CONVERT_ID, FROM_, TO_, RATE VALUES(NEXTVAL('CONVERTS_SEQ'), ?, ?, ?, ?)";

    private static final String SQL_RATE_GET_BY_FROM_TO =
            "SELECT RATE FROM CONVERT WHERE FROM_=? AND TO_=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer Create(Integer convert_id, String from, String to, Integer rate) throws BadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, convert_id);
                ps.setString(2, from);
                ps.setString(2, to);
                ps.setInt(2, rate);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("CONVERT_ID");
        }catch (Exception e) {
            throw new BadRequestException("Invalid request");
        }
    }

    @Override
    public Integer getRateByFromAndTo(String from, String to) throws ResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_RATE_GET_BY_FROM_TO, new Object[]{from, to}, convertRowMapper)
                    .getRate();
        }catch (Exception e) {
            throw new ResourceNotFoundException("Convert not found");
        }
    }

    private RowMapper<Convert> convertRowMapper = ((rs, rowNum) -> {
        return new Convert(rs.getInt("CONVERT_ID"),
                rs.getString("FROM_"),
                rs.getString("TO_"),
                rs.getInt("RATE"));
    });

}
