package com.sxzhongf.karaf.rest.client.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/25
 */
@Service
@Command(scope = "booking", name = "add", description = "add booking")
public class AddBookingCommand implements Action {

    @Argument(index = 0, name = "id", description = "Booking ID", required = true, multiValued = false)
    long id;

    @Argument(index = 1, name = "customer", description = "Customer name", required = true, multiValued = false)
    String customer;

    @Argument(index = 2, name = "flight", description = "Flight number", required = true, multiValued = false)
    String flight;

    @Option(name = "--url", description = "Location of the REST service", required = false, multiValued = false)
    String restLocation = "http://localhost:8181/cxf/booking/";

    @Override
    public Object execute() throws Exception {
        URL url = new URL(restLocation);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        String json = "{"
            + "\"id\": " + id + ","
            + "\"flight\": \"" + flight + "\","
            + "\"customer\": \"" + customer + "\""
            + "}";

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(json);
        writer.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        return null;
    }
}
