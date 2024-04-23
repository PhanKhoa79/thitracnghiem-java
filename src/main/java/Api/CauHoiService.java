/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api;

import Entity.CauHoi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class CauHoiService {
    private static final String BASE_URL = "http://localhost:8080/api/cauhoi";
    
    public CauHoi createCauHoi(CauHoi cauHoi) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/add/question");
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(cauHoi), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8")); 
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), CauHoi.class);
    }
    
    public CauHoi updateCauHoi(int id, CauHoi cauHoi) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL + "/update/question?id=" + id);
        httpPut.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(cauHoi), StandardCharsets.UTF_8);
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), CauHoi.class);
    }
    
    public boolean deleteCauHoi(int id) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(BASE_URL + "/delete/question?id=" + id);
        
        CloseableHttpResponse response = client.execute(httpDelete);
        return response.getStatusLine().getStatusCode() == 200;
    }
    
    public List<CauHoi> getAllCauHoiByUrl(String url) throws IOException {
        List<CauHoi> listCauHoi = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listCauHoi = new ObjectMapper().readValue(result.toString(), new TypeReference<List<CauHoi>> () {});
        return listCauHoi;
    }
    
    public List<CauHoi> getAllCauHoi() throws IOException{
        return getAllCauHoiByUrl("/questions");
    }
    
    public List<CauHoi> getAllCauHoiByIdMonThi(String idMonThi) throws IOException {
        return getAllCauHoiByUrl("/questions/q1?id=" + idMonThi);
    }
    
    public List<CauHoi> getAllCauHoiByIdDeThi(String idDeThi) throws IOException {
        return getAllCauHoiByUrl("/questions/q4?id=" + idDeThi);
    }
    
    public List<CauHoi> getAllCauHoiByIdMonThiAndIdChuong(String idMonThi, String idChuong) throws IOException {
        return getAllCauHoiByUrl("/questions/q2?id1=" + idMonThi + "&id2=" + idChuong);
    }
    
    public List<CauHoi> getAllCauHoiIdMonThiAndIdMucDo(String idMonThi, String idMucDo) throws IOException {
        return getAllCauHoiByUrl("/questions/q3?id1=" + idMonThi + "&id2=" + idMucDo);
    }
    
    public List<CauHoi> getAllCauHoiByKeyWord(String keyword) throws IOException{
        String encodedKeyWord = URLEncoder.encode(keyword, "UTF-8");
        return getAllCauHoiByUrl("/questions/searchBy?keyword=" + encodedKeyWord);
    }
    
    public CauHoi getCauHoiById(int idCauHoi) throws IOException {
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/question/" + idCauHoi);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
         return new ObjectMapper().readValue(result.toString(), CauHoi.class);
    }
    
    public List<Object[]> getAllCauHoiByDeThiId(String idDeThi) throws IOException {
        List<Object[]> listCauHoi = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/questions/q5?id=" + idDeThi);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listCauHoi = new ObjectMapper().readValue(result.toString(), new TypeReference<List<Object[]>> () {});
        return listCauHoi;
    }
}
