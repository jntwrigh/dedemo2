import db.SampleDb;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        InitialData.insert(app);
    }

    static class InitialData {

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
