package ap.myapplication;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankit on 1/10/2015.
 */
public class CarControl {
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
    public Boolean checkTrunk() {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://api.hackthedrive.com/vehicles/" + MainActivity.VIN + "/trunk/");
        try {
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

            JSONObject jsonobj = new JSONObject();
            StringEntity se = new StringEntity(jsonobj.toString());
            se.setContentType("application/json;charset=UTF-8");
            post.setEntity(se);

            HttpResponse response = client.execute(post);
            InputStream a = response.getEntity().getContent();
            String l = convertInputStreamToString(a);
            Log.d("lights", l);
            int frontHelper = l.indexOf("isFrontOpen");
            int rearHelper = l.indexOf("isBackOpen");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("lights failed", e.toString());
            return false;
        }
    }
}
