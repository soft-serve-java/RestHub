import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Status} from "../models/status";

@Injectable()
export class StatusService {

  constructor(@Inject('API_URL') private apiUrl: string,
              @Inject(LOCAL_STORAGE) private localStorage: WebStorageService,
              private http:HttpClient) { }

  getAllStatutes():Promise<Status[]>{
      return this.http.get<Status[]>(this.apiUrl + "status").toPromise();
  }

  getNextStatus(status: Status):Promise<Status>{
      return this.http.post<Status>(this.apiUrl + "status/next", status).toPromise();
  }

  saveStatusesToLocalStorage(){
    this.getAllStatutes()
      .then(res=>this.localStorage.set("statuses", res));
  }

  getPreparingStatus(): Status {
    return this.localStorage.get("statuses").filter(status => status.name == 'preparing').pop();
  }


}
