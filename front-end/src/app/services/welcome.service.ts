import {Injectable, NgModule} from '@angular/core';
import {HttpClient} from '@angular/common/http';

class Category {
  private id: number;
  private name: string;
}

@Injectable()
export class WelcomeService {
  url:string = "http://localhost:9090/api/tableStatus";
  constructor(private http:HttpClient) { }

  getWithPromise(): Promise<string> {
    return this.http.get( this.url).toPromise()
      .then(this.extractData.toString);
  }
   private extractData(res: Response) {
    let body = res.text();
    return body;
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
