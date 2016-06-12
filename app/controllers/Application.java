package controllers;

import db.SampleDb;
import play.*;
import play.db.DB;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.sql.Connection;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result page() {
        return ok(views.html.jdbc.render());
    }

    public static Result table() {
        try {
            SampleDb.createTestTable();
            return ok("table created");
        } catch (Exception e) {
            return internalServerError(e.getMessage());
        }
    }

    public static Result test(String value) {
        try {
            SampleDb.insertTestData(value);
            List<String> vs = SampleDb.getTestData();
            return ok(Json.toJson(vs));
        } catch (Exception e) {
            return internalServerError(e.getMessage());
        }
    }

}
