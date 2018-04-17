import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class StaticticService {

  constructor(@Inject('API_URL') private rootApi: string, private http:HttpClient) { }

  public getPopulars():Promise<any>{
    return this.http.get(this.rootApi+"statistic/populars").toPromise();
  }

}
