
// 6. Довідник споживача (служба побуту). База підприємств побутового обслуговування міста:
// назва, розряд, адреса та телефони, спеціалізація, перелік надаваних послуг, форма власності,
// години і дні роботи. Пошук підприємств по заданій послузі та іншими ознаками.

import model.Enterprise;
import services.EnterpriseService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        EnterpriseService enterpriseService = new EnterpriseService();

        // Add and show examples
        SaveExampleToBD(enterpriseService);
        ShowEnterprises(enterpriseService.findAllEnterprises());

        // UPDATE
        Enterprise enterprise = enterpriseService.findEnterpriseById(4);
        enterprise.setTitle("TEST131313");
        enterpriseService.updateEnterprise(enterprise);
        System.out.println(enterpriseService.findEnterpriseById(4));

        // Search by services
        List<Enterprise> enterprises = enterpriseService.findEnterpriseByService("service3");
        ShowEnterprises(enterprises);

        // Search by title
        Enterprise enterprise2 = enterpriseService.findEnterpriseByTitle("Enterprise N3");
        ShowEnterprise(enterprise2);

        // Delete using title
        Enterprise enterprise3 = enterpriseService.findEnterpriseByTitle("Enterprise N4");
        enterpriseService.deleteEnterprise(enterprise3);
    }

    private static void SaveExampleToBD(EnterpriseService enterpriseService) {
        Enterprise enterprise = new Enterprise("Enterprise N1", "category1, category2, category3",
                "0123456789", "spec1, spec2, spec3", "service", "public",
                "10:00-17:00");

        enterpriseService.saveEnterprise(enterprise);

        Enterprise enterprise2 = new Enterprise("Enterprise N2", "category3, category2",
                "0123456789", "spec1, spec2, spec3", "service2", "private",
                "08:00-17:00");

        enterpriseService.saveEnterprise(enterprise2);

        Enterprise enterprise3 = new Enterprise("Enterprise N3", "category6, category5, category1",
                "0123456789", "spec1, spec2, spec3", "service3", "public",
                "10:00-20:00");

        enterpriseService.saveEnterprise(enterprise3);

        Enterprise enterprise4 = new Enterprise("Enterprise N4", "category2, category1, category4",
                "0123456789", "spec1, spec2, spec3", "service4, service5", "private",
                "06:00-15:00");
        enterpriseService.saveEnterprise(enterprise4);

        Enterprise enterprise5 = new Enterprise("Enterprise N5", "category5, category5, category9",
                "0123456789", "spec1, spec2, spec3", "service, service5", "public",
                "12:00-15:00");

        enterpriseService.saveEnterprise(enterprise5);

        Enterprise enterprise6 = new Enterprise("Enterprise N6", "category4, category2",
                "0123456789", "spec1, spec2, spec3", "service, service3", "public",
                "19:00-24:00");

        enterpriseService.saveEnterprise(enterprise6);
    }

    private static void ShowEnterprise(Enterprise enterprise) {
        System.out.println(enterprise.toString());
    }

    private static void ShowEnterprises(List<Enterprise> enterprises) {
        for (Enterprise enterprise :
                enterprises) {
            System.out.println(enterprise.toString());
        }
    }
}
