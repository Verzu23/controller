package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ServerController {

    @Autowired
    public ServerDAO dao;


    //API ENDPOINT USATI COME TEST
    @GetMapping(path = "/all")
    public @ResponseBody
    int getAllUsers(@RequestParam String Nome, @RequestParam String Cognome) {

        dao.insert(Nome, Cognome);

        return 100;
    }


    @GetMapping(path = "/al")
    public @ResponseBody
    long getAlUsers() {
        // This returns a JSON or XML with the users
        return dao.index();
    }
    //-----------------------------------------------------------------


    //API ENDPOINT USATI DALL'APPLICAZIONE MOBILE
    @RequestMapping(path = "/AddPatient", method = RequestMethod.POST)
    @ResponseBody
    public Integer addPatient(@RequestBody Paziente Paz) {

        int status;
        Paziente paz = Paz;
        int foundId = dao.checkPatient(paz.getCF());

        if (foundId==0) {
            dao.addNewPatient(paz.getCF(), paz.getNome(), paz.getCognome(), paz.getSesso(), paz.getBirthday(), paz.getResidenza(),
                    paz.getTelefono(), paz.getAltezza(), paz.getPeso());
            status = 0;
        } else {

            //status = (int) foundId;
            status=foundId;
        }
        return status;
    }

    @RequestMapping(path = "/AddExam", method = RequestMethod.POST)
    @ResponseBody
    public Integer addExam(@RequestBody Esame JsonEsame) {

        int status;
        Esame esa = JsonEsame;
        int foundId = dao.checkExam(esa.getData());

        if (foundId==0) {
            dao.addNewExam(esa.getData(), esa.getIdEsame(),esa.getEmgMax(), esa.getEmgMin(), esa.getEmgAvg(), esa.getForMax(), esa.getForMin(), esa.getForAvg(),
                    esa.getTempo(), esa.getPassi(), esa.getFrequenza(), esa.getVelocita(),dao.checkPatient(esa.getCF()));
            status = 0;
        } else {
            //status = (int) foundId;
            status=499;
        }
        return status;
    }

    //-----------------------------------------------------------------


    //API ENDPOINT USATI DAL FRONTEND
    @RequestMapping("/getPatients")
    public List<Paziente> customerInformation() {
        List<Paziente> paziente = dao.getAll();
        return paziente;
    }

    @GetMapping(path = "/getById")
    public @ResponseBody
    List<Paziente> getAllUsers(@RequestParam int id) {

        List<Paziente> paziente = dao.getById(id);
        return paziente;
    }


    @GetMapping(path = "/getByName")
    public @ResponseBody
    List<Paziente> getAllUsers(@RequestParam String Nome) {

        List<Paziente> paziente = dao.getByName(Nome);

        return paziente;
    }

    @GetMapping(path = "/getEsami")
    public @ResponseBody
    List<Esame> getEsami(@RequestParam int idPaziente) {

        List<Esame> Esame = dao.getEsami(idPaziente);

        return Esame;
    }

    @GetMapping(path = "/getEsame")
    public @ResponseBody
    List<Esame> getEsame(@RequestParam int idEsame) {

        List<Esame> Esame = dao.getEsame(idEsame);

        return Esame;
    }
    //-----------------------------------------------------------------

}