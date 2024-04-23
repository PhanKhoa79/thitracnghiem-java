    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api;

import Entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
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
public class UserService {
    private static final String BASE_URL = "http://localhost:8080/api/taikhoan";
    
    public boolean login(String taiKhoan, String matKhau) throws IOException {
        
        String encodedTaiKhoan = URLEncoder.encode(taiKhoan, "UTF-8");       
        String encodedMatKhau = URLEncoder.encode(matKhau, "UTF-8");
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/login/" + encodedTaiKhoan + "/" + encodedMatKhau);

        CloseableHttpResponse response = client.execute(httpGet);
        
        if(response.getStatusLine().getStatusCode() == 200) {
            return true;
        }
        return false;
    }
    
    public Integer phanQuyen(String taiKhoan) throws IOException{
        int role = 0;
        String encodedTaiKhoan = URLEncoder.encode(taiKhoan, "UTF-8");
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/user/role/" + encodedTaiKhoan);

        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        while((line = reader.readLine()) != null) {
            role = Integer.parseInt(line);
        }
        return role;
    }
    
    public User createUser(User user) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/add/user");
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(user));
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), User.class);
    }
    
    public List<User> getAllUsers() throws IOException {
        List<User> danhSachTaiKhoan = new ArrayList<>();
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/users");
        
        CloseableHttpResponse response = client.execute(httpGet);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        danhSachTaiKhoan = new ObjectMapper().readValue(result.toString(), new TypeReference<List<User>> () {});
        return danhSachTaiKhoan;
    }
    
    public User getUserById(String id) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/user/" + id);
        
         CloseableHttpResponse response = client.execute(httpGet);
         
         int statusCode = response.getStatusLine().getStatusCode();
         if(statusCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }      
            return new ObjectMapper().readValue(result.toString(), User.class);
         } else {
             return null; 
         }
    }
    
    public User updateUser(String id, User user) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut  = new HttpPut(BASE_URL + "/update/user?id=" + id);
        httpPut.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(user));
        httpPut.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPut);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        
        return new ObjectMapper().readValue(result.toString(), User.class);
    }
    
    public boolean deleteUser(String id) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(BASE_URL + "/delete/user?id=" + id);
        
        CloseableHttpResponse response = client.execute(httpDelete);
        return response.getStatusLine().getStatusCode() == 200;
    }
}
