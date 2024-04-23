/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api;

import Entity.KetQuaThi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Khoahihi79
 */
public class KetQuaThiService {
    private static final String BASE_URL = "http://localhost:8080/api/ketquathi";

    public KetQuaThi createKetQuaThi(KetQuaThi kqThi) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/add/result");
        httpPost.setHeader("Content-Type", "application/json");
        
        StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(kqThi), StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        
        CloseableHttpResponse response = client.execute(httpPost);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder result = new StringBuilder();
        while((line = reader.readLine()) != null) {
            result.append(line);
        } 
            return new ObjectMapper().readValue(result.toString(), KetQuaThi.class);
    }
    
    public List<KetQuaThi> getAllById(String url) throws IOException {
        List<KetQuaThi> listKetQuaThi = new ArrayList<>();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + url);

        CloseableHttpResponse response = client.execute(httpGet);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        listKetQuaThi = new ObjectMapper().readValue(result.toString(), new TypeReference<List<KetQuaThi>> () {});
        return listKetQuaThi;
    }

    public List<KetQuaThi> getAllByIdMonThi(String idMonThi) throws IOException {
        return getAllById("/results/r1?id=" + idMonThi);
    }

    public List<KetQuaThi> getAllByIdMonThiAndIdLop(String idMonThi, String idLop) throws IOException {
        return getAllById("/results/r2?id1=" + idMonThi + "&id2=" + idLop);
    }

    public List<KetQuaThi> getAllByIdConditions(String idMonThi, String idLop, double diem1, double diem2) throws IOException {
        return getAllById("/results/r3/" + idMonThi + "/" + idLop + "/" + diem1 + "/" + diem2);
    }
    
    public List<KetQuaThi> getAllByIdSinhVien(String idSinhVien) throws IOException{
        return getAllById("/results/r4?id=" + idSinhVien);
    }
}
