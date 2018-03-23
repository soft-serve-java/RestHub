import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {JwtHelperService} from "@auth0/angular-jwt";
import {Router} from "@angular/router";

@Injectable()
export class AuthService {
  public jwtHelper: JwtHelperService = new JwtHelperService();
  constructor(private http:HttpClient, public router:Router) { }

  logUserIn(username:string, password:string):Promise<any>{
    return this.http.post("http://localhost:9090/login", {username:username, password:password},
      {observe:'response' }).toPromise();
  }
  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !this.jwtHelper.isTokenExpired(token);
  }
  logout() {
    this.http.post('http://localhost:9090/logout', {}).finally(() => {
      this.router.navigateByUrl('/login');
      localStorage.removeItem("token");
    }).subscribe();
  }
}
