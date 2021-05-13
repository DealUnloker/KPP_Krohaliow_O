package services;

import model.Enterprise;
import DAO.EnterpriseDAO;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseService {
    private final EnterpriseDAO enterpriseDAO = new EnterpriseDAO();

    public EnterpriseService() {
    }

    public Enterprise findEnterpriseById(int id) {
        return enterpriseDAO.findById(id);
    }

    // these two methods seem rly bad
    public List<Enterprise> findEnterpriseByService(String service) {
        List<Enterprise> list = enterpriseDAO.findAll();
        List<Enterprise> listWithCoincidences = new ArrayList<Enterprise>();
        for (Enterprise e : list) {
            if (e.getServices().contains(service))
                listWithCoincidences.add(e);
        }
        return listWithCoincidences;
    }

    public Enterprise findEnterpriseByTitle(String title){
        List<Enterprise> list = enterpriseDAO.findAll();
        for (Enterprise e : list) {
            if (e.getTitle().equals(title))
                return e;
        }
        return null;
    }

    public void saveEnterprise(Enterprise enterprise) {
        enterpriseDAO.save(enterprise);
    }

    public void deleteEnterprise(Enterprise enterprise) {
        enterpriseDAO.delete(enterprise);
    }

    public void updateEnterprise(Enterprise enterprise) {
        enterpriseDAO.update(enterprise);
    }

    public List<Enterprise> findAllEnterprises() {
        return enterpriseDAO.findAll();
    }

}
