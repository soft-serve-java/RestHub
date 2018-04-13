import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-token-conferme',
  templateUrl: './token-conferme.component.html',
  styleUrls: ['./token-conferme.component.css']
})
export class TokenConfermeComponent implements OnInit {
  private sub: any;
  tokenIsConfermed:boolean;
  processing:boolean;
  token:string;

  constructor(private route: ActivatedRoute, private authService:AuthService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.token = params['token'];
      console.log(this.token);
    });
    if(this.token!='0') {
      this.processing = true;
      this.authService.confermToken(this.token).then(res=> {this.processing = false; this.tokenIsConfermed = true});
    }
  }

}
