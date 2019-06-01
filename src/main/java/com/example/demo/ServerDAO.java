package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ServerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "SELECT * FROM public.light;";
    int id;

    public List<Light> getAll() {

        List light = new ArrayList<Light>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);


        for (Map<String, Object> row : rows) {

            Light light1 = new Light();
            light1.setId((int) row.get("id"));
            light1.setStatus((int)row.get("command"));

            light.add(light1);
        }

        return light;
    }

    public void set() {

        if(check()==0) {
            jdbcTemplate.execute("INSERT INTO public.light (\"command\") VALUES ('1');");
        }
        else {
            jdbcTemplate.execute("INSERT INTO public.light (\"command\") VALUES ('0');");
        }
    }

    public int check() {

        try {
            id = Math.toIntExact((int) jdbcTemplate.queryForList("select \"command\" from public.light").get(0).get("command"));

        } catch (Exception e) {
            id = 0;
            System.out.println(e);
        }
        return id;
    }

}