package util;

import com.google.gson.JsonObject;
import entity.PersonEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/3/4 0004.
 */

public class FaceIdentifyUtil {
    /*进行人脸分析，返回一个人脸的FaceIdEntity
    * */
    public static PersonEntity factdect(String url) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpClient httpclient = (HttpClient) HttpSSLUtil.createHttpClients();
        PersonEntity face =new PersonEntity();
     ;
        JSONObject jso = new JSONObject();
        try {
            jso.put("url",url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/face/v1.0/detect");
            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "1ba9810faf4e4883afccca31c2695ef4");
            // Request body
            StringEntity reqEntity = new StringEntity(jso.toString(), "utf-8");
            request.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(request);
            //  HttpEntity entity = response.getEntity();
            HttpEntity entity = response.getEntity();
            String str1 = response.getStatusLine().toString();
            if ((entity != null)&&str1.equals("HTTP/1.1 200 OK")) {
                String str = EntityUtils.toString(entity);
                str = str.substring(1,str.length()-1);

                JSONObject jsonObject =JSONObject.fromObject(str);

                face.setFaceid(jsonObject.getString("faceId"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return face;
    }

    /*训练一个Group*/
    public static void traingroup(String groupid) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        HttpClient httpclient = (HttpClient) HttpSSLUtil.createHttpClients();
        try
        {
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/face/v1.0/persongroups/"+groupid+"/train");
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "1ba9810faf4e4883afccca31c2695ef4");
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*在一个group里面增加一个人，返回一个PersonEntity实体包含这个人的PersistedFaceId*/
    public static String createaperson(String groupId, String peoplename, String peopledata) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        HttpClient httpclient = (HttpClient) HttpSSLUtil.createHttpClients();
        String str=null;
        JSONObject json = new JSONObject();
        try {
            json.put("name", peoplename);
            json.put("userData", peopledata);
        }catch (Exception e ){
            e.printStackTrace();
        }
        try{
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/face/v1.0/persongroups/"+groupId+"/persons");
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "1ba9810faf4e4883afccca31c2695ef4");


            // Request body
            StringEntity reqEntity = new StringEntity(json.toString(), "utf-8");
            request.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                str = EntityUtils.toString(entity);
              //  System.out.println(str);
                JSONObject jsonObject =JSONObject.fromObject(str);

               str=jsonObject.getString("personId");

                //System.out.println(person.getPersonid());

            }
        } catch (Exception e) {
            e.printStackTrace();


        }
        return str;
    }
    /*往一个Group的一个person上面上传照片，返回实体的*/
    public static String addface(String url, String personId, String groupId) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        HttpClient httpclient = (HttpClient) HttpSSLUtil.createHttpClients();
        String str = null;
        JSONObject json = new JSONObject();
        try {
            json.put("url", url);
        }catch (Exception e){
            e.printStackTrace();
        }
        try
        {
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/face/v1.0/persongroups/"+groupId+"/persons/"+personId+"/persistedFaces");



            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "1ba9810faf4e4883afccca31c2695ef4");


            // Request body
            StringEntity reqEntity = new StringEntity(json.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            String str1 = response.getStatusLine().toString();
            if (entity != null&&str1.equals("HTTP/1.1 200 OK"))
            {

                JSONObject jsonObject =JSONObject.fromObject(EntityUtils.toString(entity));
                str=jsonObject.getString("persistedFaceId");
                return str;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return str;
    }
    public static PersonEntity faceident(String groupId, String faceId, int maxNumOfCandidatesReturned, double confidenceThreshold) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        HttpClient httpclient = (HttpClient) HttpSSLUtil.createHttpClients();
        PersonEntity identity = new PersonEntity();
        JSONArray array = new JSONArray();
        JSONObject json = new JSONObject();
        try{
            json.put("personGroupId",groupId);
            array.add(0,faceId);
            json.element("faceIds",array);
            json.put("maxNumOfCandidatesReturned",maxNumOfCandidatesReturned);
            json.put("confidenceThresholds",confidenceThreshold);
        }catch(Exception e){
            e.printStackTrace();
        }
        try
        {
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/face/v1.0/identify");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "1ba9810faf4e4883afccca31c2695ef4");


            // Request body
            StringEntity reqEntity = new StringEntity(json.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            String str1 = response.getStatusLine().toString();
            if ((entity != null)&&str1.equals("HTTP/1.1 200 OK"))
            {
                String str = EntityUtils.toString(entity);
                str= str.substring(1,str.length()-1);
                JSONObject jsonResult = JSONObject.fromObject(str);
                identity.setFaceid(jsonResult.getString("faceId"));

                JSONArray arrayResult = jsonResult.getJSONArray("candidates");

                JSONObject jsonResultCondates = JSONObject.fromObject(arrayResult.get(0));
                identity.setConfidence(jsonResultCondates.getString("confidence"));
                identity.setPersonid(jsonResultCondates.getString("personId"));
                System.out.println(identity.getPersonid());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return identity;
    }

}
