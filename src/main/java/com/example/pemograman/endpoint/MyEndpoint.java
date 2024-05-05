package com.example.pemograman.endpoint;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.pemograman.model.Users;
import com.example.pemograman.repository.UsersRepository;
import com.example.demo.GetAllUsersRequest;
import com.example.demo.GetAllUsersResponse;
import com.example.demo.MyRequest;
import com.example.demo.MyResponse;


//digenerate jaxb

@Endpoint
public class MyEndpoint {
    
    @Autowired
    private UsersRepository usersRepository;

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "MyRequest")
    @ResponsePayload
    public MyResponse myMethod(@RequestPayload MyRequest request) {
        MyResponse response = new MyResponse();
        response.setResponseMessage("This is a response to: " + request.getRequestMessage());
        return response;
    } 

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "GetAllStudentRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsersResponse(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        List<Users> users = usersRepository.findAll();
        List<com.example.pemograman.model.Users> responseUsers = new ArrayList<>();
        for (Users users2 : users) {
            com.example.pemograman.model.Users responseUsers2 = new com.example.pemograman.model.Users();
            responseUsers2.setId(users2.getId());
            responseUsers2.setEmail(users2.getEmail());
            responseUsers2.setPassword(users2.getPassword());
            responseUsers.add(responseUsers2);
           // System.out.println("Product: " + product.getName());
            
        }
        response.getUsers();
        





        return response;
    }
      
}

