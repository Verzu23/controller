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

    private static final String SQL = "SELECT * FROM sarcopenia_db.paziente ORDER BY \"idPaziente\" ASC;";
    int id;

    public List<Paziente> getAll() {

        List<Paziente> pazienti = new ArrayList<Paziente>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);


        for (Map<String, Object> row : rows) {

            Paziente paziente = new Paziente();
            paziente.setId((int) row.get("idPaziente"));
            paziente.setCF((String) row.get("CF"));
            paziente.setNome((String) row.get("Nome"));
            paziente.setCognome((String) row.get("Cognome"));
            paziente.setBirthday((String) row.get("Birthday"));
            paziente.setSesso((String) row.get("Sesso"));
            paziente.setResidenza((String) row.get("Residenza"));
            paziente.setTelefono((String) row.get("Telefono"));
            paziente.setAltezza((int) row.get("Altezza"));
            paziente.setPeso((int) row.get("Peso"));

            pazienti.add(paziente);
        }

        return pazienti;
    }

    public void insert(String nome, String cognome) {

        try {
            id = Math.toIntExact((int) jdbcTemplate.queryForList("SELECT max(\"idPaziente\") as \"max\" FROM sarcopenia_db.paziente").get(0).get("max"));

        } catch (Exception e) {
            id = 0;
        }
        id++;
        jdbcTemplate.execute("INSERT INTO sarcopenia_db.paziente (\"idPaziente\", \"Nome\", \"Cognome\") VALUES ( " + id + ", '" + nome + "', '" + cognome + "');");

    }

    public int index() {

        try {
            id = Math.toIntExact((int) jdbcTemplate.queryForList("SELECT max(\"idPaziente\") as \"max\" FROM sarcopenia_db.paziente").get(0).get("max"));

        } catch (Exception e) {
            id = 0;
            System.out.println(e);
        }
        return id;
    }

    public void addNewPatient(String CF, String Nome, String Cognome, String Sesso, String Birthday, String Residenza, String Telefono, long Altezza, long Peso) {

        try {
            id = Math.toIntExact((int) jdbcTemplate.queryForList("SELECT max(\"idPaziente\") as \"max\" FROM sarcopenia_db.paziente").get(0).get("max"));

        } catch (Exception e) {
            id = 0;
        }
        id++;
        jdbcTemplate.execute("INSERT INTO sarcopenia_db.paziente (\"idPaziente\", \"Nome\", \"Cognome\", \"Birthday\", \"Sesso\", \"Residenza\", \"Telefono\", \"Altezza\", \"Peso\",\"CF\") " +
                "VALUES ('" + id + "', '" + Nome + "', '" + Cognome + "', '" + Birthday + "', '" + Sesso + "', '" + Residenza + "', '" + Telefono + "', '" + Altezza + "', '" + Peso + "', '" + CF + "');");
    }

    public void addNewExam(String Data, int idEsame, float emgMax, float emgMin, float emgAvg, float forMax, float forMin, float forAvg, float tempo, float passi, float frequenza, float velocita, int idpaz){

        try {
            id = Math.toIntExact((int) jdbcTemplate.queryForList("SELECT max(\"idEsame\") as \"max\" FROM sarcopenia_db.esame").get(0).get("max"));

        } catch (Exception e) {
            id = 0;
        }
        id++;

        jdbcTemplate.execute("INSERT INTO sarcopenia_db.esame(\"idEsame\", \"EMG_Max\", \"EMG_Min\", \"EMG_Avg\", \"Forza_Max\", \"Forza_Min\", \"Forza_Med\", \"Tempo_Prova\", \"Passi\", \"Frequenza_Passi\", \"Velocita\", \"Data\", \"Paziente_idPaziente\")" +
                "VALUES ('" + id + "', '"+emgMax+"', '"+emgMin+"', '"+emgAvg+"', '"+forMax+"', '"+forMin+"', '"+forAvg+"', '"+tempo+"', '"+passi+"', '"+frequenza+"', '"+velocita+"', '"+Data+"', '"+idpaz+"');");

        System.out.println("INSERT INTO sarcopenia_db.esame(\"idEsame\", \"EMG_Max\", \"EMG_Min\", \"EMG_Avg\", \"Forza_Max\", \"Forza_Min\", \"Forza_Med\", \"Tempo_Prova\", \"Passi\", \"Frequenza_Passi\", \"Velocita\", \"Data\", \"Paziente_idPaziente\")" +
                "VALUES ('" + id + "', '"+emgMax+"', '"+emgMin+"', '"+emgAvg+"', '"+forMax+"', '"+forMin+"', '"+forAvg+"', '"+tempo+"', '"+passi+"', '"+frequenza+"', '"+velocita+"', '"+Data+"', '"+idpaz+"');");
    }


    public int checkPatient(String CF) {

        List<Paziente> pazienti = new ArrayList<Paziente>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("Select * from sarcopenia_db.paziente where \"CF\"='" + CF + "'");
        int ID;

        if (rows.isEmpty()) {

            ID = 0;

        } else {
            for (Map<String, Object> row : rows) {
                Paziente paziente = new Paziente();
                paziente.setId((int) row.get("idPaziente"));
                paziente.setNome((String) row.get("Nome"));
                paziente.setResidenza((String) row.get("Cognome"));

                pazienti.add(paziente);
            }
            ID = pazienti.get(0).getId();
        }
        return ID;
    }

    public int checkExam(String CF) {

    // TODO: 15/05/2019  inizializzare metodo

        return 0;
    }



    public List<Paziente> getById(int id) {

        List<Paziente> pazienti = new ArrayList<Paziente>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("Select * from sarcopenia_db.paziente where \"idPaziente\"='" + id + "'");

        for (Map<String, Object> row : rows) {
            Paziente paziente = new Paziente();
            paziente.setId((int) row.get("idPaziente"));
            paziente.setCF((String) row.get("CF"));
            paziente.setNome((String) row.get("Nome"));
            paziente.setCognome((String) row.get("Cognome"));
            paziente.setBirthday((String) row.get("Birthday"));
            paziente.setSesso((String) row.get("Sesso"));
            paziente.setResidenza((String) row.get("Residenza"));
            paziente.setTelefono((String) row.get("Telefono"));
            paziente.setAltezza((int) row.get("Altezza"));
            paziente.setPeso((int) row.get("Peso"));

            pazienti.add(paziente);
        }

        return pazienti;
    }

    public List<Paziente> getByName(String name) {

        List<Paziente> pazienti = new ArrayList<Paziente>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("Select * from sarcopenia_db.paziente where \"Nome\" ~* '" + name + "' or \"Cognome\" ~* '"+name+"'" );

        for (Map<String, Object> row : rows) {
            Paziente paziente = new Paziente();
            paziente.setId((int) row.get("idPaziente"));
            paziente.setCF((String) row.get("CF"));
            paziente.setNome((String) row.get("Nome"));
            paziente.setCognome((String) row.get("Cognome"));
            paziente.setBirthday((String) row.get("Birthday"));
            paziente.setSesso((String) row.get("Sesso"));
            paziente.setResidenza((String) row.get("Residenza"));
            paziente.setTelefono((String) row.get("Telefono"));
            paziente.setAltezza((int) row.get("Altezza"));
            paziente.setPeso((int) row.get("Peso"));

            pazienti.add(paziente);
        }

        return pazienti;
    }

    public List<Esame> getEsami(long id) {

        List<Esame> esami = new ArrayList<Esame>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("Select * from sarcopenia_db.esame where \"Paziente_idPaziente\" = '" + id + "'Order by \"Data\" DESC");

        for (Map<String, Object> row : rows) {
            Esame esame = new Esame();

            esame.setData((String) row.get("Data"));
            esame.setIdPaziente((int) row.get("Paziente_idPaziente"));
            esame.setIdEsame((int) row.get("idEsame"));

            esame.setEmgMax((float )row.get("EMG_Max"));
            esame.setEmgMin((float) row.get("EMG_Min"));
            esame.setEmgAvg((float) row.get("EMG_Avg"));

            esame.setForMax((float) row.get("Forza_Max"));
            esame.setForMin((float) row.get("Forza_Min"));
            esame.setForAvg((float) row.get("Forza_Med"));

            esame.setTempo((float) row.get("Tempo_Prova"));
            esame.setPassi((float) row.get("Passi"));
            esame.setVelocita((float) row.get("Velocita"));
            esame.setFrequenza((float) row.get("Frequenza_Passi"));

            esami.add(esame);
        }

        return esami;
    }

    public List<Esame> getEsame(long id) {

        List<Esame> esami = new ArrayList<Esame>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("Select * from sarcopenia_db.esame where \"idEsame\" = '" + id + "'");

        for (Map<String, Object> row : rows) {
            Esame esame = new Esame();

            esame.setData((String) row.get("Data"));
            esame.setIdPaziente((int) row.get("Paziente_idPaziente"));
            esame.setIdEsame((int) row.get("idEsame"));

            esame.setEmgMax((float) row.get("EMG_Max"));
            esame.setEmgMin((float) row.get("EMG_Min"));
            esame.setEmgAvg((float) row.get("EMG_Avg"));

            esame.setForMax((float) row.get("Forza_Max"));
            esame.setForMin((float) row.get("Forza_Min"));
            esame.setForAvg((float) row.get("Forza_Med"));

            esame.setTempo((float) row.get("Tempo_Prova"));
            esame.setPassi((float) row.get("Passi"));
            esame.setVelocita((float) row.get("Velocita"));
            esame.setFrequenza((float) row.get("Frequenza_Passi"));

            esami.add(esame);
        }

        return esami;
    }


}