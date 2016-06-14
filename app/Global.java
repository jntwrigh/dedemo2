import db.SampleDb;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

import static db.SampleDb.deleteTestTable;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        InitialData.insert(app);
    }
    public void onStop(Application app) {
        InitialData.cleanDB(app);
    }

    static class InitialData {

        @SuppressWarnings("unchecked")
        public static void cleanDB(Application app) {
            try {
                deleteTestTable();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        @SuppressWarnings("unchecked")
		public static void insert(Application app) {
            try {
                SampleDb.createTestTable();
                SampleDb.insertTestData("firstvalue");
                SampleDb.insertTestData("secondvalue");
                SampleDb.insertTestData("thirdvalue");


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
