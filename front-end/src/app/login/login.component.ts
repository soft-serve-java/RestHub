import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";
import {headersToString} from "selenium-webdriver/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  password:string;
  email:string;
  token:string;

  constructor(public authSevice:AuthService) { }

  ngOnInit() {
  }
  login(){
    console.log(this.email + " " + this.password);
    this.authSevice.logUserIn(this.email, this.password).then(res=> console.dir(res));
    //console.log(this.token);
  }

}
