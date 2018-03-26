import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  password:string;
  email:string;
  login:string;
  constructor(public authservice:AuthService){ }

  ngOnInit() {
  }
  registration(){
    let user:User = new User(this.login, this.email, this.password);
    console.log(user);
    this.authservice.register(user);
    //TODO:confirmation after!!!!!!!!!!!!(Router to conf + in back-end)
  }

}
