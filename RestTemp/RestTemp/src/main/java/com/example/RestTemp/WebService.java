package com.example.RestTemp;

import com.example.RestTemp.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class WebService {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/employes/users",method = RequestMethod.GET)
    public String getemp()
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:1234/emp/users", HttpMethod.GET,entity,String.class).getBody();

    }
    @RequestMapping(value = "/employes/addusers")
    public String postuser(@RequestBody User user)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity=new HttpEntity<>(user,headers);
        return restTemplate.exchange("http://localhost:1234/emp/userdata",HttpMethod.POST,entity,String.class).getBody();
    }
    @RequestMapping(value = "/employes/update/{id}",method = RequestMethod.PUT)
    public String updateemp(@PathVariable("id") String id,@RequestBody User user)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity=new HttpEntity<>(user,headers);
        return restTemplate.exchange("http://localhost:1234/emp/updateuser/"+id,HttpMethod.PUT,entity,String.class).getBody();
    }
    @RequestMapping(value = "/employes/delete/{id}",method = RequestMethod.DELETE)
    public String deleteuser(@PathVariable("id") String id)
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity=new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:1234/emp/deleteuser/"+id,HttpMethod.DELETE,entity,String.class).getBody();
    }
}
