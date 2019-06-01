package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(path = "/Check", method = RequestMethod.POST)
    @ResponseBody
    public Integer checkLight(@RequestBody Paziente Paz) {

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

    @RequestMapping(path = "/Set", method = RequestMethod.POST)
    @ResponseBody
    public Integer setLight(@RequestBody Paziente Paz) {

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

}