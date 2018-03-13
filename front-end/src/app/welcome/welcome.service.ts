import {Injectable, NgModule} from '@angular/core';
import {HttpClient} from '@angular/common/http';



class Category {
}

@Injectable()
export class WelcomeService {
  url:string = "http://localhost:8080/api/hello";
  constructor(private http:HttpClient) { }

  getWithPromise(): Promise<string> {
    return this.http.get(this.url).toPromise()
      .then(this.extractData);
  }
   private extractData(res: Response) {
    let body = res.text();
    return body;
  }
}
