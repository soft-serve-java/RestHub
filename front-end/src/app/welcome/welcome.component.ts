import { Component, OnInit } from '@angular/core';
import {WelcomeService} from "./welcome.service";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  myString:string;
  constructor(public welcomeservice: WelcomeService) { }

  ngOnInit() {
    this.welcomeservice.getWithPromise()
      .then(value=>this.myString=value);
  }

}
