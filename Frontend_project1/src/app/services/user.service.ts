import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  register(user: { uname: string; uemail: string; upassword: string; uaddress: string; uage: null; uphonenumber: string; }) {
    throw new Error('Method not implemented.');
  }
  getAllUsers() {
    return this.httpClient.get<any>(`${this.apiurl}/`)
  }
apiurl="http://localhost:8080"
  constructor(private httpClient:HttpClient)
   { 
    
   }
}
