import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthService {

  constructor(private http:HttpClient) { }

  logUserIn(username:string, password:string):Promise<any>{
    return this.http.post("http://localhost:9090/login", {username:username, password:password}).toPromise();
  }

}
