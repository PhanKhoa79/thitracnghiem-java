/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api;

import Entity.SinhVien;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class SinhVienService {
    
    private static final String BASE_URL = "http://localhost:8080/api/sinhvien";
    
    public SinhVien createSinhVien(SinhVien sinhVien) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/add/student"); //http://localhost:8080/api/sinhvien/add/student
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(sinhVien), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        if(response.getStatusLine().getStatusCode() == 201) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8")); 
            String line;
            StringBuilder result = new StringBuilder();
            while((line = reader.readLine()) != null) {
                result.append(line);
            }

            return new ObjectMapper().readValue(result.toString(), SinhVien.class);
        } else {
            return null;
        }
    }
    
    public SinhVien updateSinhVien(String idSinhVien, SinhVien sinhVien) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL + "/update/student?id=" + idSinhVien);
        httpPut.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(sinhVien), StandardCharsets.UTF_8);
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), SinhVien.class);
    }
    
    public boolean updateAnhSinhVien(String idSinhVien, byte[] anhSinhVien) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(BASE_URL + "/student/" + idSinhVien + "/image");

            ByteArrayEntity entity = new ByteArrayEntity(anhSinhVien);
            httpPut.setEntity(entity);

            CloseableHttpResponse response = client.execute(httpPut);

            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            }
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Lỗi khi gửi yêu cầu cập nhật ảnh sinh viên!");
        }
}
     
    
    public boolean deleteSinhVien(String idSinhVien) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(BASE_URL + "/delete/student?id=" + idSinhVien);
        
        CloseableHttpResponse response = client.execute(httpDelete);
        return response.getStatusLine().getStatusCode() == 200;
    }
    
    public List<SinhVien> getAllByUrl(String url) throws IOException {
        List<SinhVien> listSinhVien = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        listSinhVien = new ObjectMapper().readValue(result.toString(), new TypeReference<List<SinhVien>> () {});
        return listSinhVien;
    }
    
    public List<SinhVien> getAllSinhVien() throws IOException {
        return getAllByUrl("/students");
    }
    
    public List<SinhVien> getAllSinhVienByIdKhoa(String idKhoa) throws IOException {
        return getAllByUrl("/students/s1/" + idKhoa);
    }
    
    public List<SinhVien> getAllSinhVienByIdLop(String idLop) throws IOException {
        return getAllByUrl("/students/s2/" + idLop);
    }
    
    public List<SinhVien> getAllSinhVienByKeyword(String keyword) throws IOException {
        String encodedKeyword  = URLEncoder.encode(keyword, "UTF-8");
        return getAllByUrl("/students/search?keyword=" + encodedKeyword);
    }
}
