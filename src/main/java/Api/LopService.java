/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api;

import Entity.Lop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class LopService {
    
    private static final String BASE_URL = "http://localhost:8080/api/lop";
    
    public List<Lop> getAllByUrl(String url) throws IOException {
        List<Lop> listLop = new ArrayList<>();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);

        CloseableHttpResponse response = client.execute(httpGet);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        listLop = new ObjectMapper().readValue(result.toString(), new TypeReference<List<Lop>> () {});
        return listLop;
    }
    
    public List<Lop> getAllLopByIdKhoa(String idKhoa) throws IOException {
        return getAllByUrl("/classes?id=" + idKhoa);
    }
    
    public List<Lop> getAllLop() throws IOException {
        return getAllByUrl("/classes1");
    }
    
    public String getIdByName(String tenLop) throws IOException {
        String encodedTenLop = URLEncoder.encode(tenLop, "UTF-8");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/class?name=" + encodedTenLop);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return result.toString();
    }
}
